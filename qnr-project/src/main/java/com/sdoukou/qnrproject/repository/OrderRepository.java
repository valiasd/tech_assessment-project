package com.sdoukou.qnrproject.repository;

import com.sdoukou.qnrproject.model.Order;
import com.sdoukou.qnrproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Method to find orders by user
    List<Order> findByUser(User user);
}
