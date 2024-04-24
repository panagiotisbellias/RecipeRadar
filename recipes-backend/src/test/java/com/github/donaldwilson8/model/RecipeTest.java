package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RecipeTest {

    Recipe recipe;

    @Mock
    Ingredient ingredient;

    @Mock
    NutrientInfo totalNutrients;

    @Mock
    NutrientInfo totalDaily;

    @Mock
    Object object;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
        setValues();
    }

    void setValues() {
        recipe.setUri("uri");
        recipe.setLabel("label");
        recipe.setImage("image");
        recipe.setSource("source");
        recipe.setUrl("url");
        recipe.setShareAs("share as");
        recipe.setYield(0);
        recipe.setDietLabels(List.of("diet label"));
        recipe.setHealthLabels(List.of("health label"));
        recipe.setCautions(List.of("caution"));
        recipe.setIngredientLines(List.of("ingredient line"));
        recipe.setIngredients(List.of(ingredient));
        recipe.setCalories(1);
        recipe.setGlycemicIndex(2);
        recipe.setInflammatoryIndex(3);
        recipe.setTotalCO2Emissions(4);
        recipe.setCo2EmissionsClass("co2 emissions class");
        recipe.setTotalWeight(5);
        recipe.setCuisineType(List.of("cuisine type"));
        recipe.setMealType(List.of("meal type"));
        recipe.setDishType(List.of("dish type"));
        recipe.setInstructions(List.of("instruction"));
        recipe.setTags(List.of("tag"));
        recipe.setExternalId("external id");
        recipe.setTotalNutrients(totalNutrients);
        recipe.setTotalDaily(totalDaily);
        recipe.setDigest(List.of(object));
    }

    @Test
    void testSetters() {
        Mockito.verifyNoInteractions(ingredient);
        Mockito.verifyNoInteractions(totalNutrients);
        Mockito.verifyNoInteractions(totalDaily);
        Mockito.verifyNoInteractions(object);
    }

    @Test
    void testGettersNoList() {
        Assertions.assertEquals("uri", recipe.getUri());
        Assertions.assertEquals("label", recipe.getLabel());
        Assertions.assertEquals("image", recipe.getImage());
        Assertions.assertEquals("source", recipe.getSource());
        Assertions.assertEquals("url", recipe.getUrl());
        Assertions.assertEquals("share as", recipe.getShareAs());
        Assertions.assertEquals(0, recipe.getYield());
        Assertions.assertEquals(1, recipe.getCalories());
        Assertions.assertEquals(2, recipe.getGlycemicIndex());
        Assertions.assertEquals(3, recipe.getInflammatoryIndex());
        Assertions.assertEquals(4, recipe.getTotalCO2Emissions());
        Assertions.assertEquals("co2 emissions class", recipe.getCo2EmissionsClass());
        Assertions.assertEquals(5, recipe.getTotalWeight());
        Assertions.assertEquals("external id", recipe.getExternalId());
        Assertions.assertEquals(totalNutrients, recipe.getTotalNutrients());
        Assertions.assertEquals(totalDaily, recipe.getTotalDaily());
    }

    @Test
    void testGettersList() {
        List<String> dietLabels = recipe.getDietLabels();
        List<String> healthLabels = recipe.getHealthLabels();
        List<String> cautions = recipe.getCautions();
        List<String> ingredientLines = recipe.getIngredientLines();
        List<Ingredient> ingredients = recipe.getIngredients();
        List<String> cuisineType = recipe.getCuisineType();
        List<String> mealType = recipe.getMealType();
        List<String> dishType = recipe.getDishType();
        List<String> instructions = recipe.getInstructions();
        List<String> tags = recipe.getTags();
        List<Object> digest = recipe.getDigest();

        Assertions.assertEquals(1, dietLabels.size());
        Assertions.assertEquals("diet label", dietLabels.get(0));
        Assertions.assertEquals(1, healthLabels.size());
        Assertions.assertEquals("health label", healthLabels.get(0));
        Assertions.assertEquals(1, cautions.size());
        Assertions.assertEquals("caution", cautions.get(0));
        Assertions.assertEquals(1, ingredientLines.size());
        Assertions.assertEquals("ingredient line", ingredientLines.get(0));
        Assertions.assertEquals(1, ingredients.size());
        Assertions.assertEquals(ingredient, ingredients.get(0));
        Assertions.assertEquals(1, cuisineType.size());
        Assertions.assertEquals("cuisine type", cuisineType.get(0));
        Assertions.assertEquals(1, mealType.size());
        Assertions.assertEquals("meal type", mealType.get(0));
        Assertions.assertEquals(1, dishType.size());
        Assertions.assertEquals("dish type", dishType.get(0));
        Assertions.assertEquals(1, instructions.size());
        Assertions.assertEquals("instruction", instructions.get(0));
        Assertions.assertEquals(1, tags.size());
        Assertions.assertEquals("tag", tags.get(0));
        Assertions.assertEquals(1, digest.size());
        Assertions.assertEquals(object, digest.get(0));
    }

}
