package com.recipeApp.recipeApp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.recipeApp.recipeApp.models.Ingredient;
import com.recipeApp.recipeApp.models.IngredientCategory;
import com.recipeApp.recipeApp.models.Recipe;
import com.recipeApp.recipeApp.models.RecipeIngredientListing;
import com.recipeApp.recipeApp.repositories.IngredientRepository;
import com.recipeApp.recipeApp.repositories.RecipeIngredientListingRepository;
import com.recipeApp.recipeApp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class dataInitializer implements ApplicationRunner {
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private RecipeIngredientListingRepository recipeIngredientListingRepository;

    @Autowired
    public dataInitializer(RecipeRepository recipeRepository,
                           IngredientRepository ingredientRepository,
                           RecipeIngredientListingRepository recipeIngredientListingRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientListingRepository = recipeIngredientListingRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = recipeRepository.count();

        if (count == 0) {
            Ingredient flour = new Ingredient();
            flour.ingredientName = "flour";
            flour.category = IngredientCategory.BAKING_GOODS;
            ingredientRepository.save(flour);

            Recipe orangeCauliflower = new Recipe();
            orangeCauliflower.recipeName = "Orange Cauliflower";
            recipeRepository.save(orangeCauliflower);

            Recipe pancakes = new Recipe();
            pancakes.recipeName = "Pancakes";
            pancakes.addIngredientListing(flour, 6, "cups", ingredientRepository);
            recipeRepository.save(pancakes);
        }

    }

}