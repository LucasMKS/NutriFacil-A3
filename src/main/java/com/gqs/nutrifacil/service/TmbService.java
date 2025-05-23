package com.gqs.nutrifacil.service;

import org.springframework.stereotype.Service;

import com.gqs.nutrifacil.dto.CalculoTmbRequest;
import com.gqs.nutrifacil.dto.CalculoTmbResponse;

@Service
public class TmbService {

    public CalculoTmbResponse calcularTmb(CalculoTmbRequest req) {
        double tmb;
        if ("M".equalsIgnoreCase(req.getSexo())) {
            tmb = 10 * req.getPeso() + 6.25 * req.getAltura() - 5 * req.getIdade() + 5;  
        } else {
            tmb = 10 * req.getPeso() + 6.25 * req.getAltura() - 5 * req.getIdade() - 161;
        }
        return new CalculoTmbResponse(tmb);
    }
}