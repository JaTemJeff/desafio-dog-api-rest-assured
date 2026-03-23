package com.jeff.dogapi.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import io.qameta.allure.restassured.AllureRestAssured;

public class DogApiClient {

    private static final String BASE_URL = "https://dog.ceo/api";

    public Response get(String path) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(BASE_URL)
                .log().method()
                .log().uri()
                .when()
                .get(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

}
