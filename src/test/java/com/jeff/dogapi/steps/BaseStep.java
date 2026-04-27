package com.jeff.dogapi.steps;

import com.jeff.dogapi.context.TestContext;
import com.jeff.dogapi.validator.BreedsValidator;
import com.jeff.dogapi.validator.CommonValidator;
import com.jeff.dogapi.validator.ImagesValidator;
import io.restassured.response.Response;

public abstract class BaseStep {

    protected final TestContext context;
    protected final CommonValidator commonValidator = new CommonValidator();
    protected final BreedsValidator breedsValidator = new BreedsValidator();
    protected final ImagesValidator imagesValidator = new ImagesValidator();
    protected Response response;

    public BaseStep(TestContext context) {
        this.context = context;
    }
}
