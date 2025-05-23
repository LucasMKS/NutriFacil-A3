package com.gqs.nutrifacil.dto;

import java.util.List;

public class RecomendacaoDietaRequest {
    private String tipoDieta;
    private List<String> restricoes;

    public String getTipoDieta() { return tipoDieta; }
    public void setTipoDieta(String tipoDieta) { this.tipoDieta = tipoDieta; }
    public List<String> getRestricoes() { return restricoes; }
    public void setRestricoes(List<String> restricoes) { this.restricoes = restricoes; }
}