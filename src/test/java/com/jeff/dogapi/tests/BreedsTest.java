package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.BreedsService;
import com.jeff.dogapi.validator.BreedsValidator;
import com.jeff.dogapi.validator.CommonValidator;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@Epic("AAA - Testes Programáticos")
@Feature("Breeds")
@Owner("Jeff")
@Link(name = "Dog API - Breeds", url = "https://dog.ceo/dog-api/documentation")
@DisplayName("Testes de raças de cães")
public class BreedsTest {

    private final BreedsService breedsService = new BreedsService();
    private final CommonValidator commonValidator = new CommonValidator();
    private final BreedsValidator breedsValidator = new BreedsValidator();

    @Test
    @Story("Listar todas as raças")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida que o endpoint /breeds/list/all retorna todas as raças em lowercase, "
            + "com sub-raças como listas, dentro do tempo limite e conforme o schema definido.")
    @DisplayName("Deve listar todas as raças de cachorro com sucesso")
    void shouldListAllBreedsSuccessfully() {

        Response response = breedsService.listAllBreeds();

        commonValidator.validateStatus(response, 200);
        commonValidator.validateResponseStatus(response, "success");
        commonValidator.validateSchema(response, "schemas/breeds-schema.json");
        breedsValidator.validateLowercaseBreeds(response);
        breedsValidator.validateSubBreedsAreLists(response);
        commonValidator.validateResponseTime(response, 5);
        breedsValidator.validateBreedsNotEmpty(response);
    }
}
