package br.com.josef.movieaddiction.repository;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import io.reactivex.Observable;

import static br.com.josef.movieaddiction.model.data.remote.FilmeIdRetrofitService.getApiService;

public class FilmeIdRepository {

    public Observable<Filme> getFilmeId(int movie_id, String apiKey) {
        return getApiService().getFilm(movie_id, apiKey);
    }

}
