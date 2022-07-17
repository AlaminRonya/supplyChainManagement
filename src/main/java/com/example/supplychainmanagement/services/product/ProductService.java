package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.ProductConverter;
import com.example.supplychainmanagement.dto.request.ProductDto;
import com.example.supplychainmanagement.dto.request.ProductInventoryDto;
import com.example.supplychainmanagement.dto.response.ResponseProductDto;
import com.example.supplychainmanagement.entities.*;
import com.example.supplychainmanagement.repositories.product.ProductRepo;
import com.example.supplychainmanagement.services.AttachmentService;
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
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private ProductInventoryService productInventoryService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductConverter productConverter;

    private final LocalDate localDate = LocalDate.now();


    public void insert(ProductDto productDto, MultipartFile productImage, String realPath) throws IOException {

        final Attachment attachment = imageUpload(productImage, realPath);


        final ProductCategory productCategory = categorySearchByName(productDto.getCategoryName());
        final Discount discount = discountService.getDiscountByName(productDto.getDiscountName());
        final ProductInventory productInventory = addInventory(productDto.getQuantity());


        if (attachment != null && productCategory != null && discount != null && productInventory != null){
            final Attachment attachment1 = attachmentService.addAttachment(attachment);

            addProduct(productConverter.getProduct(productDto) , List.of(attachment1),
                    productInventory,
                    productCategory, discount);

        }else {
            System.out.println("Not insert!");
        }


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




    private ProductCategory categorySearchByName(String categoryName) {
        return productCategoryService.getProductCategoryByName(categoryName);
    }

    private Attachment imageUpload(MultipartFile productImage, String realPath) throws IOException {
        return Utils.saveFile(productImage, realPath);
    }

    public ResponseProductDto getProductById(Long id) {
        final Product product = searchById(id);
        if (product != null){
            return productConverter.getResponseProductDto(product);
        }

        return null;
    }

    public ProductDto getProductDtoById(Long id, ProductDto dto) {
        final Product product = searchById(id);
        if (product != null){
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setSKU(product.getSKU());
            dto.setPrice(product.getPrice());
            dto.setQuantity(product.getProductInventory().getQuantity());
            dto.setCategoryName(product.getCategory().getName());
            dto.setDiscountName(product.getDiscount().getName());
            return dto;
        }

        return dto;
    }
    public void updateProduct(String id, ProductDto dto, MultipartFile productImage) throws IOException {
        final Product product = searchById(Long.parseLong(id));
        if (product != null){
            if (!Objects.equals(product.getName(), dto.getName())){
                product.setName(dto.getName());
            }
            if (!product.getDescription().equals(dto.getDescription())){
                product.setDescription(dto.getDescription());
            }
            if (!product.getSKU().equals(dto.getSKU())){
                product.setSKU(dto.getSKU());
            }
            if (!product.getPrice().equals(dto.getPrice())){
                product.setPrice(dto.getPrice());
            }
            if (!product.getProductInventory().getQuantity().equals(dto.getQuantity())){
                productInventoryService.update(product.getProductInventory().getId(), dto.getQuantity());
            }
            if (!product.getDiscount().getName().equals(dto.getDiscountName())){
                final Discount discountByName = discountService.getDiscountByName(dto.getDiscountName());
                product.setDiscount(discountByName);
            }
            if (!productImage.isEmpty()){
                final Attachment attachment = imageUpload(productImage, Constant.PRODUCT_UPLOAD_IMAGE_LOCATION);
                attachmentService.updateAttachmentById(product.getPhotosAttachmentList().get(0).getId(), attachment.getAttachmentName());
            }
            productRepo.updateProductById(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getSKU(),
                    product.getPrice(),
                    Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                    product.getDiscount()
            );
        }

    }

    public void deleteProductById(Long id){
        final Product product = searchById(id);
        if (product != null){
            productRepo.deleteProductById(product.getId(),
                    Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            );
        }
    }

    private Product searchById(Long id){
        return productRepo.findById(id).orElse(null);
    }



}
