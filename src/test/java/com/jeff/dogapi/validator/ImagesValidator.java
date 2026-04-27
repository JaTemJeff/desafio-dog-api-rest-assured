package com.jeff.dogapi.validator;

import io.restassured.response.Response;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ImagesValidator {

    public void validateImageUrls(Response response) {
        List<String> images = response.jsonPath().getList("message");

        assertThat(images).isNotEmpty();

        images.forEach(url -> {
            assertThat(url)
                    .as("URL inválida: %s", url)
                    .startsWith("https://");
            URI uri = URI.create(url);
            String path = uri.getPath();
            assertThat(path)
                    .as("URL não termina com extensão de imagem válida: %s", url)
                    .matches(".*\\.(jpg|jpeg|png)$");
        });
    }

    public void validateSingleImageUrl(Response response) {
        String image = response.jsonPath().getString("message");

        assertThat(image).isNotNull();
        assertThat(image)
                .as("URL inválida: %s", image)
                .startsWith("https://");
        URI uri = URI.create(image);
        String path = uri.getPath();
        assertThat(path)
                .as("URL não termina com extensão de imagem válida: %s", image)
                .matches(".*\\.(jpg|jpeg|png)$");
    }

    public void validateImageListNotEmpty(Response response) {
        List<String> images = response.jsonPath().getList("message");

        assertThat(images).isNotNull().isNotEmpty();
    }
}
