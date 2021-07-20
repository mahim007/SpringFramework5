package com.mahim.recipeapp.services.impl;

import com.mahim.recipeapp.commands.IngredientCommand;
import com.mahim.recipeapp.converters.IngredientToIngredientCommand;
import com.mahim.recipeapp.domain.Recipe;
import com.mahim.recipeapp.repositories.RecipeRepository;
import com.mahim.recipeapp.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand toIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand toIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.toIngredientCommand = toIngredientCommand;
    }

    @Override
    public IngredientCommand findIngredientByIngredientIdAndRecipeId(Long ingredientId, Long recipeId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()) {
            // todo: implement error handling
            log.debug("recipe id not found: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(toIngredientCommand::convert).findFirst();

        if (ingredientCommandOptional.isEmpty()) {
            // todo: implement error handling
        }

        return ingredientCommandOptional.get();
    }
}
