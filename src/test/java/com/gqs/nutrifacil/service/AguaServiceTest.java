package com.gqs.nutrifacil.service;

import org.junit.jupiter.api.Test;
import com.gqs.nutrifacil.dto.CalculoAguaResponse;
import static org.junit.jupiter.api.Assertions.*;

class AguaServiceTest {

    private final AguaService service = new AguaService();

    @Test
    void deveCalcularConsumoDeAgua() {
        CalculoAguaResponse resp = service.calcularAgua(70);
        assertEquals(2.45, Math.round(resp.getLitrosPorDia() * 100.0) / 100.0);
    }
}