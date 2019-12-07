package br.com.josef.movieaddiction.vielmodel;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.josef.movieaddiction.model.data.DatabaseFilmeNowPlaying;
import br.com.josef.movieaddiction.model.data.FilmeNowPlayingDao;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlayingResult;
import br.com.josef.movieaddiction.repository.FilmeIdRepository;
import br.com.josef.movieaddiction.repository.FilmeNowPlayingRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.josef.movieaddiction.util.AppUtil.isNetworkConnected;

public class FilmeViewModel extends AndroidViewModel {
    private MutableLiveData<List<FilmeNowPlaying>> listaFilme = new MutableLiveData<>();
    private MutableLiveData<Filme> filme = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeNowPlayingRepository repository = new FilmeNowPlayingRepository();
    private FilmeIdRepository idRepository = new FilmeIdRepository();

    public FilmeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<FilmeNowPlaying>> getListaFilme() {
        return this.listaFilme;
    }

    public LiveData<Filme> getFilme() {
        return this.filme;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public void getFilmesEmCartaz(String apiKey,String linguaPais, int pagina) {
        if (isNetworkConnected(getApplication())) {
            getAllFilmesNowPlaying(apiKey, linguaPais, pagina);
        } else {
            getFromLocal();
        }

    }


    public void getAllFilmesNowPlaying(String apiKey, String linguaPais, int pagina) {
        disposable.add(
                repository.getFilmeNowPlaying(apiKey, linguaPais,pagina)
                        .subscribeOn(Schedulers.io())
                        .map(this::saveItems)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(filmeResult -> {
                            listaFilme.setValue(filmeResult.getResults());
                        }, throwable -> {
                            Log.i("LOG", "get From Network erro  " + throwable.getMessage());
                        })
        );

    }

    private FilmeNowPlayingResult saveItems(FilmeNowPlayingResult filmeNowPlayingResult) {
        FilmeNowPlayingDao dao = DatabaseFilmeNowPlaying
                .getDatabase(getApplication()
                .getApplicationContext())
                .filmeNowPlayingDao();
        dao.deleteAll();
        dao.insert(filmeNowPlayingResult.getResults());
        return filmeNowPlayingResult;
    }

    public void getFilmeId(int movie_id, String apiKey, String linguaPais) {
        disposable.add(
                idRepository.getFilmeId(movie_id, apiKey, linguaPais)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(filme1 -> {
                            filme.setValue(filme1);
                        }, throwable -> {
                            Log.i("LOG", "erro " + throwable.getMessage());
                        })
        );
    }


    private void getFromLocal() {
        disposable.add(
                repository.getLocalResults(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(results ->{
                            listaFilme.setValue(results);
                        }, throwable ->{
                            Log.i("LOG", "erro buscando OffLine "+ throwable.getMessage());
                        })
        );

                        }

        @Override
        protected void onCleared () {
            super.onCleared();
            disposable.clear();
        }
    }
