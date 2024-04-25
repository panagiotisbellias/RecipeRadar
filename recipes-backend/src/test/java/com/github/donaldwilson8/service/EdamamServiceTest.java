package com.github.donaldwilson8.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.donaldwilson8.exception.CustomExceptions;
import com.github.donaldwilson8.model.Hit;
import com.github.donaldwilson8.model.Recipe;
import com.github.donaldwilson8.model.RecipeSearchResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class EdamamServiceTest {

    @InjectMocks
    EdamamService edamamService;

    @Mock
    WebClient webClient;

    @Mock
    ObjectMapper objectMapper;

    @Test
    void testConstructor() {
        EdamamService edamamService = new EdamamService(objectMapper);
        Assertions.assertInstanceOf(EdamamService.class, edamamService);
    }

    @Test
    void testSearchRecipesException() {
        CustomExceptions.EdamamApiException exception = Assertions.assertThrows(CustomExceptions.EdamamApiException.class, () -> edamamService.searchRecipes("query"));
        Assertions.assertEquals("Error response from Edamam API: 401 UNAUTHORIZED; org.springframework.web.reactive.function.client.DefaultClientResponse", exception.getMessage().split("@")[0]);
    }

    @Test
    void testParseResponseToRecipes() {
        RecipeSearchResponse response = Mockito.mock(RecipeSearchResponse.class);
        Hit hit = Mockito.mock(Hit.class);

        Mockito.when(response.getHits()).thenReturn(List.of(hit));
        List<Recipe> recipes = edamamService.parseResponseToRecipes(response);

        Assertions.assertEquals(1, recipes.size());
        Assertions.assertNull(recipes.get(0));
    }

}
