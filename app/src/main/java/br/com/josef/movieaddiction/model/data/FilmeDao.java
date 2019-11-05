package br.com.josef.movieaddiction.model.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import io.reactivex.Flowable;

@Dao
public interface FilmeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Filme> results);

    @Query("Delete from filme")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from filme limit 30")
    Flowable<List<Filme>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE




/* Codigo Ariel
    @GET("movie/now_playing")
    Observable<FilmeNowPlayingResult> getAllNowPlaying(@Query("apinowplaying_key") String apimovieKey);

    @GET("search/movie")
    Observable<SearchResult> getAllSearch (@Query("apisearch_key")String apisearchKey);

    @GET("movie/{movie_id}/videos")
    Observable<TrailerResult> getAllTrailers(@Query("apitrailer_key") String apitrailerKey);

    @GET( "movie/{movie_id}")
    Observable<Filme> getAllFilmes (@Query("apimovie_key") String apimovieKey);
    */
}
