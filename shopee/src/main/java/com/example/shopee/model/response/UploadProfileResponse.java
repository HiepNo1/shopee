package com.example.shopee.model.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UploadProfileResponse {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String avatarUrl;
    private String email;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
