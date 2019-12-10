package br.com.josef.movieaddiction.repository;

import br.com.josef.movieaddiction.model.data.remote.SearchRetrofitService;
import br.com.josef.movieaddiction.model.pojos.searchmovies.SearchResult;
import io.reactivex.Observable;

public class SearchRepository {

    public Observable<SearchResult> getSearchResult(String apiKey, String linguaPais, String queryText) {
        return SearchRetrofitService.getSearch().getSearchResult(apiKey, linguaPais, queryText);

    }
}
