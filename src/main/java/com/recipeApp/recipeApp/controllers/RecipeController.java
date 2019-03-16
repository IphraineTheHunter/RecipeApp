package com.recipeApp.recipeApp.controllers;

import com.recipeApp.recipeApp.models.Recipe;
import com.recipeApp.recipeApp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping(value = "/recipe/")
    public ModelAndView recipeHome() {
        ModelAndView view = new ModelAndView();
        view.setViewName("recipeHome");
        Iterable<Recipe> recipes = recipeRepository.findAll();
        view.addObject("recipes", recipes);
        return view;
    }

    @GetMapping(value = "/recipe/{recipeId}")
    public ModelAndView recipeDetails(@PathVariable("recipeId")Long recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (!recipe.isPresent()) {
            return new ModelAndView("redirect:/recipe/");
        }

        ModelAndView view = new ModelAndView();
        view.addObject("recipe", recipe.get());
        view.setViewName("recipeDetails");
        return view;
    }

    @GetMapping(value = "/recipe/add")
    public ModelAndView addRecipe() {
        ModelAndView view = new ModelAndView();
        view.setViewName("recipeAdd");
        return view;
    }

    @PostMapping(value="recipe/create")
    public RedirectView createRecipe(@RequestParam("name") String recipeName) {
        Recipe recipe = new Recipe();
        recipe.recipeName = recipeName;

        recipeRepository.save(recipe);

        return new RedirectView("/recipe/");
    }

}
