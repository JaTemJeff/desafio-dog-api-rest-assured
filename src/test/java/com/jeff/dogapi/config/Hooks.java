package config;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void before() {
        RestAssured.baseURI = "https://dummyjson.com";
    }
}
