package com.group8.cookinBackend.service;

import com.group8.cookinBackend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);

    boolean validateUser(String email, String password);

    UserDto getUserByEmail(String email);

}
