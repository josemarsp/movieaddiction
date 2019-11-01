package br.com.josef.movieaddiction.model.data;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.FilmesModel;
import io.reactivex.Observable;

@Dao
public interface FilmeDao {

    @Insert
    void insert (FilmesModel filmesModel);

//    @Query("SELECT * FROM  filmesModel")
//    Observable<List<FilmesModel>> todosOsFilmes();

}
