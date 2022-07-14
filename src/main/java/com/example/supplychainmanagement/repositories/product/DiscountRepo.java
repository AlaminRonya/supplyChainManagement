package com.example.supplychainmanagement.repositories.product;

import com.example.supplychainmanagement.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DiscountRepo extends JpaRepository<Discount, Long> {

    Optional<Discount> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Discount d " +
            "SET d.deletedAt = ?2, d.modifiedAt = NULL, d.active = FALSE WHERE d.id = ?1")
    int deleteDiscountById(Long id, Date date);

    @Transactional
    @Modifying
    @Query("UPDATE Discount d " +
            "SET d.modifiedAt = ?2, d.deletedAt = NULL,d.discountPercent = ?3, d.active = TRUE WHERE d.id = ?1")
    int updateDiscountById(Long id, Date date, Double percent);

}
