package com.example.supplychainmanagement.controller.product;

import com.example.supplychainmanagement.dto.request.ProductCategoryDto;
import com.example.supplychainmanagement.dto.response.ResponseCategoryDto;
import com.example.supplychainmanagement.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
            return "redirect:/api/page/v1/inventory/categories/insert/all/show";
//            return "redirect:/api/page/v1/inventory/categories/insert/show/"+aLong;
        }
        return "redirect:/api/page/v1/inventory/categories/addCategory";
    }

    @GetMapping("/insert/show/{id}")
    public String categoryShow(@PathVariable("id") String id, Model model){
        final ResponseCategoryDto responseCategoryDto = productCategoryService.getCategoryById(Long.parseLong(id));
        model.addAttribute("responseCategoryDto", responseCategoryDto);
        return "categories/category-show";
    }

    @GetMapping("/insert/all/show")
    public String categoriesShow(Model model){
        final List<ResponseCategoryDto> allCategory = productCategoryService.getAllCategory();
        model.addAttribute("responseCategoriesDto", allCategory);
        return "categories/categories";
    }


    @GetMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") String id){
        System.out.println(id+"================"+ id.getClass());
        final Boolean aBoolean = productCategoryService.removeCategoryById(Long.parseLong(id));
        if (aBoolean){
            // TODO Deleting process
            System.out.println("Deleted Successful!");
        }

        return "redirect:/api/page/v1/inventory/categories/insert/all/show";
    }

    @GetMapping("/update/{id}")
    public String updateCategoryById(@PathVariable("id") String id){
        System.out.println(id+"================"+ id.getClass());
        final Boolean aBoolean = productCategoryService.updateCategoryById(Long.parseLong(id));
        if (aBoolean){
            // TODO Updating process
            System.out.println("Updated Successful!");
        }

        return "redirect:/api/page/v1/inventory/categories/insert/all/show";
    }



}
