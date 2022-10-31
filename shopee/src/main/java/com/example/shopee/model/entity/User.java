package com.example.shopee.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
