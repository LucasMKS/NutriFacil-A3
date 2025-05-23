package com.gqs.nutrifacil.service;

import com.gqs.nutrifacil.dto.CalculoTmbRequest;
import com.gqs.nutrifacil.dto.CalculoTmbResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TmbServiceTest {

    private final TmbService service = new TmbService();

    @Test
    void deveCalcularTmbMasculino() {
        CalculoTmbRequest req = new CalculoTmbRequest();
        req.setSexo("M");
        req.setPeso(70);
        req.setAltura(175);
        req.setIdade(25);
        CalculoTmbResponse resp = service.calcularTmb(req);
        // O valor exato depende da fórmula (usando Harris-Benedict)
        assertEquals(1673.75, Math.round(resp.getTmb() * 100.0) / 100.0);
    }

    @Test
    void deveCalcularTmbFeminino() {
        CalculoTmbRequest req = new CalculoTmbRequest();
        req.setSexo("F");
        req.setPeso(60);
        req.setAltura(165);
        req.setIdade(30);
        CalculoTmbResponse resp = service.calcularTmb(req);
        assertEquals(1320.25, Math.round(resp.getTmb() * 100.0) / 100.0);
    }
}