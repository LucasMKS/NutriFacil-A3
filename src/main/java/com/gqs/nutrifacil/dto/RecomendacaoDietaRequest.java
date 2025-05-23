package com.gqs.nutrifacil.dto;

import java.util.List;

import lombok.Data;

@Data
public class RecomendacaoDietaRequest {
    private String tipoDieta;
    private List<String> restricoes;

    private double peso;
    private double altura;
    private int idade;
    private String sexo;
    private String objetivo; // emagrecimento, hipertrofia, etc
    private List<String> preferenciasProteinas;
    private List<String> preferenciasLegumes;
    private List<String> preferenciasVerduras;
    private List<String> preferenciasCarboidratos;
    private List<String> alergiasIntolerancias;

    public String getTipoDieta() { return tipoDieta; }
    public void setTipoDieta(String tipoDieta) { this.tipoDieta = tipoDieta; }
    public List<String> getRestricoes() { return restricoes; }
    public void setRestricoes(List<String> restricoes) { this.restricoes = restricoes; }
}