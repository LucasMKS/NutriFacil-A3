package com.gqs.nutrifacil.controller;

import com.gqs.nutrifacil.dto.CalculoImcRequest;
import com.gqs.nutrifacil.dto.CalculoImcResponse;
import com.gqs.nutrifacil.service.ImcService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public CalculoImcResponse calcularImc(@RequestBody CalculoImcRequest request) {
        return imcService.calcularImc(request.getPeso(), request.getAltura());
    }
}