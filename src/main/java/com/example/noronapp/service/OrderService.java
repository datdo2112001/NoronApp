package com.example.noronapp.service;

import com.example.noronapp.data.mappers.OrderMapper;
import com.example.noronapp.data.model.Order;
import com.example.noronapp.data.response.OrderResponse;
import com.example.noronapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderResponse> getAllOrders() {
        return orderMapper.ordersToOrderDtos((List<Order>) orderRepository.findAll());
    }

    public OrderResponse getOrderById(int id) {
        return orderMapper.orderToOrderDto(orderRepository.findById(id).orElseGet(null));
    }

    public void saveOrder(OrderResponse orderResponse) {
        orderRepository.save(orderMapper.orderDtoToOrder(orderResponse));
    }
}
