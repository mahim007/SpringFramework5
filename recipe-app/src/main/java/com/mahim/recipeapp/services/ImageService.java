package com.mahim.recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
    byte[] renderImageFromDB(Long recipeId);
}
