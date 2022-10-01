package com.example.noronapp.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private int phone;

    private String password;

    private String address;

    private String role;

    private String provider;
}
