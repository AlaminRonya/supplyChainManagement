package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.CategoryDtoToCategoryPojo;
import com.example.supplychainmanagement.dto.request.ProductCategoryDto;
import com.example.supplychainmanagement.dto.request.ProductDto;
import com.example.supplychainmanagement.dto.response.ResponseCategoryDto;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.repositories.product.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private CategoryDtoToCategoryPojo categoryDtoToCategoryPojo;
    private LocalDate localDate = LocalDate.now();

    public Long addCategory(ProductCategoryDto request) {
        final String name = request.getName().trim().toUpperCase();
//        final boolean present = productCategoryRepo.findByName(name).isPresent();
        if (searchCategoryByName(name) == null){
            return null;
        }


        final ProductCategory category = categoryDtoToCategoryPojo.getCategory(request);
//        LocalDate localDate = LocalDate.now();
        category.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        final ProductCategory save = productCategoryRepo.save(category);
        if (save.getId() != null){
            System.out.println("Insert success!");
        }

        return save.getId();

    }

    public ResponseCategoryDto getCategoryById(Long id) {
        if (id == null){
            return null;
        }
        final ProductCategory category = searchCategoryById(id);
        if (category != null){
            return categoryDtoToCategoryPojo.pojoToDto(category);
        }
        return null;
    }
    public List<ResponseCategoryDto> getAllCategory(){
        final List<ProductCategory> all = productCategoryRepo.findAll();
        return categoryDtoToCategoryPojo.entitiesToDto(all);

    }

    public Boolean removeCategoryById(Long id) {

        if (id != null){
            final ProductCategory category = searchCategoryById(id);
            if (category != null){
                delete(category);
                return true;
            }
            return false;
        }
        return false;

    }
    private void delete(ProductCategory category){
        productCategoryRepo.deleteCategoryById(category.getId(),
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    }


    public Boolean updateCategoryById(Long id) {
        if (id != null){
            final ProductCategory category = searchCategoryById(id);
            if (category != null){
                update(category);
                return true;
            }
            return false;
        }


        return false;
    }

    public ProductCategory getProductCategoryByName(String name){
        return searchCategoryByName(name);
    }
    private ProductCategory searchCategoryById(Long id){
        return productCategoryRepo.findById(id).orElse(null);
    }
    private ProductCategory searchCategoryByName(String name){
        return productCategoryRepo.findByName(name).orElse(null);
    }

    public List<String> getCategoriesName(){
        return getAllCategory().stream().map(ResponseCategoryDto::getName).collect(Collectors.toList());
    }

    private void update(ProductCategory category){
        productCategoryRepo.updateCategoryById(category.getId(),
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    }


    public void addAllCategoryRunTime(List<ProductCategory> categories) {
        for (ProductCategory category: categories){
            if (searchCategoryByName(category.getName()) == null){
                productCategoryRepo.save(category);
            }
        }
    }
}
