package com.example.noronapp.controller;

import com.example.noronapp.data.response.OrderResponse;
import com.example.noronapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public OrderResponse getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderResponse orderResponse) {
        orderService.saveOrder(orderResponse);
        return ResponseEntity.ok(orderResponse);
    }
}
