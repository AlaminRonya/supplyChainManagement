package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.CategoryDtoToCategoryPojo;
import com.example.supplychainmanagement.dto.ProductCategoryDto;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.repositories.product.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private CategoryDtoToCategoryPojo categoryDtoToCategoryPojo;

    public Long addCategory(ProductCategoryDto request) {
        final ProductCategory category = categoryDtoToCategoryPojo.getCategory(request);
        LocalDate localDate = LocalDate.now();

        category.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        final ProductCategory save = productCategoryRepo.save(category);
        Long id = save.getId();

        return id;


    }
}
