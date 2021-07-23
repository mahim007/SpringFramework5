package com.mahim.recipeapp.services.impl;

import com.mahim.recipeapp.commands.RecipeCommand;
import com.mahim.recipeapp.converters.RecipeToRecipeCommand;
import com.mahim.recipeapp.domain.Recipe;
import com.mahim.recipeapp.repositories.RecipeRepository;
import com.mahim.recipeapp.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand toRecipeCommand;

    public ImageServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand toRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.toRecipeCommand = toRecipeCommand;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("received a multi-part file: " + file.getContentType(), file.getName(), file.getOriginalFilename(),
                file.getSize());
        try {
            Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
            if (recipeOptional.isEmpty()) {
                log.debug("recipe not found with id: " + recipeId);
                //todo: handle with proper exception handling
            }

            Recipe recipe = recipeOptional.get();
            Byte[] fileByte = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) {
                fileByte[i++] = b;
            }

            recipe.setImage(fileByte);
            recipeRepository.save(recipe);
        } catch (IOException e) {
            log.error("Error occurred: " + e);
        }
    }

    @Override
    public byte[] renderImageFromDB(Long recipeId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isEmpty()) {
            log.debug("recipe not found with id: " + recipeId);
            //todo: add proper exception handling
            return new byte[0];
        }

        RecipeCommand recipeCommand = toRecipeCommand.convert(recipeOptional.get());
        byte[] bytes = new byte[recipeCommand.getImage().length];

        int i = 0;
        for (Byte b : recipeCommand.getImage()) {
            bytes[i++] = b;
        }

        return bytes;

    }
}
