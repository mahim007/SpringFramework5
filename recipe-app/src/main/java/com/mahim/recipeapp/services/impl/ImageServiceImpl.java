package com.mahim.recipeapp.services.impl;

import com.mahim.recipeapp.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("received a multi-part file: " + file.getContentType(), file.getName(), file.getOriginalFilename(), file.getSize());
        System.out.println("received a multi-part file: " + file.getContentType() +  file.getName() + file.getOriginalFilename() + file.getSize());
    }
}
