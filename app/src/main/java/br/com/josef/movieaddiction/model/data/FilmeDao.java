package br.com.josef.movieaddiction.model.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import io.reactivex.Flowable;

@Dao
public interface FilmeDao {

    /**
     * No método de insert temos o onConflict
     * onConflict: é um conjunto de estratégias de tratamento de conflitos, nesse caso estamos usando o REPLACE
     * ou seja o OnConflict irá substituir os dados antigos pelos novos e continuar a transação.
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Filme> filmes);

    @Insert
    void insert(Filme filme);

    @Query("Delete from filme")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 80 itens


    @Query("Select * from filme ORDER by Filme.bdId desc")
    Flowable<List<Filme>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE

    @Delete
    void deleteFavorite(Filme filme);

    @Query("SELECT COUNT(filme.bdId) FROM filme")
    Flowable<Integer> getContFilme();

//    @Query("Select filme.id from filme")
//    Boolean getFilmeNoBD(Filme filme);


}
