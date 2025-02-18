package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.model.User;
import com.sdoukou.qnrproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // Optimized method to fetch orders by user
    public List<Order> getOrdersByUser(User user) {
        // Fetch orders by the user once, avoid calling repository twice
        List<Order> orders = orderRepository.findByUser(user);
        System.out.println("Orders fetched: " + orders);
        return orders;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
