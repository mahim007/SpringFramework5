package com.mahim.recipeapp.controllers;

import com.mahim.recipeapp.commands.IngredientCommand;
import com.mahim.recipeapp.services.IngredientService;
import com.mahim.recipeapp.services.RecipeService;
import com.mahim.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/recipe/{recipeId}/ingredient")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        log.debug("Getting ingredient list for recipe id: " + recipeId);
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }

    @PostMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdateIngredients(@ModelAttribute IngredientCommand ingredientCommand) {
        IngredientCommand saveIngredientCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        log.debug("Saving ingredient with id: " + saveIngredientCommand.getId());
        log.debug("Saving recipe with id: " + saveIngredientCommand.getRecipeId());

        return "redirect:/recipe/" + saveIngredientCommand.getRecipeId() + "/ingredient/" +
                saveIngredientCommand.getId() + "/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.findIngredientByIngredientIdAndRecipeId(
                Long.valueOf(ingredientId), Long.valueOf(recipeId)));
        return "recipe/ingredient/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        model.addAttribute("ingredient", ingredientService.findIngredientByIngredientIdAndRecipeId(
                Long.valueOf(ingredientId), Long.valueOf(recipeId)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "/recipe/ingredient/ingredientform";
    }
}
