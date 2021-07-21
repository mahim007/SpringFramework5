package com.mahim.recipeapp.services;

import com.mahim.recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findIngredientByIngredientIdAndRecipeId(Long ingredientId, Long recipeId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
}
