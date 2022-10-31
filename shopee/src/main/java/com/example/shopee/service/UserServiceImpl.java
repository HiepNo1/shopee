package com.example.shopee.service;

import com.example.shopee.model.entity.ProfileUser;
import com.example.shopee.model.entity.User;
import com.example.shopee.model.request.UserRequest;
import com.example.shopee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<ProfileUser> getAllInfo() {
        return userRepository.getAllInfo();
    }
}
