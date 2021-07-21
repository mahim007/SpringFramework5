package com.mahim.recipeapp.converters;

import com.mahim.recipeapp.commands.IngredientCommand;
import com.mahim.recipeapp.domain.Ingredient;
import com.mahim.recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientCommand.getId());

        if (ingredientCommand.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(ingredientCommand.getRecipeId());
            recipe.addIngredient(ingredient);
            ingredient.setRecipe(recipe);
        }

        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setDescription(ingredientCommand.getDescription());
        ingredient.setUom(uomConverter.convert(ingredientCommand.getUom()));
        return ingredient;
    }
}
