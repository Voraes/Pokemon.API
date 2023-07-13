package com.example.pokemonapi.controllers;

import com.example.pokemonapi.dto.PokemonDto;
import com.example.pokemonapi.dto.PokemonResponse;
import com.example.pokemonapi.dto.ReviewDto;
import com.example.pokemonapi.service.PokemonService;
import com.example.pokemonapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    private final PokemonService pokemonService;
    private final ReviewService reviewService;

    @Autowired
    public PokemonController(PokemonService pokemonService, ReviewService reviewService) {
        this.pokemonService = pokemonService;
        this.reviewService = reviewService;
    }


    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getPokemons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(pokemonService.getAllPokemons(pageNo, pageSize));
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDto> pokemonDetail(@PathVariable("id") int id) {
        //return new ResponseEntity<>(pokemonService.findPokemonById(id), HttpStatus.OK);
        return ResponseEntity.ok(pokemonService.findPokemonById(id));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto, @PathVariable("id") int pokemonId) {
        return ResponseEntity.ok(pokemonService.updatePokemon(pokemonDto, pokemonId));
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.ok("Pokemon Deleted");
    }

    //Review Methods
    @PostMapping("review/create")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewService.createReview(reviewDto));
    }
}
