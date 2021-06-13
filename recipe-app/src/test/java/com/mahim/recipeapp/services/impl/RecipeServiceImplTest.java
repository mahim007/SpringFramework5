package com.mahim.recipeapp.services.impl;

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

    @BeforeEach
    void setUp() {
        recipeRepository = Mockito.mock(RecipeRepository.class);
        recipeService = new RecipeServiceImpl(recipeRepository);
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