package com.gqs.nutrifacil.service;

import org.junit.jupiter.api.Test;
import com.gqs.nutrifacil.dto.RecomendacaoDietaResponse;
import com.gqs.nutrifacil.dto.RecomendacaoDietaRequest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DietaServiceTest {

    private final DietaService service = new DietaService();

    @Test
    void deveRecomendarAlimentosParaDietaMediterranea() {
        RecomendacaoDietaRequest req = new RecomendacaoDietaRequest();
        req.setTipoDieta("mediterranea");
        // restricoes pode ser null ou lista vazia
        req.setRestricoes(null);

        RecomendacaoDietaResponse resp = service.recomendar(req);

        assertTrue(
            resp.getRecomendacoes().stream()
                .anyMatch(a -> a.equalsIgnoreCase("Frango")),
            "A lista de recomendações deve conter 'Frango'"
        );
    }

    @Test
    void deveRespeitarRestricoesNaRecomendacao() {
        RecomendacaoDietaRequest req = new RecomendacaoDietaRequest();
        req.setTipoDieta("lowcarb");
        req.setRestricoes(Arrays.asList("nozes"));

        RecomendacaoDietaResponse resp = service.recomendar(req);

        assertFalse(
            resp.getRecomendacoes().stream()
                .anyMatch(a -> a.equalsIgnoreCase("Nozes")),
            "A lista de recomendações NÃO deve conter 'Nozes' quando restrito"
        );
    }
}