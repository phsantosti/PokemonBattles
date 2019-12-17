package br.com.pedrohsantos.pokemonbattle.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface PokemonDao {
    @Insert
    void create(Pokemon pokemon);
    @Update
    void update(Pokemon pokemon);
    @Delete
    void delete(Pokemon pokemon);

    @Query("DELETE FROM pokemon_table")
    void deleteAll();

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    LiveData<List<Pokemon>> readAll();
}
