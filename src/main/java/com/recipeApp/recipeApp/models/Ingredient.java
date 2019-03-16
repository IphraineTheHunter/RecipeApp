package com.recipeApp.recipeApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {
    public Ingredient() {
        recipeListings = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    Long id;

    @Column
    public String ingredientName;

    @Column
    public IngredientCategory category;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<RecipeIngredientListing> recipeListings;
}
