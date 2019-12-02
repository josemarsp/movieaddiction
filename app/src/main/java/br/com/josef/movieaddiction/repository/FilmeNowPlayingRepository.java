package br.com.josef.movieaddiction.repository;


import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlayingResult;
import io.reactivex.Observable;

import static br.com.josef.movieaddiction.model.data.remote.FilmeNowPlayingRetrofitService.getApiService;


public class FilmeNowPlayingRepository {

    public Observable<FilmeNowPlayingResult> getFilmes(String apiKey, int pagina) {
        return getApiService().getAllFilmes(apiKey, pagina);
    }

}
