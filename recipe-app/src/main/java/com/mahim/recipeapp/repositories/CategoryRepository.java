package com.mahim.recipeapp.repositories;

import com.mahim.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
