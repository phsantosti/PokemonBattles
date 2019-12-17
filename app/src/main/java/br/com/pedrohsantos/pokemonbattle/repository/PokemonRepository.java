package br.com.pedrohsantos.pokemonbattle.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import br.com.pedrohsantos.pokemonbattle.room.Pokemon;
import br.com.pedrohsantos.pokemonbattle.room.PokemonDao;
import br.com.pedrohsantos.pokemonbattle.room.PokemonDatabase;

import java.util.List;

public class PokemonRepository {
    private PokemonDao pokemonDao;
    private LiveData<List<Pokemon>> allPokemons;

    public PokemonRepository(Application application){
        PokemonDatabase pokemonDatabase = PokemonDatabase.getInstance(application);
        pokemonDao = pokemonDatabase.pokemonDao();
        allPokemons = pokemonDao.readAll();
    }

    public void create(Pokemon pokemon){
        new CreatePokemonAsyncTask(pokemonDao).execute(pokemon);
    }

    public void update(Pokemon pokemon){
        new UpdatePokemonAsyncTask(pokemonDao).execute(pokemon);
    }

    public void delete(Pokemon pokemon){
        new DeleteAllPokemonAsyncTask(pokemonDao).execute();
    }

    public void deleteAllPokemons(){
        new DeleteAllPokemonAsyncTask(pokemonDao).execute();
    }

    public LiveData<List<Pokemon>> redAll(){
        return allPokemons;
    }

    private static class CreatePokemonAsyncTask extends AsyncTask<Pokemon, Void, Void>{
        private PokemonDao pokemonDao;

        private CreatePokemonAsyncTask(PokemonDao pokemonDao){
            this.pokemonDao = pokemonDao;
        }
        @Override
        protected Void doInBackground(Pokemon... pokemons) {
            pokemonDao.create(pokemons[0]);
            return null;
        }
    }

    private static class UpdatePokemonAsyncTask extends AsyncTask<Pokemon, Void, Void>{
        private PokemonDao pokemonDao;

        private UpdatePokemonAsyncTask(PokemonDao pokemonDao){
            this.pokemonDao = pokemonDao;
        }
        @Override
        protected Void doInBackground(Pokemon... pokemons) {
            pokemonDao.update(pokemons[0]);
            return null;
        }
    }

    private static class DeleteAllPokemonAsyncTask extends AsyncTask<Void, Void, Void>{
        private PokemonDao pokemonDao;

        private DeleteAllPokemonAsyncTask(PokemonDao pokemonDao){
            this.pokemonDao = pokemonDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            pokemonDao.deleteAll();
            return null;
        }
    }

//    private static class InsertPokemonAsyncTask extends AsyncTask<Pokemon, Void, Void>{
//        private PokemonDao pokemonDao;
//
//        private InsertPokemonAsyncTask(PokemonDao pokemonDao){
//            this.pokemonDao = pokemonDao;
//        }
//        @Override
//        protected Void doInBackground(Pokemon... pokemons) {
//            pokemonDao.create(pokemons[0]);
//            return null;
//        }
//    }
}
