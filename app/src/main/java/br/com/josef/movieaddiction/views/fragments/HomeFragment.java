package br.com.josef.movieaddiction.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.vielmodel.FilmeViewModel;
import br.com.josef.movieaddiction.views.adapter.RecyclerViewFilmeAdapter;
import br.com.josef.movieaddiction.views.interfaces.OnClickFilmePlayingNow;

import static br.com.josef.movieaddiction.views.fragments.ResultadoFilmeFragment.LINGUA_PAIS_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnClickFilmePlayingNow {
    private RecyclerView recyclerView;
    private RecyclerViewFilmeAdapter adapter;
    private List<FilmeNowPlaying> filmeNowPlayingList = new ArrayList<>();
    private FilmeViewModel viewModel;
    private ProgressBar progressBar;
    private int pagina = 1;
    public static final String API_KEY = "140f376accaf2e163abf3cd16ef3f0b4";
    public static final String MOVIE_ID_KEY = "movieIdKey";
    public static final String BANNER_ID_KEY = "bannerIdKey";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        setScrollView();

        viewModel.getFilmesEmCartaz(API_KEY, LINGUA_PAIS_KEY, pagina);

        viewModel.getListaFilme().observe(this, resultadoLista -> {
            adapter.atualizaLista(resultadoLista);
        });
        
        viewModel.getLoading().observe(this, (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        return view;

    }

    @Override

    public void click(FilmeNowPlaying filmeNowPlaying) {

        Bundle bundle = new Bundle();
        bundle.putString(MOVIE_ID_KEY, String.valueOf(filmeNowPlaying.getId()));
        bundle.putString(BANNER_ID_KEY, filmeNowPlaying.getBackdropPath());
        // bundle.putParcelable(FILME_KEY, filmeNowPlaying);
        Fragment resultadoFilmeFragment = new ResultadoFilmeFragment();
        resultadoFilmeFragment.setArguments(bundle);
        replaceFragment(resultadoFilmeFragment);

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }


    private void initViews(View view) {
        adapter = new RecyclerViewFilmeAdapter(filmeNowPlayingList, this);
        recyclerView = view.findViewById(R.id.recyclerview_filmes);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        progressBar = view.findViewById(R.id.progressBar);

    }

    private void setScrollView() {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();

                int totalItemCount = layoutManager.getItemCount();

                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean ultimoItem = lastVisible + 8 >= totalItemCount;

                if (totalItemCount > 0 && ultimoItem) {
                    pagina++;
                    viewModel.getAllFilmesNowPlaying(API_KEY, LINGUA_PAIS_KEY, pagina);
                }
            }
        });

    }


}
