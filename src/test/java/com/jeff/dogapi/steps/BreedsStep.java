package com.jeff.dogapi.steps;

import com.jeff.dogapi.service.BreedsService;
import com.jeff.dogapi.validator.BreedsValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BreedsStep {

    private BreedsValidator breedsValidator = new BreedsValidator();
    private BreedsService breedsService = new BreedsService();
    private Response response;

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

    @And("a resposta deve seguir o contrato definido")
    public void aRespostaDeveSeguirOContratoDefinido() {
        breedsValidator.validateSchema(response, "schemas/breeds-schema.json");
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
}
