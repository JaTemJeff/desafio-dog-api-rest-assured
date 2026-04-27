package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.ImagesService;
import com.jeff.dogapi.validator.CommonValidator;
import com.jeff.dogapi.validator.ImagesValidator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("AAA")
@Feature("Images")
@DisplayName("Testes de imagens de cães")
public class ImagesTest {

    private final ImagesService imagesService = new ImagesService();
    private final CommonValidator commonValidator = new CommonValidator();
    private final ImagesValidator imagesValidator = new ImagesValidator();

    @Test
    @Story("Listar imagens por raça")
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
    @DisplayName("Deve retornar erro ao tentar listar uma raça inválida")
    void shouldReturnErrorForInvalidBreed() {

        String breed = "nao_existe";

        Response response = imagesService.getImagesByBreed(breed);

        commonValidator.validateStatus(response, 404);
        commonValidator.validateResponseStatus(response, "error");
    }

    @Test
    @Story("Imagem aleatória")
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
