package com.jeff.dogapi.validator;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BreedsValidator {

    public void validateStatus(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validateResponseStatus(Response response, String expectedStatus) {
        response.then()
                .body("status", notNullValue())
                .body("status", equalTo(expectedStatus));
    }
}
