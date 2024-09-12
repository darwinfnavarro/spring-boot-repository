package com.example.CrudSQL.service;

import com.example.CrudSQL.entity.Pokemon;
import com.example.CrudSQL.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {

    private final WebClient webClient;
    private final PokemonRepository pokemonRepository;

    public PokemonService(WebClient webClient, PokemonRepository pokemonRepository) {
        this.webClient = webClient;
        this.pokemonRepository = pokemonRepository;
    }

    public Mono<Pokemon> getPokemonByName(String name) {
        return this.webClient.get()
                .uri("/{name}", name)
                .retrieve()
                .bodyToMono(Pokemon.class);
    }




}
