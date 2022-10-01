package com.example.noronapp.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer userId = null;

    private String address;

    private String mode_payment;

    private String status;

    private int total_amount;

    private int total_coin;
}
