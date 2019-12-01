package br.com.josef.movieaddiction.model.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import io.reactivex.Flowable;

@Dao
public interface FilmeNowPlayingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<FilmeNowPlaying> results);

    @Query("Delete from filmeNowPlayng")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from filmeNowPlayng limit 30")
    Flowable<List<FilmeNowPlaying>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE
}
