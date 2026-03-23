package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.ImagesService;
import com.jeff.dogapi.validator.BreedsValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Images API - Deve listar imagens por raça ou aleatória")
public class ImagesTest {

    private final ImagesService imagesService = new ImagesService();
    private final BreedsValidator validator = new BreedsValidator();

    @Test
    @DisplayName("Deve listar imagens de acordo com a raça do cachorro")
    void shouldListImagesByBreedSuccessfully() {

        String breed = "akita";

        Response response = imagesService.getImagesByBreed(breed);

        validator.validateStatus(response, 200);
        validator.validateResponseStatus(response, "success");
        validator.validateSchema(response, "schemas/breed-images-schema.json");
        validator.validateImageUrls(response);
        validator.validateImageListNotEmpty(response);
        validator.validateResponseTime(response, 5);
    }

    @Test
    @DisplayName("Deve retornar erro ao tentar listar uma raça inválida")
    void shouldReturnErrorForInvalidBreed() {

        String breed = "nao_existe";

        Response response = imagesService.getImagesByBreed(breed);

        validator.validateStatus(response, 404);
        validator.validateResponseStatus(response, "error");
    }

    @Test
    @DisplayName("Deve listar imagem aleatória da raça do cachorro")
    void shouldReturnRandomImageSuccessfully() {

        Response response = imagesService.getRandomImage();

        validator.validateStatus(response, 200);
        validator.validateResponseStatus(response, "success");
        validator.validateSchema(response, "schemas/random-image-schema.json");
        validator.validateSingleImageUrl(response);
        validator.validateResponseTime(response, 5);
    }
}
