package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NutrientInfoTest {

    @Test
    void testNutrientInfo() {
        NutrientInfo nutrientInfo = new NutrientInfo();
        nutrientInfo.setLabel("label");
        nutrientInfo.setQuantity(0);
        nutrientInfo.setUnit("unit");

        Assertions.assertEquals("label", nutrientInfo.getLabel());
        Assertions.assertEquals(0, nutrientInfo.getQuantity());
        Assertions.assertEquals("unit", nutrientInfo.getUnit());
    }

}
