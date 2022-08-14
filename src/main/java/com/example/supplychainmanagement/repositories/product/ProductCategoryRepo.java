package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE ProductCategory c " +
            "SET c.deletedAt = ?2, c.modifiedAt = ?2, c.active = FALSE WHERE c.id = ?1")
    int deleteCategoryById(Long id, Date date);

    @Transactional
    @Modifying
    @Query("UPDATE ProductCategory c " +
            "SET c.modifiedAt = ?2, c.active = TRUE WHERE c.id = ?1")
    int updateCategoryById(Long id, Date date);

}
