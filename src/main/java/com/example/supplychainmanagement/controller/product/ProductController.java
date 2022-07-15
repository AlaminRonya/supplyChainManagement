package com.example.supplychainmanagement.controller.product;

import com.example.supplychainmanagement.dto.request.ProductDto;
import com.example.supplychainmanagement.services.product.DiscountService;
import com.example.supplychainmanagement.services.product.ProductCategoryService;
import com.example.supplychainmanagement.services.product.ProductService;
import com.example.supplychainmanagement.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/api/page/v1/inventory/products")
public class ProductController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private ProductService productService;


    @GetMapping("/addProduct")
    public String getForm(Model model, @ModelAttribute("productDto")ProductDto productDto){
        model.addAttribute("allCategoryName", productCategoryService.getCategoriesName());
        model.addAttribute("allDiscountName", discountService.getDiscountsName());
        return "product/addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(Model model,
                             @Valid @ModelAttribute("productDto")ProductDto productDto,
                             BindingResult result,
                             @RequestParam("productImage") MultipartFile productImage,
                             HttpSession session) throws IOException {
        if (result.hasErrors() || productImage == null){
            model.addAttribute("allCategoryName", productCategoryService.getCategoriesName());
            model.addAttribute("allDiscountName", discountService.getDiscountsName());
            return "product/addProduct";
        }
        System.out.println(productDto);
        System.out.println(productImage);
        final String realPath = session.getServletContext().getRealPath("/");

        productService.insert(productDto,productImage, Constant.PRODUCT_UPLOAD_IMAGE_LOCATION);

        return "redirect:/api/page/v1/inventory/products/allProducts";
    }

    @GetMapping("/allProducts")
    public String allProductsShow(Model model){
        model.addAttribute("responseProductsDto", productService.getAllProduct());
//        productService.getAllProduct().get(0).getPhotosAttachmentList().get(0).getId();
        return "product/products";
    }

}
