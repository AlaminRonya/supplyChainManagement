package com.example.supplychainmanagement.repositories.user;

import com.example.supplychainmanagement.entities.user.AppUser;
import com.example.supplychainmanagement.entities.user.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.appUserRole = ?2 WHERE a.id = ?1")
    int dealerUpdateRoleAppUserById(Long id, AppUserRole role);

}
