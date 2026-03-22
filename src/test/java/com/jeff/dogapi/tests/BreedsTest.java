package com.jeff.dogapi.tests;

import com.jeff.dogapi.steps.BreedsSteps;
import org.junit.jupiter.api.Test;

public class BreedsTest {
    private BreedsSteps breedsSteps = new BreedsSteps();

    @Test
    public void listarTodasAsRacasDeCachorro() {
        breedsSteps.enviarUmaRequisicaoGETParaListarTodasAsRacas();
        breedsSteps.deveRetornarStatusCode(200);
        breedsSteps.aRespostaDeveConterOStatus("");
        breedsSteps.aRespostaDeveSeguirOContratoDefinido("schemas/breeds-schema.json");
        breedsSteps.osNomesDasRacasDevemEstarEmMinusculas();
        breedsSteps.todasAsSubRacasDevemSerListas();
        breedsSteps.oTempoDeRespostaDeveSerMenorQueSegundos(2);
        breedsSteps.aListaDeRacasDeveConterPeloMenosUmItem();
    }
}
