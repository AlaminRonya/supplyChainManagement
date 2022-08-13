package com.example.supplychainmanagement.services.user;

import com.example.supplychainmanagement.entities.user.AppUser;
import com.example.supplychainmanagement.entities.user.Dealer;
import com.example.supplychainmanagement.repositories.user.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealerService {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private DealerRepo dealerRepo;

    private final LocalDate localDate = LocalDate.now();

    public List<Dealer> getAllDealer(){
        final List<Dealer> all = dealerRepo.findAll();
        if (all != null){
            return List.copyOf(all);
        }
        return null;
    }

    public List<Dealer> getAllRequestDealer(){
        return List.copyOf(dealerRepo.findAll().stream().filter(d-> !d.getActive()).toList());
    }
    public Dealer getDealer(Long id){
        return dealerRepo.findById(id).orElse(null);
    }

    public void update(Dealer dealer) {
        final AppUser appUser = appUserService.getAppUser(dealer.getUser().getEmail());
        if (appUser != null){
            appUserService.changeDealerRoleAppUserById(appUser.getId());
            dealerRepo.dealerUpdateRoleById(dealer.getId(), Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            System.out.println("Successful");
        }else {
            System.out.println("Not successful");
        }
    }
}
