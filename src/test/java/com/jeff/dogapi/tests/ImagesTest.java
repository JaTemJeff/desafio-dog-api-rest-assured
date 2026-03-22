package com.jeff.dogapi.tests;

import com.jeff.dogapi.service.ImagesService;
import com.jeff.dogapi.validator.BreedsValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ImagesTest {

    private final ImagesService imagesService = new ImagesService();
    private final BreedsValidator validator = new BreedsValidator();

    @Test
    void shouldListImagesByBreedSuccessfully() {

        // Arrange
        String breed = "akita";

        // Act
        Response response = imagesService.getImagesByBreed(breed);

        // Assert
        validator.validateStatus(response, 200);
        validator.validateResponseStatus(response, "success");
        validator.validateSchema(response, "schemas/breed-images-schema.json");
        validator.validateImageUrls(response);
        validator.validateImageListNotEmpty(response);
        validator.validateResponseTime(response, 2);
    }

    @Test
    void shouldReturnErrorForInvalidBreed() {

        // Arrange
        String breed = "nao_existe";

        // Act
        Response response = imagesService.getImagesByBreed(breed);

        // Assert
        validator.validateStatus(response, 404);
        validator.validateResponseStatus(response, "error");
    }

    @Test
    void shouldReturnRandomImageSuccessfully() {

        // Arrange
        // sem dados

        // Act
        Response response = imagesService.getRandomImage();

        // Assert
        validator.validateStatus(response, 200);
        validator.validateResponseStatus(response, "success");
        validator.validateSchema(response, "schemas/random-image-schema.json");
        validator.validateSingleImageUrl(response);
        validator.validateResponseTime(response, 2);
    }
}
