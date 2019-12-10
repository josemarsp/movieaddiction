package br.com.josef.movieaddiction.vielmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.searchmovies.Search;
import br.com.josef.movieaddiction.repository.SearchRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.josef.movieaddiction.views.fragments.HomeFragment.API_KEY;
import static br.com.josef.movieaddiction.views.fragments.ResultadoFilmeFragment.LINGUA_PAIS_KEY;

public class SearchViewModel extends AndroidViewModel {

    private MutableLiveData<List<Search>> listaSearch = new MutableLiveData<>();
    private MutableLiveData<Integer> hits;
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private SearchRepository repository = new SearchRepository();


    public SearchViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Search>> getListaSearch() {
        return this.listaSearch;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public void getAllSerchResult(String queryText) {
        disposable.add(
                repository.getSearchResult(API_KEY, LINGUA_PAIS_KEY, queryText)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(searchResult -> {
                            listaSearch.setValue(searchResult.getResults());
                            hits.setValue(searchResult.getTotalResults().intValue());
                        }, throwable -> {
                            Log.i("LOG", "erro na lista Search" + throwable.getMessage());
                        })
        );
    }
    @Override
    protected void onCleared () {
        super.onCleared();
        disposable.clear();
    }

}
