package com.jeff.dogapi.config;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void before() {
        RestAssured.baseURI = "https://dog.ceo/api";
    }
}
