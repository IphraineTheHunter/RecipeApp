package com.recipeApp.recipeApp.repositories;

import com.recipeApp.recipeApp.models.RecipeIngredientListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientListingRepository extends CrudRepository<RecipeIngredientListing, Long> {
}
