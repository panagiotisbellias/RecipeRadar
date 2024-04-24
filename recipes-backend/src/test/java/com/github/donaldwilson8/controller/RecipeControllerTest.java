package com.github.donaldwilson8.controller;

import com.github.donaldwilson8.service.EdamamService;
import com.github.donaldwilson8.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @InjectMocks
    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    EdamamService edamamService;

    @Test
    void testConstructor() {
        RecipeController recipeController = new RecipeController(recipeService, edamamService);
        Assertions.assertInstanceOf(RecipeController.class, recipeController);
    }

    @Test
    void testSearch() {
        Assertions.assertTrue(recipeController.search("query").isEmpty());
    }

}
