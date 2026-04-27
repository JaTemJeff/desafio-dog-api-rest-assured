package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.ImagesService;
import com.jeff.dogapi.validator.CommonValidator;
import com.jeff.dogapi.validator.ImagesValidator;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("AAA - Testes Programáticos")
@Feature("Images")
@Owner("Jeff")
@Link(name = "Dog API - Images", url = "https://dog.ceo/dog-api/documentation")
@DisplayName("Testes de imagens de cães")
public class ImagesTest {

    private final ImagesService imagesService = new ImagesService();
    private final CommonValidator commonValidator = new CommonValidator();
    private final ImagesValidator imagesValidator = new ImagesValidator();

    @Test
    @Story("Listar imagens por raça")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida que o endpoint /breed/{breed}/images retorna uma lista de URLs de imagens válidas, "
            + "não vazia, dentro do tempo limite e conforme o schema definido.")
    @DisplayName("Deve listar imagens de acordo com a raça do cachorro")
    void shouldListImagesByBreedSuccessfully() {

        String breed = "akita";

        Response response = imagesService.getImagesByBreed(breed);

        commonValidator.validateStatus(response, 200);
        commonValidator.validateResponseStatus(response, "success");
        commonValidator.validateSchema(response, "schemas/breed-images-schema.json");
        imagesValidator.validateImageUrls(response);
        imagesValidator.validateImageListNotEmpty(response);
        commonValidator.validateResponseTime(response, 5);
    }

    @Test
    @Story("Raça inválida")
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida que o endpoint /breed/{breed}/images retorna status 404 e status 'error' "
            + "quando uma raça inexistente é informada.")
    @DisplayName("Deve retornar erro ao tentar listar uma raça inválida")
    void shouldReturnErrorForInvalidBreed() {

        String breed = "nao_existe";

        Response response = imagesService.getImagesByBreed(breed);

        commonValidator.validateStatus(response, 404);
        commonValidator.validateResponseStatus(response, "error");
    }

    @Test
    @Story("Imagem aleatória")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida que o endpoint /breeds/image/random retorna uma URL de imagem válida, "
            + "dentro do tempo limite e conforme o schema definido.")
    @DisplayName("Deve listar imagem aleatória da raça do cachorro")
    void shouldReturnRandomImageSuccessfully() {

        Response response = imagesService.getRandomImage();

        commonValidator.validateStatus(response, 200);
        commonValidator.validateResponseStatus(response, "success");
        commonValidator.validateSchema(response, "schemas/random-image-schema.json");
        imagesValidator.validateSingleImageUrl(response);
        commonValidator.validateResponseTime(response, 5);
    }
}
