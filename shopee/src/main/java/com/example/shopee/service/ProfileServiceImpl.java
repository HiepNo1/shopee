package com.example.shopee.service;

import com.example.shopee.model.entity.Profile;
import com.example.shopee.model.request.ProfileRequest;
import com.example.shopee.model.response.UploadProfileResponse;
import com.example.shopee.repository.ProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Service
public class ProfileServiceImpl implements IProfileService{
    @Autowired
    private ProfileRepository profileRepository;
    @Value("${storage.file.url}")
    private String storageLocation;
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public Profile create(ProfileRequest profileRequest) {
        Profile profile = new Profile();
        profile.setFullName(profileRequest.getFullName());
        profile.setAvatarUrl(profileRequest.getAvatarUrl());
        profile.setEmail(profileRequest.getEmail());
        profile.setDateOfBirth(profileRequest.getDateOfBirth());
        profile.setUserId(profileRequest.getUserId());
        profile.setCreatedAt(LocalDateTime.now());
        profile.setUpdatedAt(LocalDateTime.now());
        profileRepository.save(profile);
        return profile;
    }

    @Override
    public UploadProfileResponse upLoadAvatarUrl(Long id, MultipartFile file) throws Exception {
        if (file == null || file.getOriginalFilename() == null) {
            throw new Exception("file not null");
        }
        String fileName = StringUtils.cleanPath(Integer.valueOf(LocalDateTime.now().getNano()).toString()) + ".png";
        try {
            if (fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path dir = Paths.get(storageLocation);
            Path targetLocation = dir.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            Profile newProfile = profileRepository.getReferenceById(id);
            newProfile.setAvatarUrl(fileName);
            newProfile.setUpdatedAt(LocalDateTime.now());
            profileRepository.save(newProfile);
            return mapper.convertValue(newProfile, UploadProfileResponse.class);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
         }
    }
}
