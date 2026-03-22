package com.jeff.dogapi.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BreedsSteps extends BaseStep {
    private String breed;

    @When("enviar uma requisição GET para listar todas as raças")
    public void enviarUmaRequisicaoGETParaListarTodasAsRacas() {
        response = breedsService.listAllBreeds();
    }

    @Then("deve retornar status code {int}")
    public void deveRetornarStatusCode(int statusCode) {
        breedsValidator.validateStatus(response, statusCode);
    }

    @And("a resposta deve conter o status {string}")
    public void aRespostaDeveConterOStatus(String status) {
        breedsValidator.validateResponseStatus(response, status);
    }

    @And("a resposta deve seguir o contrato {string}")
    public void aRespostaDeveSeguirOContratoDefinido(String schema) {
        breedsValidator.validateSchema(response, schema);
    }

    @And("os nomes das raças devem estar em minúsculas")
    public void osNomesDasRacasDevemEstarEmMinusculas() {
        breedsValidator.validateLowercaseBreeds(response);
    }

    @And("todas as sub-raças devem ser listas")
    public void todasAsSubRacasDevemSerListas() {
        breedsValidator.validateSubBreedsAreLists(response);
    }

    @And("o tempo de resposta deve ser menor que {int} segundos")
    public void oTempoDeRespostaDeveSerMenorQueSegundos(int timeOut) {
        breedsValidator.validateResponseTime(response, timeOut);
    }

    @And("a lista de raças deve conter pelo menos um item")
    public void aListaDeRacasDeveConterPeloMenosUmItem() {
        breedsValidator.validateBreedsNotEmpty(response);
    }

    @Given("que tenho a raça {string} para consulta")
    public void queTenhoARacaaParaConsulta(String breed) {
        this.breed = breed;
    }

    @When("enviar uma requisição GET para listar uma imagem por raça")
    public void enviarUmaRequisicaoGETParaListarUmaImagemPorRaca() {
        response = breedsService.getImagesByBreed(this.breed);
    }

    @And("todas as imagens retornadas devem ser URLs válidas")
    public void todasAsImagensRetornadasDevemSerURLsValidas() {
        breedsValidator.validateImageUrls(response);
    }

    @And("a lista de imagens deve conter pelo menos um item")
    public void aListaDeImagensDeveConterPeloMenosUmItem() {
        breedsValidator.validateImageListNotEmpty(response);
    }

    @When("enviar uma requisição GET para listar uma imagem aleatória")
    public void enviarUmaRequisicaoGETParaListarUmaImagemAleatoria() {
        response = breedsService.getRandomImage();
    }

    @And("a resposta deve conter uma URL de imagem válida")
    public void aRespostaDeveConterUmaURLDeImagemValida() {
        breedsValidator.validateSingleImageUrl(response);
    }
}
