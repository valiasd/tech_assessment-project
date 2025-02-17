package com.sdoukou.qnrproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Login page
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // This method would be handled by Spring Security after successful login
        // Redirect the user to the proper dashboard view
        return "redirect:/user-dashboard"; // Redirect to the user dashboard after login
    }
}
