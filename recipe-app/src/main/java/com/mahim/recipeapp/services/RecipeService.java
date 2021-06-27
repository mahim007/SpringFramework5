package com.mahim.recipeapp.services;

import com.mahim.recipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Optional<Recipe> findById(Long id);
}
