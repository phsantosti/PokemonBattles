package br.com.pedrohsantos.pokemonbattle.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon_table")
public class Pokemon {
    @PrimaryKey
    private int id;
    private String name;
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        String[] urlParts = this.url.split("/");
        return Integer.parseInt(urlParts[urlParts.length - 1]);
    }

    public void setId(int id) {
        this.id = id;
    }
}
