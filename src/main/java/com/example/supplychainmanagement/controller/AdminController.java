package com.example.supplychainmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class AdminController {
    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }
}
