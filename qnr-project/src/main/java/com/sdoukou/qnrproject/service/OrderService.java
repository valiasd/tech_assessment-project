package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.model.User;
import com.sdoukou.qnrproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // Constructor-based injection (preferred)
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Fetch orders for a user
    public List<Order> getOrdersForUser(User user) {
        return orderRepository.findByUser(user);  // Now correctly calling the repository
    }
}
