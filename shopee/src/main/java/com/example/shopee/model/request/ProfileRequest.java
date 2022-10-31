package com.example.shopee.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileRequest {
    private String fullName;
    private LocalDate dateOfBirth;
    private String avatarUrl;
    private String email;
    private Long userId;
}
