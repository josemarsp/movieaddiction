package br.com.josef.movieaddiction.model.data.remote;


import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlayingResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeNowPlayingAPI {

    @GET("movie/now_playing")
    Observable<FilmeNowPlayingResult> getAllFilmes(@Query("api_key") String apiKEY,
                                                  @Query("page") int pagina);
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
