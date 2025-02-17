package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.repository.OrderRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final OrderRepository orderRepository;

    public DashboardController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);

        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);

        return "dashboard";
    }
}