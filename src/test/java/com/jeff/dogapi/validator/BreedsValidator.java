package com.jeff.dogapi.validator;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BreedsValidator {

    public void validateLowercaseBreeds(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.keySet().forEach(breed ->
                assertThat(breed).isEqualTo(breed.toLowerCase())
        );
    }

    public void validateSubBreedsAreLists(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.values().forEach(subBreeds -> {
            assertThat(subBreeds).isNotNull();
            assertThat(subBreeds).isInstanceOf(List.class);
        });
    }

    public void validateBreedsNotEmpty(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        assertThat(breeds).isNotEmpty();
    }
}
