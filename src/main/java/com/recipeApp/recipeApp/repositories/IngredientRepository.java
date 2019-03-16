package com.recipeApp.recipeApp.repositories;

import com.recipeApp.recipeApp.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
