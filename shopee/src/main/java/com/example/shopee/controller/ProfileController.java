package com.example.shopee.controller;

import com.example.shopee.model.entity.Profile;
import com.example.shopee.model.request.ProfileRequest;
import com.example.shopee.model.response.UploadProfileResponse;
import com.example.shopee.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private IProfileService profileService;
    @PostMapping
    ResponseEntity<Profile> create(@RequestBody ProfileRequest request) {
        return ResponseEntity.ok(profileService.create(request));
    }
    @PostMapping("/{id}")
    ResponseEntity<UploadProfileResponse> uploadAvatarUrl(@PathVariable(name = "id") Long id,@RequestParam("file")MultipartFile file) throws Exception{
        return ResponseEntity.ok(profileService.upLoadAvatarUrl(id, file));
    }
}
