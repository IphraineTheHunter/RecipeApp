package com.recipeApp.recipeApp.models;

import com.recipeApp.recipeApp.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPES")
public class Recipe {

    public Recipe() {
        ingredientListings = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public Long id;

    @Column
    public String recipeName;

    @OneToMany(
        mappedBy = "recipe",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    public List<RecipeIngredientListing> ingredientListings;

    public void addIngredientListing(Ingredient ingredient, Integer quantity, String units, IngredientRepository ingredientRepository) {
        RecipeIngredientListing listing = new RecipeIngredientListing();
        listing.ingredient = ingredient;
        ingredient.recipeListings.add(listing);
        ingredientRepository.save(ingredient);

        listing.quantity = quantity;

        listing.units = units;

        listing.recipe = this;
        ingredientListings.add(listing);
    }
}
