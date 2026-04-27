package com.jeff.dogapi.validator;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BreedsValidator {

    @Step("Validar que os nomes das raças estão em lowercase")
    public void validateLowercaseBreeds(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.keySet().forEach(breed ->
                assertThat(breed).isEqualTo(breed.toLowerCase())
        );
    }

    @Step("Validar que as sub-raças são listas válidas")
    public void validateSubBreedsAreLists(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.values().forEach(subBreeds -> {
            assertThat(subBreeds).isNotNull();
            assertThat(subBreeds).isInstanceOf(List.class);
        });
    }

    @Step("Validar que a lista de raças não está vazia")
    public void validateBreedsNotEmpty(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        assertThat(breeds).isNotEmpty();
    }
}
