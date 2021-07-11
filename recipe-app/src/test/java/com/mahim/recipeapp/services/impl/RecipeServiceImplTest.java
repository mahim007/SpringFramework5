package com.mahim.recipeapp.services.impl;

import com.mahim.recipeapp.converters.RecipeCommandToRecipe;
import com.mahim.recipeapp.converters.RecipeToRecipeCommand;
import com.mahim.recipeapp.domain.Recipe;
import com.mahim.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    RecipeRepository recipeRepository;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        recipeRepository = Mockito.mock(RecipeRepository.class);
        recipeCommandToRecipe = Mockito.mock(RecipeCommandToRecipe.class);
        recipeToRecipeCommand = Mockito.mock(RecipeToRecipeCommand.class);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        System.out.println(recipes);
    }
}