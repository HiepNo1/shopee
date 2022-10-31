package com.example.shopee.service;

import com.example.shopee.model.entity.ProfileUser;
import com.example.shopee.model.entity.User;
import com.example.shopee.model.request.UserRequest;

import java.util.List;

public interface IUserService {
    User create(UserRequest userRequest);
    List<ProfileUser> getAllInfo();
}
