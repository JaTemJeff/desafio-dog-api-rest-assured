package com.jeff.dogapi.validator;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CommonValidator {

    @Step("Validar status code: {statusCode}")
    public void validateStatus(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Step("Validar que o campo 'status' é '{expectedStatus}'")
    public void validateResponseStatus(Response response, String expectedStatus) {
        response.then()
                .body("status", notNullValue())
                .body("status", equalTo(expectedStatus));
    }

    @Step("Validar contrato JSON Schema: {schemaPath}")
    public void validateSchema(Response response, String schemaPath) {
        response.then()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

    @Step("Validar tempo de resposta menor que {timeoutSeconds} segundos")
    public void validateResponseTime(Response response, int timeoutSeconds) {
        response.then().time(lessThan(timeoutSeconds * 1000L));
    }

    @Attachment(value = "Response Body", type = "application/json")
    public String attachResponseBody(Response response) {
        return response.getBody().asPrettyString();
    }
}
