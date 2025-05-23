package com.gqs.nutrifacil.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImcServiceTest {

    private final ImcService service = new ImcService();

    @Test
    void deveCalcularImcCorretamente() {
        var resposta = service.calcularImc(70, 1.75);
        assertEquals(22.86, Math.round(resposta.getImc() * 100.0) / 100.0);
        assertEquals("Peso normal", resposta.getClassificacao());
    }

    @Test
    void deveClassificarAbaixoDoPeso() {
        var resposta = service.calcularImc(50, 1.75);
        assertEquals("Abaixo do peso", resposta.getClassificacao());
    }

    @Test
    void deveClassificarObesidade() {
        var resposta = service.calcularImc(100, 1.60);
        assertEquals("Obesidade", resposta.getClassificacao());
    }
}