package com.example.noronapp.service;

import com.example.noronapp.data.mappers.UserMapper;
import com.example.noronapp.data.response.UserResponse;
import com.example.noronapp.repository.UserRepository;
import noronapp.jooq.data.tables.pojos.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        return userMapper.usersToUserDtos(userRepository.findAll());
    }
    public UserResponse getUserById(int id) {
        return userMapper.userToUserDto(userRepository.findById(id));
    }

    public void saveUser(UserResponse userResponse) {
        userRepository.save(userMapper.userDtoToUser(userResponse));
    }
}
