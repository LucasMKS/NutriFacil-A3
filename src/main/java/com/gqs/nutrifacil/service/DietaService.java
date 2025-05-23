package com.gqs.nutrifacil.service;

import org.springframework.stereotype.Service;

import com.gqs.nutrifacil.dto.RecomendacaoDietaResponse;

import java.util.*;


@Service
public class DietaService {
    public RecomendacaoDietaResponse recomendar(String tipoDieta, List<String> restricoes) {
        List<String> base;
        if ("mediterranea".equalsIgnoreCase(tipoDieta)) {
            base = new ArrayList<>(Arrays.asList("Azeite de oliva", "Peixes", "Grãos integrais", "Legumes", "Frutas"));
        } else if ("lowcarb".equalsIgnoreCase(tipoDieta)) {
            base = new ArrayList<>(Arrays.asList("Ovos", "Frango", "Abacate", "Nozes", "Folhas verdes"));
        } else if ("vegetariana".equalsIgnoreCase(tipoDieta)) {
            base = new ArrayList<>(Arrays.asList("Leguminosas", "Tofu", "Verduras", "Frutas"));
        } else if ("vegana".equalsIgnoreCase(tipoDieta)) {
            base = new ArrayList<>(Arrays.asList("Leguminosas", "Verduras", "Frutas", "Cereais integrais"));
        } else {
            base = new ArrayList<>(Arrays.asList("Arroz", "Feijão", "Salada"));
        }
        if (restricoes != null) {
            base.removeIf(item -> restricoes.stream().anyMatch(r -> item.toLowerCase().contains(r.toLowerCase())));
        }
        return new RecomendacaoDietaResponse(base);
    }
}