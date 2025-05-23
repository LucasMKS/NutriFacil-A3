package com.gqs.nutrifacil.controller;

import org.springframework.web.bind.annotation.*;

import com.gqs.nutrifacil.dto.CalculoTmbRequest;
import com.gqs.nutrifacil.dto.CalculoTmbResponse;
import com.gqs.nutrifacil.service.TmbService;

@RestController
@RequestMapping("/api/tmb")
public class TmbController {
    private final TmbService tmbService;

    public TmbController(TmbService tmbService) {
        this.tmbService = tmbService;
    }

    @PostMapping("/calcular")
    public CalculoTmbResponse calcularTmb(@RequestBody CalculoTmbRequest request) {
        return tmbService.calcularTmb(request);
    }
}