package com.example.noronapp.data.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {
    private String name;

    private String email;

    private String password;

    private String address;

    private int phone;
}
