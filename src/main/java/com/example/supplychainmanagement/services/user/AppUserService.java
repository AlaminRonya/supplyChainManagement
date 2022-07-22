package com.example.supplychainmanagement.services.user;

import com.example.supplychainmanagement.entities.user.AppUser;
import com.example.supplychainmanagement.entities.user.AppUserRole;
import com.example.supplychainmanagement.repositories.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser getAppUser(String email){
        return appUserRepository.findByEmail(email).orElse(null);
    }

    public void changeDealerRoleAppUserById(Long id) {
        appUserRepository.dealerUpdateRoleAppUserById(id, AppUserRole.DEALER_USER);
    }
}
