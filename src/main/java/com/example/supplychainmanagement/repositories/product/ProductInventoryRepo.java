package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepo extends JpaRepository<ProductInventory, Long> {
}
