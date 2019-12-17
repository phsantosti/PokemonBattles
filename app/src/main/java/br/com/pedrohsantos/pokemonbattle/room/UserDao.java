package br.com.pedrohsantos.pokemonbattle.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void create(User user);
    @Update
    void update(User user);
    @Delete
    void delete(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    LiveData<List<User>> readAll();
}
