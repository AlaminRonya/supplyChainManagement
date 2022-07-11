package com.example.supplychainmanagement.controller.product;

import com.example.supplychainmanagement.dto.ProductCategoryDto;
import com.example.supplychainmanagement.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/page/v1/inventory/categories")
public class CategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @GetMapping("/addCategory")
    public String pageCategory(@ModelAttribute("productCategoryDto") ProductCategoryDto request){
        return "categories/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("productCategoryDto") ProductCategoryDto request, BindingResult result){
        if (result.hasErrors()){
            return "categories/addCategory";
        }
        final Long aLong = productCategoryService.addCategory(request);
        if (aLong != null){
            return "categories/addCategory";
        }
        return "redirect:/api/page/v1/inventory/categories/addCategory";
    }


}
