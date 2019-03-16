package com.recipeApp.recipeApp.models;

import javax.persistence.*;

@Entity
@Table(name="RECIPE_INGREDIENT")
public class RecipeIngredientListing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    public Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id")
    public Ingredient ingredient;

    @Column
    public Integer quantity;

    @Column
    public String units;

}
