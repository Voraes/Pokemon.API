package com.example.pokemonapi.service;

import com.example.pokemonapi.dto.PokemonDto;
import com.example.pokemonapi.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonResponse getAllPokemons(int pageNo, int pageSize);

    PokemonDto findPokemonById(Integer id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int id);
}
