package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional(readOnly = true)
public interface ProductInventoryRepo extends JpaRepository<ProductInventory, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE ProductInventory c " +
            "SET c.modifiedAt = NULL , c.deletedAt = ?2 WHERE c.id = ?1")
    int deleteProductInventoryById(Long id, Date date);

    @Transactional
    @Modifying
    @Query("UPDATE ProductInventory c " +
            "SET c.quantity = ?2, c.modifiedAt = ?3, c.deletedAt = NULL WHERE c.id = ?1")
    int updateProductInventoryById(Long id, Long qty, Date date);

}
