package com.github.donaldwilson8.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.donaldwilson8.exception.CustomExceptions;
import com.github.donaldwilson8.model.Hit;
import com.github.donaldwilson8.model.Recipe;
import com.github.donaldwilson8.model.RecipeSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EdamamService {

    @Value("${edamam.api.id}")
    private String edamamApiId;
    @Value("${edamam.api.key}")
    private String edamamApiKey;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(EdamamService.class);

    public EdamamService(ObjectMapper objectMapper) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.edamam.com/api/recipes/v2")
                .build();
        this.objectMapper = objectMapper;
    }

    public List<Recipe> searchRecipes(String query) {


        Mono<String> response = webClient.get()
                .uri(uriBuilder ->
                    uriBuilder
                            .queryParam("type", "public")
                            .queryParam("q", query)
                            .queryParam("app_id", edamamApiId)
                            .queryParam("app_key", edamamApiKey)
                            .queryParam("field", "uri")
                            .queryParam("field", "label")
                            .build())
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.value() != HttpStatus.OK.value(), clientResponse ->
                        Mono.error(new CustomExceptions.EdamamApiException("Error response from Edamam API: " + clientResponse.statusCode() + "; " + clientResponse.toString()))
                )
                .bodyToMono(String.class);

        return response.flatMap(body -> {
            logger.info("Received response body: {}", body);
            try {
                RecipeSearchResponse searchResponse = objectMapper.readValue(body, RecipeSearchResponse.class);
                return Mono.just(parseResponseToRecipes(searchResponse));
            } catch (IOException e) {
                logger.error("Error deserializing JSON response: {}", e.getMessage());
                return Mono.error(e);
            }
        }).block();


    }

    public List<Recipe> parseResponseToRecipes(RecipeSearchResponse response) {
        List<Recipe> recipes = new ArrayList<>();
        if (response != null && response.getHits() != null) {
            for (Hit hit : response.getHits()) {
                recipes.add(hit.getRecipe());
            }
        }
        return recipes;
    }

}
