package com.jeff.dogapi.validator;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CommonValidator {

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

    public void validateResponseTime(Response response, int timeoutSeconds) {
        response.then().time(lessThan(timeoutSeconds * 1000L));
    }
}
