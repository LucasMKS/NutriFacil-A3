package com.gqs.nutrifacil.dto;

public class CalculoTmbResponse {
    private double tmb;

    public CalculoTmbResponse(double tmb) {
        this.tmb = tmb;
    }

    public double getTmb() { return tmb; }
    public void setTmb(double tmb) { this.tmb = tmb; }
}