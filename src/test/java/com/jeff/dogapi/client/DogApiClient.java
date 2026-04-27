package com.jeff.dogapi.client;

import io.restassured.response.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import io.qameta.allure.restassured.AllureRestAssured;

public class DogApiClient {

    private static final String BASE_URL;

    static {
        Properties props = new Properties();
        try (InputStream is = DogApiClient.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config.properties", e);
        }
        BASE_URL = props.getProperty("base.url", "https://dog.ceo/api");
    }

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
