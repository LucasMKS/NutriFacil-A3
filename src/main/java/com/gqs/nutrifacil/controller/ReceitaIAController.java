package com.gqs.nutrifacil.controller;


import com.gqs.nutrifacil.dto.ReceitaIARequest;
import com.gqs.nutrifacil.dto.ReceitaGerada;
import com.gqs.nutrifacil.service.ReceitaIAService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas-ia")
@CrossOrigin
public class ReceitaIAController {

    private final ReceitaIAService service;

    public ReceitaIAController(ReceitaIAService service) {
        this.service = service;
    }

    @PostMapping
    public List<ReceitaGerada> gerarReceitas(@RequestBody ReceitaIARequest req) throws Exception {
        return service.gerarReceitas(req);
    }
}