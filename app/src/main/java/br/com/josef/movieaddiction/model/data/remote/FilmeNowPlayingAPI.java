package br.com.josef.movieaddiction.model.data.remote;


import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlayingResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
@Query para campos chamadas nominais
@Path para campos diretos.
 */
public interface FilmeNowPlayingAPI {

    @GET("movie/now_playing")
    Observable<FilmeNowPlayingResult> getAllFilmeNowPlaying(@Query("api_key") String apiKEY,
                                                            @Query("language") String linguaPais,
                                                            @Query("page") int pagina);


}
