package com.jeff.dogapi.context;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
    private Response response;
}
