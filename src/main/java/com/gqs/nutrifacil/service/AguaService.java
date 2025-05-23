package com.gqs.nutrifacil.service;

import org.springframework.stereotype.Service;

import com.gqs.nutrifacil.dto.CalculoAguaResponse;

@Service
public class AguaService {
    public CalculoAguaResponse calcularAgua(double peso) {
        double litros = peso * 0.035; // 35ml por kg = 0.035L
        return new CalculoAguaResponse(litros);
    }
}