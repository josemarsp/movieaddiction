package br.com.josef.movieaddiction.model.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.movieid.Genre;
import io.reactivex.Flowable;

public interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Genre> results);

    @Query("Delete from genre")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from genre limit 30")
    Flowable<List<Genre>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE

}
