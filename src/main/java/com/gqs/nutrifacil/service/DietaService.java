package com.gqs.nutrifacil.service;

import org.springframework.stereotype.Service;

import com.gqs.nutrifacil.dto.RecomendacaoDietaRequest;
import com.gqs.nutrifacil.dto.RecomendacaoDietaResponse;

import java.util.*;

@Service
public class DietaService {
    public RecomendacaoDietaResponse recomendar(RecomendacaoDietaRequest req) {
        // Exemplos de listas por dieta
        List<String> proteinas = getBaseProteinas(req.getTipoDieta());
        List<String> legumes = getBaseLegumes();
        List<String> verduras = getBaseVerduras();
        List<String> carboidratos = getBaseCarboidratos(req.getTipoDieta());

        // Aplicar preferências (se não vazio, filtrar para manter só as preferidas)
        if (req.getPreferenciasProteinas() != null && !req.getPreferenciasProteinas().isEmpty())
            proteinas.retainAll(req.getPreferenciasProteinas());
        if (req.getPreferenciasLegumes() != null && !req.getPreferenciasLegumes().isEmpty())
            legumes.retainAll(req.getPreferenciasLegumes());
        if (req.getPreferenciasVerduras() != null && !req.getPreferenciasVerduras().isEmpty())
            verduras.retainAll(req.getPreferenciasVerduras());
        if (req.getPreferenciasCarboidratos() != null && !req.getPreferenciasCarboidratos().isEmpty())
            carboidratos.retainAll(req.getPreferenciasCarboidratos());

        // Remover itens de acordo com alergias/intolerâncias
        if (req.getAlergiasIntolerancias() != null && !req.getAlergiasIntolerancias().isEmpty() &&
            !req.getAlergiasIntolerancias().contains("Nenhuma")) {
            removerAlergias(proteinas, legumes, verduras, carboidratos, req.getAlergiasIntolerancias());
        }

        // Objetivo pode influenciar (exemplo simples)
        if ("emagrecimento".equalsIgnoreCase(req.getObjetivo())) {
            carboidratos.removeIf(c -> !c.toLowerCase().contains("integral"));
        }
        if ("hipertrofia".equalsIgnoreCase(req.getObjetivo())) {
            proteinas.add("Whey Protein");
        }

        // Juntar tudo
        List<String> recomendacoes = new ArrayList<>();
        recomendacoes.addAll(proteinas);
        recomendacoes.addAll(legumes);
        recomendacoes.addAll(verduras);
        recomendacoes.addAll(carboidratos);

        return new RecomendacaoDietaResponse(recomendacoes);
    }

    // Métodos auxiliares
    private List<String> getBaseProteinas(String tipoDieta) {
        switch (tipoDieta.toLowerCase()) {
            case "lowcarb":
            case "cetogenica":
                return new ArrayList<>(Arrays.asList(
                    "Frango", "Peixe", "Ovos", "Tofu", "Carne magra",
                    "Grão de bico", "Feijão", "Lentilha"
                ));
            case "vegetariana":
                return new ArrayList<>(Arrays.asList(
                    "Ovos", "Tofu", "Grão de bico", "Feijão", "Lentilha"
                ));
            case "mediterranea":
                return new ArrayList<>(Arrays.asList(
                    "Peixe", "Frango", "Ovos", "Iogurte", "Tofu",
                    "Grão de bico", "Feijão", "Lentilha"
                ));
            default:
                return new ArrayList<>(Arrays.asList(
                    "Peixe", "Frango", "Ovos", "Iogurte", "Tofu",
                    "Grão de bico", "Feijão", "Lentilha"
                ));
        }
    }

    private List<String> getBaseLegumes() {
        return new ArrayList<>(Arrays.asList("Cenoura", "Abobrinha", "Berinjela", "Vagem", "Beterraba"));
    }
    private List<String> getBaseVerduras() {
        return new ArrayList<>(Arrays.asList("Alface", "Rúcula", "Espinafre", "Couve", "Agrião"));
    }
    private List<String> getBaseCarboidratos(String tipoDieta) {
        if ("lowcarb".equalsIgnoreCase(tipoDieta) || "cetogenica".equalsIgnoreCase(tipoDieta))
            return new ArrayList<>(Arrays.asList("Batata-doce", "Quinoa", "Arroz integral"));
        return new ArrayList<>(Arrays.asList("Arroz integral", "Macarrão integral", "Quinoa", "Batata-doce"));
    }

    private void removerAlergias(List<String> proteinas, List<String> legumes, List<String> verduras, List<String> carboidratos, List<String> alergias) {
        if (alergias.stream().anyMatch(a -> a.equalsIgnoreCase("Lactose") || a.equalsIgnoreCase("Proteína do leite"))) {
            proteinas.removeIf(p -> p.toLowerCase().contains("iogurte") || p.toLowerCase().contains("leite") || p.toLowerCase().contains("whey"));
        }
        if (alergias.stream().anyMatch(a -> a.equalsIgnoreCase("Ovo"))) {
            proteinas.removeIf(p -> p.toLowerCase().contains("ovo"));
        }
        if (alergias.stream().anyMatch(a -> a.equalsIgnoreCase("Glúten"))) {
            carboidratos.removeIf(c -> c.toLowerCase().contains("macarrão"));
        }
        if (alergias.stream().anyMatch(a -> a.equalsIgnoreCase("Frutos do mar"))) {
            proteinas.removeIf(p -> p.toLowerCase().contains("peixe") || p.toLowerCase().contains("camarão"));
        }
    }
}