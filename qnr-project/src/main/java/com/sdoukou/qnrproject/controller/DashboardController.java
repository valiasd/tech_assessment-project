package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.sdoukou.qnrproject.authentication.CustomUserDetails;  // Import CustomUserDetails

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {

    private final OrderService orderService;

    @GetMapping
    public String dashboard(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        com.sdoukou.qnrproject.model.User user = customUserDetails.getUser();
        List<Order> orders = orderService.getOrdersByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("orders", orders);

        return "dashboard";
    }
}
