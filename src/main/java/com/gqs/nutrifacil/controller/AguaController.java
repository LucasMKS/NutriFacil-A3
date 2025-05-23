package com.gqs.nutrifacil.controller;

import org.springframework.web.bind.annotation.*;

import com.gqs.nutrifacil.dto.CalculoAguaRequest;
import com.gqs.nutrifacil.dto.CalculoAguaResponse;
import com.gqs.nutrifacil.service.AguaService;

@RestController
@RequestMapping("/api/agua")
public class AguaController {
    private final AguaService aguaService;

    public AguaController(AguaService aguaService) {
        this.aguaService = aguaService;
    }

    @PostMapping("/calcular")
    public CalculoAguaResponse calcularAgua(@RequestBody CalculoAguaRequest request) {
        return aguaService.calcularAgua(request.getPeso());
    }
}