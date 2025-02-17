package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.model.User;
import com.sdoukou.qnrproject.service.OrderService;
import com.sdoukou.qnrproject.service.CustomUserDetailsService; // Assuming CustomUserDetailsService for user lookup
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final OrderService orderService;
    private final CustomUserDetailsService userService;

    // Constructor injection for OrderService and CustomUserDetailsService
    public DashboardController(OrderService orderService, CustomUserDetailsService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/user-dashboard")
    public String dashboard(Model model) {
        // Get the current authenticated user from the security context
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername(); // Get the username of the logged-in user

        // Add the username to the model
        model.addAttribute("username", username);

        // Fetch the User object by username using the new method
        User user = userService.findByUsernameEntity(username); // Now using the method to fetch the full User entity

        // Fetch orders for the authenticated user
        List<Order> orders = orderService.getOrdersForUser(user); // Pass the User object to the service
        model.addAttribute("orders", orders);

        return "user-dashboard"; // Return the dashboard view
    }
}
