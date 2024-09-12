package com.example.CrudSQL.controller;

import com.example.CrudSQL.entity.Pokemon;
import com.example.CrudSQL.service.PokemonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemon")


public class PokemonController {

    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public Mono<Pokemon> getPokemon(@PathVariable String name){

        return pokemonService.getPokemonByName(name);
    }



}
