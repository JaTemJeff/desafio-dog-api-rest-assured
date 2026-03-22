package com.jeff.dogapi.validator;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class BreedsValidator {

    public void validateStatus(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validateResponseStatus(Response response, String expectedStatus) {
        response.then()
                .body("status", notNullValue())
                .body("status", equalTo(expectedStatus));
    }

    public void validateSchema(Response response, String schemaPath) {
        response.then()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

    public void validateLowercaseBreeds(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.keySet().forEach(breed ->
                assertThat(breed).isEqualTo(breed.toLowerCase())
        );
    }

    public void validateSubBreedsAreLists(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        breeds.values().forEach(subBreeds ->
                assertThat(subBreeds).isNotNull()
        );
    }

    public void validateResponseTime(Response response, int timeoutSeconds) {
        response.then().time(lessThan(timeoutSeconds * 1000L));
    }

    public void validateBreedsNotEmpty(Response response) {
        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        assertThat(breeds).isNotEmpty();
    }


}
