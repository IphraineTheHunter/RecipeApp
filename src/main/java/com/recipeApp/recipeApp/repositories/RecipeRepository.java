package com.recipeApp.recipeApp.repositories;

import com.recipeApp.recipeApp.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
