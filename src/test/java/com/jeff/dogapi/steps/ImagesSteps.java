package com.jeff.dogapi.steps;

import com.jeff.dogapi.context.TestContext;
import com.jeff.dogapi.service.ImagesService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ImagesSteps extends BaseStep {

    private final ImagesService imagesService = new ImagesService();
    private String breed;

    public ImagesSteps(TestContext context) {
        super(context);
    }

    @Given("que tenho a raça {string} para consulta")
    public void queTenhoARacaaParaConsulta(String breed) {
        this.breed = breed;
    }

    @When("enviar uma requisição GET para listar uma imagem por raça")
    public void enviarUmaRequisicaoGETParaListarUmaImagemPorRaca() {
        context.setResponse(imagesService.getImagesByBreed(this.breed));
    }

    @And("todas as imagens retornadas devem ser URLs válidas")
    public void todasAsImagensRetornadasDevemSerURLsValidas() {
        imagesValidator.validateImageUrls(context.getResponse());
    }

    @And("a lista de imagens deve conter pelo menos um item")
    public void aListaDeImagensDeveConterPeloMenosUmItem() {
        imagesValidator.validateImageListNotEmpty(context.getResponse());
    }

    @When("enviar uma requisição GET para listar uma imagem aleatória")
    public void enviarUmaRequisicaoGETParaListarUmaImagemAleatoria() {
        context.setResponse(imagesService.getRandomImage());
    }

    @And("a resposta deve conter uma URL de imagem válida")
    public void aRespostaDeveConterUmaURLDeImagemValida() {
        imagesValidator.validateSingleImageUrl(context.getResponse());
    }
}
