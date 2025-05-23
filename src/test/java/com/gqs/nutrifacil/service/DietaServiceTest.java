package com.gqs.nutrifacil.service;

import org.junit.jupiter.api.Test;

import com.gqs.nutrifacil.dto.RecomendacaoDietaResponse;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class DietaServiceTest {

    private final DietaService service = new DietaService();

    @Test
    void deveRecomendarAlimentosParaDietaMediterranea() {
        RecomendacaoDietaResponse resp = service.recomendar("mediterranea", null);
        assertTrue(resp.getRecomendacoes().contains("Azeite de oliva"));
    }

    @Test
    void deveRespeitarRestricoesNaRecomendacao() {
        RecomendacaoDietaResponse resp = service.recomendar("lowcarb", Arrays.asList("nozes"));
        assertFalse(resp.getRecomendacoes().contains("Nozes"));
    }
}