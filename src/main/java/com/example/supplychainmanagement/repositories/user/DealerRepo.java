package com.example.supplychainmanagement.repositories.user;


import com.example.supplychainmanagement.entities.user.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DealerRepo  extends JpaRepository<Dealer, Long> {
    Optional<Dealer> findByTradeLicenseNumber(String tinNumber);

    @Transactional
    @Modifying
    @Query("UPDATE Dealer d " +
            "SET d.modifiedAt = ?2, d.active = TRUE WHERE d.id = ?1")
    int dealerUpdateRoleById(Long id, Date date);
}
