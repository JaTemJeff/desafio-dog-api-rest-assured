package com.jeff.dogapi.steps;

import com.jeff.dogapi.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CommonSteps extends BaseStep{
    public CommonSteps(TestContext context) {
        super(context);
    }

    @Then("deve retornar status code {int}")
    public void deveRetornarStatusCode(int statusCode) {
        breedsValidator.validateStatus(context.response, statusCode);
    }

    @And("a resposta deve conter o status {string}")
    public void aRespostaDeveConterOStatus(String status) {
        breedsValidator.validateResponseStatus(context.response, status);
    }

    @And("a resposta deve seguir o contrato {string}")
    public void aRespostaDeveSeguirOContratoDefinido(String schema) {
        breedsValidator.validateSchema(context.response, schema);
    }

    @And("o tempo de resposta deve ser menor que {int} segundos")
    public void oTempoDeRespostaDeveSerMenorQueSegundos(int timeOut) {
        breedsValidator.validateResponseTime(context.response, timeOut);
    }
}
