package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Customer;
import com.sdoukou.qnrproject.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) throws Exception {
        List<Customer> customers;
        try {
            customers = customerService.findAllCustomers();
            model.addAttribute("customers", customers);
        } catch (Exception e) {
            throw e;
        }
        return "/dashboard";
    }
}