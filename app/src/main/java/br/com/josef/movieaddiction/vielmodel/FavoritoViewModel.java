package br.com.josef.movieaddiction.vielmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.josef.movieaddiction.model.data.DatabaseFilme;
import br.com.josef.movieaddiction.model.data.FilmeDao;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.repository.FilmeIdRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FavoritoViewModel extends AndroidViewModel {


    private MutableLiveData<List<Filme>> listaFilme = new MutableLiveData<>();
    private MutableLiveData<Filme> filme = new MutableLiveData<>();
    private MutableLiveData<Integer> filmeCont = new MutableLiveData<>();
    private MutableLiveData<Boolean> filmeBoolean = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeIdRepository repository = new FilmeIdRepository();
    private FilmeDao filmeDao = DatabaseFilme.getDatabase(getApplication()).filmeDao();


    public FavoritoViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Filme>> getListaFilme() {
        return this.listaFilme;
    }

    public LiveData<Filme> getFilme() {
        return this.filme;
    }


    public LiveData<Integer> getFilmeCont() {
        return this.filmeCont;
    }

    public LiveData<Boolean> getFilmeBoolean() {
        return this.filmeBoolean;
    }


    public void insereFilme(Filme filmeobj) {
        new Thread(() -> {
            if (filmeobj != null) {
                filmeDao.insert(filmeobj);
            }
        }).start();
        this.filme.setValue(filmeobj);
        filmeBoolean.setValue(true);
    }

    public void deletaFilme(Filme filme) {
        new Thread(() -> {
            if (filme != null) {
                filmeDao.deleteFavorite(filme);

            }
        }).start();
        this.filme.setValue(filme);
        filmeBoolean.setValue(false);
    }

    public void buscaFavoritos() {
        disposable.add(
                filmeDao.getAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(filmes -> {
                                    listaFilme.setValue(filmes);
                                },
                                throwable -> {
                                    Log.i("LOG", "Falha na lista de favoritos" + throwable.getMessage());

                                })
        );
    }

    public void contaFilme() {
        disposable.add(
                filmeDao.getContFilme()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(integer -> {
                            filmeCont.setValue(integer);
                        },
                                throwable -> {
                                    Log.i("LOG", "Falha Contagem Filme" + throwable.getMessage());

                                }
                        )
        );
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }


}


