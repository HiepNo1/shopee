package com.example.shopee.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String avatarUrl;
    private String email;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
