package com.jeff.dogapi.tests;

import com.jeff.dogapi.steps.BreedsStep;
import org.junit.jupiter.api.Test;

public class BreedsTest {
    private BreedsStep breedsStep = new BreedsStep();

    @Test
    public void listarTodasAsRacasDeCachorro() {
        breedsStep.enviarUmaRequisicaoGETParaListarTodasAsRacas();
        breedsStep.deveRetornarStatusCode(200);
        breedsStep.aRespostaDeveConterOStatus("");
        breedsStep.aRespostaDeveSeguirOContratoDefinido();
        breedsStep.osNomesDasRacasDevemEstarEmMinusculas();
        breedsStep.todasAsSubRacasDevemSerListas();
        breedsStep.oTempoDeRespostaDeveSerMenorQueSegundos(2);
        breedsStep.aListaDeRacasDeveConterPeloMenosUmItem();
    }
}
