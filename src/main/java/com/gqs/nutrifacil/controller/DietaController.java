package com.gqs.nutrifacil.controller;

import org.springframework.web.bind.annotation.*;

import com.gqs.nutrifacil.dto.RecomendacaoDietaRequest;
import com.gqs.nutrifacil.dto.RecomendacaoDietaResponse;
import com.gqs.nutrifacil.service.DietaService;

@RestController
@RequestMapping("/api/dieta")
public class DietaController {
    private final DietaService dietaService;

    public DietaController(DietaService dietaService) {
        this.dietaService = dietaService;
    }

    @PostMapping("/recomendar")
    public RecomendacaoDietaResponse recomendar(@RequestBody RecomendacaoDietaRequest req) {
        return dietaService.recomendar(req.getTipoDieta(), req.getRestricoes());
    }
}