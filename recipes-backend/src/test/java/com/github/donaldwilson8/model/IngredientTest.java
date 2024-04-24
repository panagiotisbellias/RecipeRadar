package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IngredientTest {

    @Test
    void testIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setText("text");
        ingredient.setQuantity(0);
        ingredient.setMeasure("measure");
        ingredient.setFood("food");
        ingredient.setWeight(0);
        ingredient.setFoodId("food id");

        Assertions.assertEquals("text", ingredient.getText());
        Assertions.assertEquals(0, ingredient.getQuantity());
        Assertions.assertEquals("measure", ingredient.getMeasure());
        Assertions.assertEquals("food", ingredient.getFood());
        Assertions.assertEquals(0, ingredient.getWeight());
        Assertions.assertEquals("food id", ingredient.getFoodId());
    }

}
