package com.example.supplychainmanagement.converterDtoToPojo;

import com.example.supplychainmanagement.dto.ProductCategoryDto;
import com.example.supplychainmanagement.dto.ResponseCategoryDto;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoToCategoryPojo {

    public ProductCategory getCategory(ProductCategoryDto dto){
        ProductCategory category = new ProductCategory();
        category.setName(dto.getName().trim().toUpperCase());
        category.setDescription(dto.getDesc().trim());
        return category;
    }

    public ResponseCategoryDto pojoToDto(ProductCategory category){
        ResponseCategoryDto dto = new ResponseCategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setCreatedAt(DateUtils.convertToLocalDateViaInstant(category.getCreatedAt()));
        if(category.getModifiedAt() != null){
            dto.setModifiedAt(DateUtils.convertToLocalDateViaInstant(category.getModifiedAt()));
        }
        if(category.getDeletedAt() != null){
            dto.setDeletedAt(DateUtils.convertToLocalDateViaInstant(category.getDeletedAt()));
        }
        dto.setActive(category.getActive());

        return dto;
    }

    public List<ResponseCategoryDto> entitiesToDto(List<ProductCategory> productCategories) {
        return	productCategories.stream().map(this::pojoToDto).collect(Collectors.toList());
    }

}
