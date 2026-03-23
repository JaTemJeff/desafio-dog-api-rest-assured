package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.BreedsService;
import com.jeff.dogapi.validator.BreedsValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Breeds API - Deve listar todas as raças de cachorro")
public class BreedsTest {

    private final BreedsService breedsService = new BreedsService();
    private final BreedsValidator validator = new BreedsValidator();

    @Test
    @DisplayName("Deve listar todas as raças de cachorro com sucesso")
    void shouldListAllBreedsSuccessfully() {

        Response response = breedsService.listAllBreeds();

        validator.validateStatus(response, 200);
        validator.validateResponseStatus(response, "success");
        validator.validateSchema(response, "schemas/breeds-schema.json");
        validator.validateLowercaseBreeds(response);
        validator.validateSubBreedsAreLists(response);
        validator.validateResponseTime(response, 2);
        validator.validateBreedsNotEmpty(response);
    }
}