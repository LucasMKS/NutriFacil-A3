package com.gqs.nutrifacil.dto;

public class CalculoAguaResponse {
    private double litrosPorDia;

    public CalculoAguaResponse(double litrosPorDia) {
        this.litrosPorDia = litrosPorDia;
    }

    public double getLitrosPorDia() { return litrosPorDia; }
    public void setLitrosPorDia(double litrosPorDia) { this.litrosPorDia = litrosPorDia; }
}