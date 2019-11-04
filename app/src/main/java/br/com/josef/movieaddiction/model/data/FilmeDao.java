package br.com.josef.movieaddiction.model.data;

import androidx.room.Dao;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlayingResult;
import br.com.josef.movieaddiction.model.pojos.searchmovies.SearchResult;
import br.com.josef.movieaddiction.model.pojos.trailer.TrailerResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Dao
public interface FilmeDao {

    @GET("movie/now_playing")
    Observable<FilmeNowPlayingResult> getAllNowPlaying(@Query("apinowplaying_key") String apimovieKey);

    @GET("search/movie")
    Observable<SearchResult> getAllSearch (@Query("apisearch_key")String apisearchKey);

    @GET("movie/{movie_id}/videos")
    Observable<TrailerResult> getAllTrailers(@Query("apitrailer_key") String apitrailerKey);

    @GET( "movie/{movie_id}")
    Observable<Filme> getAllFilmes (@Query("apimovie_key") String apimovieKey);
}
