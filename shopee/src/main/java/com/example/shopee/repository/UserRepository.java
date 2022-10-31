package com.example.shopee.repository;

import com.example.shopee.model.entity.ProfileUser;
import com.example.shopee.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select User.id, username, password, full_name, date_of_birth, avatar_url, email from User join Profile " +
            "on User.id = Profile.user_id", nativeQuery = true)
    List<ProfileUser> getAllInfo();
}
