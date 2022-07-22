package com.example.supplychainmanagement.controller.user;

import com.example.supplychainmanagement.entities.user.Dealer;
import com.example.supplychainmanagement.services.user.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page/v1/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @GetMapping("/allDealer")
    public String getAllDealer(Model model){
        final List<Dealer> allDealer = dealerService.getAllDealer();
        System.out.println(allDealer);
        System.out.println(allDealer.get(0).getUser().getEmail());

        model.addAttribute("dealers", dealerService.getAllDealer());
        return "user/dealers";
    }
    @GetMapping("/active/{id}")
    public String dealerConfirmation(@PathVariable("id") String id){
        final long d = Long.parseLong(id);
        final Dealer dealer = dealerService.getDealer(d);
        if (dealer != null){
            dealerService.update(dealer);
        }
        return "redirect:/page/v1/dealer/allDealer";

    }

}
