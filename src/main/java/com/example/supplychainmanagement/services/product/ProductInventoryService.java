package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.InventoryDtoToPojo;
import com.example.supplychainmanagement.dto.request.ProductInventoryDto;
import com.example.supplychainmanagement.dto.response.ResponseInventoryDto;
import com.example.supplychainmanagement.entities.ProductInventory;
import com.example.supplychainmanagement.repositories.product.ProductInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductInventoryService {
    @Autowired
    private ProductInventoryRepo productInventoryRepo;
    @Autowired
    private InventoryDtoToPojo inventoryDtoToPojo;
    private final LocalDate localDate = LocalDate.now();


    public Boolean addInventory(ProductInventoryDto productInventoryDto) {

        final ProductInventory productInventory = inventoryDtoToPojo.getProductInventory(productInventoryDto);
        productInventory.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        final ProductInventory save = productInventoryRepo.save(productInventory);

        return save.getId() != null;
    }
    public List<ResponseInventoryDto> getAllInventoryDto(){
        final List<ProductInventory> all = productInventoryRepo.findAll();
        return inventoryDtoToPojo.entitiesToDto(all);
    }

    public ResponseInventoryDto getInventoryById(Long id){
        if (id != null){
            final ProductInventory productInventory = searchById(id);
            if (productInventory != null){
                return inventoryDtoToPojo.pojoToDto(productInventory);
            }
        }
        return null;
    }


    private ProductInventory searchById(Long id){
        final Optional<ProductInventory> byId = productInventoryRepo.findById(id);
        return byId.orElse(null);
    }

    public Boolean update(Long id, Long quantity) {
        if (id != null && quantity != null){
            final ProductInventory productInventory = searchById(id);
            final Long quantity1 = productInventory.getQuantity();
            quantity += quantity1;
            productInventoryRepo.updateProductInventoryById(id, quantity, Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        if (id != null){
            productInventoryRepo.deleteProductInventoryById(id,  Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            return true;
        }
        return false;

    }
}
