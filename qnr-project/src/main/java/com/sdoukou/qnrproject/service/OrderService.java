package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.model.User;
import com.sdoukou.qnrproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
