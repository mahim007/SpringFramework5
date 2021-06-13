package com.mahim.recipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category category;

    @BeforeEach
    private void setUp() {
        category = new Category();
        category.setId(4L);
        category.setDescription("this is a description");
    }

    @Test
    void getId() {
        assertEquals(4L, category.getId());
    }

    @Test
    void getDescription() {
        assertEquals("this is a description", category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}