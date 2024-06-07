package com.group8.cookinBackend.service.impl;

import com.group8.cookinBackend.dto.UserDto;
import com.group8.cookinBackend.entity.User;
import com.group8.cookinBackend.exception.ResourceNotFoundException;
import com.group8.cookinBackend.mapper.UserMapper;
import com.group8.cookinBackend.repository.UserRepository;
import com.group8.cookinBackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.INSTANCE.toDTO(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with the given id: " + userId));
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.INSTANCE.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given id: " + userId));

        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.INSTANCE.toDTO(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given id: " + userId));

        userRepository.deleteById(userId);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.isPresent();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

}
