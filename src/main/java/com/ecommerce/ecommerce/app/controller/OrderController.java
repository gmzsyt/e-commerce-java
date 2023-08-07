package com.ecommerce.ecommerce.app.controller;

import com.ecommerce.ecommerce.app.entities.Order;
import com.ecommerce.ecommerce.app.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders(@RequestParam Optional<Long> userId){
        return orderService.getAllOrders(userId);
    }

    @GetMapping("{orderId}")
    public Order getOneOrder(@PathVariable Long orderId){
        return  orderService.getOneUser(orderId);
    }

    @PostMapping
    public Order createOneOrder(@RequestBody Order newOrder){
        return orderService.createOneOrder(newOrder);
    }
}
