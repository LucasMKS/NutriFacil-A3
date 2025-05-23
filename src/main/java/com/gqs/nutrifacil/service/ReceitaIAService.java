package com.gqs.nutrifacil.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gqs.nutrifacil.dto.ReceitaIARequest;
import com.gqs.nutrifacil.dto.ReceitaGerada;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ReceitaIAService {

    @Value("${perplexity.key}")
    private String perplexityKey;

    public List<ReceitaGerada> gerarReceitas(ReceitaIARequest req) throws Exception {
        String prompt = montarPrompt(req);
        String resposta = chamarPerplexity(prompt);

        // Extraindo a resposta JSON do retorno da IA
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(resposta);

        // Caminho: choices[0].message.content (que é um JSON ou texto JSON)
        String receitasJson = root.path("choices").get(0).path("message").path("content").asText();

        // Tenta extrair somente o trecho que é o array JSON (entre [ e ])
        String receitasArray = receitasJson.trim();

        // Remove markdown ou crases no início/fim
        if (receitasArray.startsWith("```json")) receitasArray = receitasArray.substring(7);
        if (receitasArray.startsWith("```")) receitasArray = receitasArray.substring(3);
        receitasArray = receitasArray.trim();

        // Pega apenas o JSON array
        int firstBracket = receitasArray.indexOf('[');
        int lastBracket = receitasArray.lastIndexOf(']');
        if (firstBracket != -1 && lastBracket != -1) {
            receitasArray = receitasArray.substring(firstBracket, lastBracket + 1);
        }
            System.out.println("==== Receita retornada da IA ====");
            System.out.println(receitasJson);
        // Agora parse normalmente:
        List<ReceitaGerada> receitas = Arrays.asList(
            mapper.readValue(receitasArray, ReceitaGerada[].class)
        );

        return receitas;
    }

    private String montarPrompt(com.gqs.nutrifacil.dto.ReceitaIARequest req) {
        List<String> preferencias = new ArrayList<>();
        preferencias.addAll(Optional.ofNullable(req.getPreferenciasProteinas()).orElse(List.of()));
        preferencias.addAll(Optional.ofNullable(req.getPreferenciasLegumes()).orElse(List.of()));
        preferencias.addAll(Optional.ofNullable(req.getPreferenciasVerduras()).orElse(List.of()));
        preferencias.addAll(Optional.ofNullable(req.getPreferenciasCarboidratos()).orElse(List.of()));

        String alergias = (req.getAlergiasIntolerancias() == null || req.getAlergiasIntolerancias().isEmpty() || req.getAlergiasIntolerancias().contains("Nenhuma"))
                ? "Nenhuma"
                : String.join(", ", req.getAlergiasIntolerancias());

        return String.format(
            "Gere 3 receitas simples de almoço para uma dieta \"%s\". Use apenas ingredientes das preferências do usuário: %s. Não use ingredientes das alergias/intolerâncias: %s. " +
            "Responda apenas em JSON, com a estrutura: [{\"nome\": \"...\", \"ingredientes\": [\"...\", \"...\"], \"modoPreparo\": \"...\"}]",
            req.getTipoDieta(), String.join(", ", preferencias), alergias
        );
    }

    private String chamarPerplexity(String prompt) {
    String apiUrl = "https://api.perplexity.ai/chat/completions";
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(perplexityKey); // Lê do application.properties

    Map<String, Object> message = Map.of("role", "user", "content", prompt);

    Map<String, Object> body = Map.of(
            "model", "sonar-pro", // Você pode usar outros modelos, veja docs
            "messages", List.of(message)
    );

    HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

    ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
    return response.getBody();
}

}