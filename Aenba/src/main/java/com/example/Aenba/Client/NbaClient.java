package com.example.Aenba.Client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class NbaClient {

    private final WebClient webClient;

    public NbaClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String fetchCommonAllPlayers() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/commonallplayers")
                        .queryParam("IsOnlyCurrentSeason", "1")
                        .queryParam("LeagueID", "00")
                        .queryParam("Season", "2025-26")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block(); // .block() é ok para testes iniciais, depois mudamos para reativo
    }

}
