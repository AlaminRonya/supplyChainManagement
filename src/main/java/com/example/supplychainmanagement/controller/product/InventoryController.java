package com.example.supplychainmanagement.controller.product;

import com.example.supplychainmanagement.dto.request.ProductInventoryDto;
import com.example.supplychainmanagement.dto.response.ResponseInventoryDto;
import com.example.supplychainmanagement.services.product.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/page/v1/inventory/product/inventories")
public class InventoryController {
    @Autowired
    private ProductInventoryService productInventoryService;


    @GetMapping("/addInventory")
    public String formInventory(@ModelAttribute("productInventoryDto")ProductInventoryDto productInventoryDto){
        return "inventories/addInventory";
    }
    @PostMapping("/addInventory")
    public String formSubmittedInventory(@Valid @ModelAttribute("productInventoryDto")ProductInventoryDto productInventoryDto, BindingResult result){
        if (result.hasErrors()){
            return "inventories/addInventory";
        }
        final Boolean aBoolean = productInventoryService.addInventory(productInventoryDto);
        if (aBoolean){
            System.out.println("Insert Success!");
        }
        System.out.println(productInventoryDto.getQuantity()+"================"+ productInventoryDto.getQuantity().getClass());

        return "redirect:/api/page/v1/inventory/product/inventories/all/show";
    }

    @GetMapping("/all/show")
    public String getAllInventory(Model model){
        model.addAttribute("responseInventoriesDto", productInventoryService.getAllInventoryDto());
        return "inventories/inventories";
    }

    @GetMapping("/update/{id}")
    public String getUpdateInventoryById(@PathVariable("id") String id, Model model,
                                         @ModelAttribute("productInventoryDto")ProductInventoryDto productInventoryDto){
//        final ResponseInventoryDto inventoryDto = productInventoryService.getInventoryById(Long.parseLong(id));

        model.addAttribute("inventoryDto",getInventoryById(id));

        return "inventories/updateInventory";
    }

    @PostMapping("/update/quantity/{id}")
    public String updateInventory(@PathVariable("id") String id,
                                  Model model,
                                  @Valid @ModelAttribute("productInventoryDto")ProductInventoryDto productInventoryDto,
                                  BindingResult result){
        final ResponseInventoryDto inventoryDto = getInventoryById(id);

        if (result.hasErrors() || inventoryDto == null){
            model.addAttribute("inventoryDto",inventoryDto);
            return "inventories/updateInventory";
        }
        productInventoryService.update(Long.parseLong(id), productInventoryDto.getQuantity());
        return "redirect:/api/page/v1/inventory/product/inventories/all/show";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteInventoryById(@PathVariable("id") String id){
        final ResponseInventoryDto inventoryById = getInventoryById(id);
        if (inventoryById != null){
            System.out.println(inventoryById);
            final Boolean delete = productInventoryService.delete(inventoryById.getId());
            if (delete){
                System.out.println("Delete success!");
            }
        }



        return "redirect:/api/page/v1/inventory/product/inventories/all/show";
    }

    private ResponseInventoryDto getInventoryById(String id){
        return productInventoryService.getInventoryById(Long.parseLong(id));

    }
}
