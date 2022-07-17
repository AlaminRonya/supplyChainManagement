package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.Discount;
import com.example.supplychainmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional(readOnly = true)
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Product p " +
            "SET p.deletedAt = ?2, p.modifiedAt = NULL WHERE p.id = ?1")
    int deleteProductById(Long id, Date date);

    @Transactional
    @Modifying
    @Query("UPDATE Product p " +
            "SET p.name =?2, p.description = ?3, p.SKU = ?4, p.price = ?5, p.modifiedAt = ?6,  p.discount = ?7, p.deletedAt = NULL  WHERE p.id = ?1")
    int updateProductById(Long id, String name, String description, String sku, Double price, Date modified, Discount discount);


}
