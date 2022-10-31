package com.example.shopee.service;

import com.example.shopee.model.entity.Profile;
import com.example.shopee.model.request.ProfileRequest;
import com.example.shopee.model.response.UploadProfileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IProfileService {
    Profile create(ProfileRequest profileRequest);
    UploadProfileResponse upLoadAvatarUrl(Long id, MultipartFile file) throws Exception;
}
