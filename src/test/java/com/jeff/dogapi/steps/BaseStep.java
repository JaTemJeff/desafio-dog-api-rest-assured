package com.jeff.dogapi.steps;

import com.jeff.dogapi.context.TestContext;
import com.jeff.dogapi.validator.BreedsValidator;
import io.restassured.response.Response;

public abstract class BaseStep {

    protected final TestContext context;
    protected final BreedsValidator breedsValidator = new BreedsValidator();
    protected Response response;

    public BaseStep(TestContext context) {
        this.context = context;
    }
}
