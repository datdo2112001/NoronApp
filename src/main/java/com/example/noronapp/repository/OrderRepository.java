package com.example.noronapp.repository;

import com.example.noronapp.data.model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Integer> {
}
