package br.com.josef.movieaddiction.model.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

public interface SpokenLanguage {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<SpokenLanguage> results);

    @Query("Delete from spokenLanguage")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from spokenLanguage limit 30")
    Flowable<List<SpokenLanguage>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE


}
