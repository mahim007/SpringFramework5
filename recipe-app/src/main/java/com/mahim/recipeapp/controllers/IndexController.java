package com.mahim.recipeapp.controllers;

import com.mahim.recipeapp.domain.Category;
import com.mahim.recipeapp.domain.UnitOfMeasure;
import com.mahim.recipeapp.repositories.CategoryRepository;
import com.mahim.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("category: " + categoryOptional.get().getId() + " " + categoryOptional.get().getDescription());
        System.out.println("unit of measure: " + unitOfMeasureOptional.get().getId() + " " + unitOfMeasureOptional.get().getDescription());
        return "index";
    }
}
