package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HitTest {

    @InjectMocks
    Hit hit;

    @Mock
    Recipe recipe;

    @Mock
    Links _links;

    @Test
    void testGetters() {
        Assertions.assertEquals(recipe, hit.getRecipe());
        Assertions.assertEquals(_links, hit.get_links());
    }

    @Test
    void testSetters() {
        hit.setRecipe(recipe);
        hit.set_links(_links);

        Mockito.verifyNoInteractions(recipe);
        Mockito.verifyNoInteractions(_links);
    }

}
