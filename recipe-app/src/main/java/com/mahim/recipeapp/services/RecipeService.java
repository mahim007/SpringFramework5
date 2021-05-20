package com.mahim.recipeapp.services;

import com.mahim.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
