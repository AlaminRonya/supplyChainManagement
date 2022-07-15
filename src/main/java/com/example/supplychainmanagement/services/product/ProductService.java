package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.ProductConverter;
import com.example.supplychainmanagement.dto.request.ProductDto;
import com.example.supplychainmanagement.dto.request.ProductInventoryDto;
import com.example.supplychainmanagement.dto.response.ResponseProductDto;
import com.example.supplychainmanagement.entities.*;
import com.example.supplychainmanagement.repositories.AttachmentRepo;
import com.example.supplychainmanagement.repositories.product.DiscountRepo;
import com.example.supplychainmanagement.repositories.product.ProductCategoryRepo;
import com.example.supplychainmanagement.repositories.product.ProductRepo;
import com.example.supplychainmanagement.utils.Constant;
import com.example.supplychainmanagement.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private AttachmentRepo attachmentRepo;
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private ProductInventoryService productInventoryService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductConverter productConverter;

    private final LocalDate localDate = LocalDate.now();


    public void insert(ProductDto productDto, MultipartFile productImage, String realPath) throws IOException {

        final Attachment attachment = addAttachment(imageUpload(productImage, realPath));
        final ProductCategory productCategory = categorySearchByName(productDto.getCategoryName());
        final Discount discount = discountSearchByName(productDto.getDiscountName());
        final ProductInventory productInventory = addInventory(productDto.getQuantity());


        if (attachment != null && productCategory != null &&
                discount != null && productInventory != null){
            addProduct(productConverter.getProduct(productDto) , List.of(attachment),
                    productInventory,
                    productCategory, discount);

        }else {
            System.out.println("Not insert!");
        }


    }

    private Attachment addAttachment(Attachment imageUpload) {
        return attachmentRepo.save(imageUpload);
    }

    private ProductInventory addInventory(Long quantity) {
        ProductInventoryDto productInventoryDto = new ProductInventoryDto();
        productInventoryDto.setQuantity(quantity);
        return productInventoryService.addProductInventory(productInventoryDto);

    }

    private void addProduct(Product product, List<Attachment> attachment,
                            ProductInventory productInventory,
                            ProductCategory productCategory,
                            Discount discount) {

        product.setCreatedAt(
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
        );
        product.setPhotosAttachmentList(attachment);
        product.setProductInventory(productInventory);
        product.setCategory(productCategory);
        product.setDiscount(discount);

        productRepo.save(product);

//        final Optional<Product> byId = productRepo.findById(save.getId());
//        if (byId.isPresent()){
//            System.out.println(byId.get().getPhotosAttachmentList().get(0).getAttachmentName());
//            System.out.println(byId.get().getCategory().getName());
//        }



    }

    public List<ResponseProductDto> getAllProduct(){
        return productConverter.getAllResponseProductDto(productRepo.findAll());
    }


    private Discount discountSearchByName(String discountName) {
        return discountRepo.findByName(discountName).orElse(null);
    }

    private ProductCategory categorySearchByName(String categoryName) {
        return productCategoryRepo.findByName(categoryName).orElse(null);
    }

    private Attachment imageUpload(MultipartFile productImage, String realPath) throws IOException {
        return Utils.saveFile(productImage, realPath);
    }
}
