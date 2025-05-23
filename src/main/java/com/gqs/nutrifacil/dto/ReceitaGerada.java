package com.gqs.nutrifacil.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReceitaGerada {
    private String nome;
    private List<String> ingredientes;
    private String modoPreparo;

}