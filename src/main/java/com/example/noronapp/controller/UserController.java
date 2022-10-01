package com.example.noronapp.controller;

import com.example.noronapp.data.response.UserResponse;
import com.example.noronapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
//
    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }
//
    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserResponse userResponse) {
        userService.saveUser(userResponse);
        return ResponseEntity.ok(userResponse);
    }


}
