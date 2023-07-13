package com.example.pokemonapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PokemonDto {
    private int id;
    private String name;
    private String type;
}
