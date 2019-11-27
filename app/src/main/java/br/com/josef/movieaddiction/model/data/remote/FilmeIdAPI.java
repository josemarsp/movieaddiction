package br.com.josef.movieaddiction.model.data.remote;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmeIdAPI {

    @GET("movie/{movie_id}")
    Observable<Filme> getFilm(@Path("movie_id") int movieId,
                                @Query("api_key") String apiKey);


    // @Path("language") String lingua);

    //? Query
    //& Path
    //

//    @GET ("/movie/{movie_id}/translations")
//    FilmNowPlaying getId(
//         @Query("api_key") String apiKey
//         @Query()
//    )
}
