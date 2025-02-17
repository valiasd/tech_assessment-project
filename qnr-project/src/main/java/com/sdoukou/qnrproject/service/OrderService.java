package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

