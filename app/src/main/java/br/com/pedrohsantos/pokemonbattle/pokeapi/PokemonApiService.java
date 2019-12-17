package br.com.pedrohsantos.pokemonbattle.pokeapi;

import br.com.pedrohsantos.pokemonbattle.room.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApiService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonList();
}
