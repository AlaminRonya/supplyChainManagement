package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
}
