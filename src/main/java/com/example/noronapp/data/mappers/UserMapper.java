package com.example.noronapp.data.mappers;

import noronapp.jooq.data.tables.pojos.Users;
import com.example.noronapp.data.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name", target = "username")
    Users userDtoToUser(UserResponse userResponse);

    @Mapping(source = "username", target = "name")
    UserResponse userToUserDto(Users user);

    List<UserResponse> usersToUserDtos(List<Users> users);
}
