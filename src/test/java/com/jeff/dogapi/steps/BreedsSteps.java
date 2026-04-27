package com.jeff.dogapi.steps;

import com.jeff.dogapi.context.TestContext;
import com.jeff.dogapi.service.BreedsService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class BreedsSteps extends BaseStep {

    private final BreedsService breedsService = new BreedsService();

    public BreedsSteps(TestContext context) {
        super(context);
    }

    @When("enviar uma requisição GET para listar todas as raças")
    public void enviarUmaRequisicaoGETParaListarTodasAsRacas() {
        context.setResponse(breedsService.listAllBreeds());
    }

    @And("os nomes das raças devem estar em minúsculas")
    public void osNomesDasRacasDevemEstarEmMinusculas() {
        breedsValidator.validateLowercaseBreeds(context.getResponse());
    }

    @And("todas as sub-raças devem ser listas")
    public void todasAsSubRacasDevemSerListas() {
        breedsValidator.validateSubBreedsAreLists(context.getResponse());
    }

    @And("a lista de raças deve conter pelo menos um item")
    public void aListaDeRacasDeveConterPeloMenosUmItem() {
        breedsValidator.validateBreedsNotEmpty(context.getResponse());
    }

    @When("enviar uma requisição GET para um endpoint de raças inválido")
    public void enviarUmaRequisicaoGETParaUmEndpointDeRacasInvalido() {
        context.setResponse(breedsService.getBreedByName("raca_invalida"));
    }
}
