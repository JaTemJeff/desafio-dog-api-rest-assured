package com.jeff.dogapi.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BreedsStep {

    @Given("a api {string} está disponível")
    public void aApiEstaDisponivel(String api_path) {

    }

    @When("enviar uma requisição GET para")
    public void enviarUmaRequisicaoGETPara() {
    }

    @Then("deve retornar status code {int}")
    public void deveRetornarStatusCode(int arg0) {
    }

    @And("a resposta deve conter o status {string}")
    public void aRespostaDeveConterOStatus(String statusCode) {
    }

    @And("a resposta deve seguir o contrato definido")
    public void aRespostaDeveSeguirOContratoDefinido() {
    }

    @And("os nomes das raças devem estar em minúsculas")
    public void osNomesDasRacasDevemEstarEmMinusculas() {
    }

    @And("todas as sub-raças devem ser listas")
    public void todasAsSubRacasDevemSerListas() {
    }

    @And("o tempo de resposta deve ser menor que {int} segundos")
    public void oTempoDeRespostaDeveSerMenorQueSegundos(int timeOut) {
    }

    @And("a lista de raças deve conter pelo menos um item")
    public void aListaDeRacasDeveConterPeloMenosUmItem() {
    }
}
