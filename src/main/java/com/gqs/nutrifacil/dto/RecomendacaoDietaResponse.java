package com.gqs.nutrifacil.dto;

import java.util.List;

public class RecomendacaoDietaResponse {
    private List<String> recomendacoes;

    public RecomendacaoDietaResponse(List<String> recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public List<String> getRecomendacoes() { return recomendacoes; }
    public void setRecomendacoes(List<String> recomendacoes) { this.recomendacoes = recomendacoes; }
}