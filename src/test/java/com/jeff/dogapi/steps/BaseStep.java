package com.jeff.dogapi.steps;

import com.jeff.dogapi.service.BreedsService;
import com.jeff.dogapi.validator.BreedsValidator;
import io.restassured.response.Response;

public abstract class BaseStep {
    protected final BreedsService breedsService = new BreedsService();
    protected final BreedsValidator breedsValidator = new BreedsValidator();
    protected Response response;
}
