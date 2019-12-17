package br.com.pedrohsantos.pokemonbattle.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String gender;
    private Pokemon pokemon;

    public User(String name, String gender, Pokemon pokemon){
        this.name = name;
        this.gender = gender;
        this.pokemon = pokemon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getGender() {
        return gender;
    }
}
