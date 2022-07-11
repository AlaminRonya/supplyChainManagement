package com.example.supplychainmanagement.converterDtoToPojo;

import com.example.supplychainmanagement.dto.ProductCategoryDto;
import com.example.supplychainmanagement.entities.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategoryPojo {
    public ProductCategory getCategory(ProductCategoryDto dto){
        ProductCategory category = new ProductCategory();
        category.setName(dto.getName());
        category.setDescription(dto.getDesc());
        return category;
    }
}
