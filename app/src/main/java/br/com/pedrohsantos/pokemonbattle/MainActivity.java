package br.com.pedrohsantos.pokemonbattle;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.pedrohsantos.pokemonbattle.room.Pokemon;
import br.com.pedrohsantos.pokemonbattle.room.PokemonResponse;
import br.com.pedrohsantos.pokemonbattle.pokeapi.PokemonApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKE_BATTLE";

    private Retrofit retrofit;

    private PokemonListAdapter pokemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        pokemonListAdapter = new PokemonListAdapter(this);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getData();
    }

    private void getData(){
        final PokemonApiService pokemonApiService = retrofit.create(PokemonApiService.class);
        Call<PokemonResponse> pokemonResponseCall = pokemonApiService.getPokemonList();

        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if(response.isSuccessful()){
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemons = pokemonResponse.getResults();

                    pokemonListAdapter.addPokemonList(pokemons);

                    //                    for(int i = 0; i < pokemons.size(); i++){
//                        Pokemon pokemon = pokemons.get(1);
//                        Log.i(TAG, " Pokemon: " + pokemon.getName());
//                    }
                }else{
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}
