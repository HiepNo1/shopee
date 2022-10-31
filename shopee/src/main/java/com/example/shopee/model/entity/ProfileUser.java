package com.example.shopee.model.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUser {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private LocalDate dateOfBirth;
    private String avatarUrl;
    private String email;
}
