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
        final boolean present = productCategoryRepo.findByName(name).isPresent();
        if (present){
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

    public ResponseCategoryDto getCategoryById(Long parseLong) {
        if (parseLong == null){
            return null;
        }
        final Optional<ProductCategory> byId = productCategoryRepo.findById(parseLong);
        if (byId.isPresent()){
            final ProductCategory category = byId.get();
            System.out.println("Date:============>"+category.getCreatedAt());
            return categoryDtoToCategoryPojo.pojoToDto(category);
        }
        return null;
    }
    public List<ResponseCategoryDto> getAllCategory(){
        final List<ProductCategory> all = productCategoryRepo.findAll();
        return categoryDtoToCategoryPojo.entitiesToDto(all);

    }

    public Boolean removeCategoryById(Long id) {
//        LocalDate localDate = LocalDate.now();

        if (id != null){
            final Optional<ProductCategory> byId = productCategoryRepo.findById(id);
            if (byId.isPresent()){
                final ProductCategory category = byId.get();
                category.setDeletedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                System.out.println(category.getDeletedAt());
                delete(category);
                return true;
            }
            return false;
        }
        return false;
    }
    private void delete(ProductCategory category){

        final int i = productCategoryRepo.deleteCategoryById(category.getId(), category.getDeletedAt());
        System.out.println("i=================>"+i);
    }


    public Boolean updateCategoryById(Long id) {
        if (id != null){
            final Optional<ProductCategory> byId = productCategoryRepo.findById(id);
            if (byId.isPresent()){
                final ProductCategory category = byId.get();
                category.setModifiedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                System.out.println(category.getDeletedAt());
                update(category);
                return true;
            }
            return false;
        }


        return false;
    }

    public List<String> getCategoriesName(){
        return getAllCategory().stream().map(ResponseCategoryDto::getName).collect(Collectors.toList());
    }

    private void update(ProductCategory category){
        final int i = productCategoryRepo.updateCategoryById(category.getId(), category.getModifiedAt());
        System.out.println("i=================>"+i);
    }


}
