package com.gqs.nutrifacil.service;

import com.gqs.nutrifacil.dto.CalculoImcResponse;
import org.springframework.stereotype.Service;

@Service
public class ImcService {

    public CalculoImcResponse calcularImc(double peso, double altura) {
        double imc = peso / (altura * altura);
        String classificacao = classificarImc(imc);
        return new CalculoImcResponse(imc, classificacao);
    }

    private String classificarImc(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 24.9) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        return "Obesidade";
    }
}