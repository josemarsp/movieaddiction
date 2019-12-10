package br.com.josef.movieaddiction.repository;

import android.content.Context;

import java.util.List;

import br.com.josef.movieaddiction.model.data.DatabaseFilme;
import br.com.josef.movieaddiction.model.data.FilmeDao;
import br.com.josef.movieaddiction.model.data.remote.SearchRetrofitService;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.model.pojos.searchmovies.SearchResult;
import io.reactivex.Flowable;
import io.reactivex.Observable;

import static br.com.josef.movieaddiction.model.data.remote.FilmeIdRetrofitService.getApiService;

public class FilmeIdRepository {

    public Observable<Filme> getFilmeId(int movie_id, String apiKey, String linguaPais) {
        return getApiService().getFilm(movie_id, apiKey, linguaPais);
    }



    // Pega os dados do banco de dados local
    public Flowable<List<Filme>> getLocalResults(Context context) {
        DatabaseFilme room = DatabaseFilme.getDatabase(context);
        FilmeDao filmeDao = room.filmeDao();
        return filmeDao.getAll();
    }


}
