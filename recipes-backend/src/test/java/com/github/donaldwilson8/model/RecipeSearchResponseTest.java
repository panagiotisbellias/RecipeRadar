package com.github.donaldwilson8.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RecipeSearchResponseTest {

    @Test
    void testRecipeSearchResponse() {
        Links _links = Mockito.mock(Links.class);
        Hit hit = Mockito.mock(Hit.class);
        RecipeSearchResponse recipeSearchResponse = new RecipeSearchResponse();

        recipeSearchResponse.setFrom(0);
        recipeSearchResponse.setTo(1);
        recipeSearchResponse.setCount(2);
        recipeSearchResponse.set_links(_links);
        recipeSearchResponse.setHits(List.of(hit));

        Assertions.assertEquals(0, recipeSearchResponse.getFrom());
        Assertions.assertEquals(1, recipeSearchResponse.getTo());
        Assertions.assertEquals(2, recipeSearchResponse.getCount());
        Assertions.assertEquals(_links, recipeSearchResponse.get_links());

        List<Hit> hits = recipeSearchResponse.getHits();
        Assertions.assertEquals(1, hits.size());
        Assertions.assertEquals(hit, hits.get(0));
    }

}
