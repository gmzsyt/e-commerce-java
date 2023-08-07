package com.ecommerce.ecommerce.app.services;

import com.ecommerce.ecommerce.app.entities.Order;
import com.ecommerce.ecommerce.app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping
    public List<Order> getAllOrders(Optional<Long> userId) {
        if (userId.isPresent())
            return orderRepository.findByUserId(userId.get()); //neden get
        return orderRepository.findAll();
    }
    @GetMapping("/{orderId}")
    public Order getOneUser(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOneOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }
}
