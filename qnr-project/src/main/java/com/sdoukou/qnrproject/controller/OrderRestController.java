package com.sdoukou.qnrproject.controller;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // Update an order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
