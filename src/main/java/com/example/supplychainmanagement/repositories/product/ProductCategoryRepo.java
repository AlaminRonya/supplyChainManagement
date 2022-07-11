package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
}
