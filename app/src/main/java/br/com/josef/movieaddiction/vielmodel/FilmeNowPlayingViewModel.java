package br.com.josef.movieaddiction.vielmodel;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.repository.FilmeRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FilmeNowPlayingViewModel extends AndroidViewModel {
    private MutableLiveData<List<FilmeNowPlaying>> listaFilme = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository repository = new FilmeRepository();

    public FilmeNowPlayingViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<FilmeNowPlaying>> getListaFilme() {
        return this.listaFilme;
    }

    public LiveData<Boolean> getLoading(){
        return  this.loading;
    }

    public void getAllFilmes(String apiKey, int pagina) {
        disposable.add(
                repository.getFilmes(apiKey, pagina)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(filmeResult -> {
                            listaFilme.setValue(filmeResult.getResults());
                        }, throwable -> {
                            Log.i("LOG", "erro  " + throwable.getMessage());
                        })

        );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
