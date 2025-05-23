package com.gqs.nutrifacil.dto;

public class CalculoImcResponse {
    private double imc;
    private String classificacao;

    public CalculoImcResponse(double imc, String classificacao) {
        this.imc = imc;
        this.classificacao = classificacao;
    }

    public double getImc() { return imc; }
    public String getClassificacao() { return classificacao; }
}