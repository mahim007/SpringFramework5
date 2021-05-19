package com.mahim.recipeapp.repositories;

import com.mahim.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
