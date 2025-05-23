package com.gqs.nutrifacil.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReceitaIARequest {
    private String tipoDieta;
    private List<String> preferenciasProteinas;
    private List<String> preferenciasLegumes;
    private List<String> preferenciasVerduras;
    private List<String> preferenciasCarboidratos;
    private List<String> alergiasIntolerancias;

}