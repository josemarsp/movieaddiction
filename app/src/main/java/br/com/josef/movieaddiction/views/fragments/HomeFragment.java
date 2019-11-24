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

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.vielmodel.FilmeNowPlayingViewModel;
import br.com.josef.movieaddiction.views.adapter.RecyclerViewFilmeAdapter;
import br.com.josef.movieaddiction.views.interfaces.OnClick;

import static br.com.josef.movieaddiction.views.fragments.PesquisaFilmesFragment.FILME_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnClick {
    private RecyclerView recyclerView;
    private RecyclerViewFilmeAdapter adapter;
    private List<FilmeNowPlaying> filmeNowPlayingList = new ArrayList<>();
    private FilmeNowPlayingViewModel viewModel;
    private ProgressBar progressBar;
    private int pagina = 1;
    public static final String API_KEY = "bde8033d3274c91b292a5293c6349052";


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

        viewModel.getAllFilmes(API_KEY, pagina);
        viewModel.getListaFilme().observe(this, resultadoLista -> {
            adapter.atualizaLista(resultadoLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                Snackbar
                        .make(view, "Check your internet connection", Snackbar.LENGTH_LONG)
                        .show();
                
                progressBar.setVisibility(View.GONE);
            }
        });


        return view;

    }

    @Override

    public void click(FilmeNowPlaying filmeNowPlaying) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(FILME_KEY, filmeNowPlaying);
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
        viewModel = ViewModelProviders.of(this).get(FilmeNowPlayingViewModel.class);
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
                    viewModel.getAllFilmes(API_KEY, pagina);
                }
            }
        });

    }

//    old code//

    //    public static HomeFragment newInstance() {
//        HomeFragment homeFragment = new HomeFragment();
//        return homeFragment;
//    }


//    view.findViewById(R.id.imageView_hobbit_id).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            FilmesModel model = new FilmesModel(
//                    R.drawable.hobbit,
//                    "O Hobbit",
//                    "Teste",
//                    "todo",
//                    "todo",
//                    "2019",
//                    "5 minutos",
//                    "50 anos",
//                    "infantil",
//                    "https://www.youtube.com/watch?v=nOGsB9dORBg&t=47s"
//            );
//
//            Bundle bundle = new Bundle();
//            bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, model);
//            ResultadoFilmeFragment fragment = new ResultadoFilmeFragment();
//            fragment.setArguments(bundle);
//
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            FragmentTransaction t = fragmentManager.beginTransaction();
//            t.replace(R.id.conainter_principal_id, fragment);
//            t.commit();
//        }
//    });


}
