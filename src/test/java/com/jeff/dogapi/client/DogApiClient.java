package com.jeff.dogapi.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DogApiClient {

    private static final String BASE_URL = "https://dog.ceo/api";

    public Response get(String path) {
        return given()
                .baseUri(BASE_URL)
                .when()
                .get(path);
    }
}
