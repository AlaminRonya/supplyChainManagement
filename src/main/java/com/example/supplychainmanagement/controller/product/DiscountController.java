package com.example.supplychainmanagement.controller.product;

import com.example.supplychainmanagement.dto.request.DiscountDto;
import com.example.supplychainmanagement.dto.response.ResponseDiscountDto;
import com.example.supplychainmanagement.dto.request.UpdateDiscountDto;
import com.example.supplychainmanagement.services.product.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/page/v1/inventory/product/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping("/addDiscount")
    public String getAddDiscount(@ModelAttribute("discountDto")DiscountDto dto){
        return "discount/addDiscount";
    }

    @PostMapping("/addDiscount")
    public String AddDiscount(@Valid @ModelAttribute("discountDto")DiscountDto dto, BindingResult result){
        if (result.hasErrors()){
            return "discount/addDiscount";
        }
        final Boolean aBoolean = discountService.addDiscount(dto);
        if (aBoolean){
            System.out.println("Insert success!");
        }else {
            System.out.println("Not insert!");
        }

        return "redirect:/api/page/v1/inventory/product/discounts/all";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable("id") String id, @ModelAttribute("updateDiscountDto")
            UpdateDiscountDto updateDiscountDto, Model model){

//        final ResponseDiscountDto discountById = discountService.getDiscountById(Long.parseLong(id));
        model.addAttribute("discountDto", getResponseDiscountDto(id));
        return "discount/updateDiscountProduct";
    }

    @PostMapping("/update/{id}")
    public String updatePage(@PathVariable("id") String id, @Valid @ModelAttribute("updateDiscountDto")
            UpdateDiscountDto updateDiscountDto,
                             BindingResult result, Model model){


        if (result.hasErrors()){
            model.addAttribute("discountDto", getResponseDiscountDto(id));
            return "discount/updateDiscountProduct";
        }
        final ResponseDiscountDto discountById = getResponseDiscountDto(id);
        if (discountById != null){
            discountService.updateDiscountById(discountById.getId(), updateDiscountDto.getDiscountPercent());
        }
        return "redirect:/api/page/v1/inventory/product/discounts/all";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteInventoryById(@PathVariable("id") String id){
        final ResponseDiscountDto discountById = getResponseDiscountDto(id);
        if (discountById != null){
            final Boolean delete = discountService.delete(discountById.getId());
            if (delete){
                System.out.println("Delete success!");
            }else {
                System.out.println("Not deleted");
            }
        }



        return "redirect:/api/page/v1/inventory/product/discounts/all";
    }

    @GetMapping("/all")
    public String getAllDiscount(Model model){
        model.addAttribute("discountsDto", discountService.getAllDiscounts());
        return "discount/discounts-show";
    }

    private ResponseDiscountDto getResponseDiscountDto(String id){
        return discountService.getDiscountById(Long.parseLong(id));
    }
}
