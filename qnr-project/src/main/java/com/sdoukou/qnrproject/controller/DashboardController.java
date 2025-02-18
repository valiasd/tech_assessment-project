package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.service.OrderService;
import com.sdoukou.qnrproject.authentication.CustomUserDetails;  // Add this import
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {

    private final OrderService orderService;

    @GetMapping
    public String dashboard(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        List<Order> orders = orderService.getOrdersByUser(customUserDetails.getUser()); // Use CustomUserDetails

        model.addAttribute("username", customUserDetails.getUsername()); 
        model.addAttribute("orders", orders);

        return "dashboard"; // Return view
    }
}
