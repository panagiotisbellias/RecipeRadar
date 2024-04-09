package com.github.donaldwilson8.controller;

import com.github.donaldwilson8.model.Recipe;
import com.github.donaldwilson8.service.EdamamService;
import com.github.donaldwilson8.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final EdamamService edamamService;

    @Autowired
    public RecipeController(RecipeService recipeService, EdamamService edamamService) {
        this.recipeService = recipeService;
        this.edamamService = edamamService;
    }

    @GetMapping("/search")
    public List<Recipe> search(@RequestParam String query){
        return edamamService.searchRecipes(query);
    }

}
