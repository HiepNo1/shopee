package com.example.shopee.controller;

import com.example.shopee.model.entity.ProfileUser;
import com.example.shopee.model.entity.User;
import com.example.shopee.model.request.UserRequest;
import com.example.shopee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping
    ResponseEntity<User> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }
    @GetMapping
    ResponseEntity<List<ProfileUser>> getAllInfo() {
        return ResponseEntity.ok(userService.getAllInfo());
    }
}
