package com.gqs.nutrifacil.dto;

public class CalculoTmbRequest {
    private double peso;
    private double altura;
    private int idade;
    private String sexo; // "M" ou "F"

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
}