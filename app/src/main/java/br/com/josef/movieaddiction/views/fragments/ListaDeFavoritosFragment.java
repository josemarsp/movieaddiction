package br.com.josef.movieaddiction.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.vielmodel.FavoritoViewModel;
import br.com.josef.movieaddiction.views.adapter.RecyclerViewFavoritosAdapter;
import br.com.josef.movieaddiction.views.interfaces.OnClickFavoritos;

import static br.com.josef.movieaddiction.views.fragments.HomeFragment.MOVIE_ID_KEY;

public class ListaDeFavoritosFragment extends Fragment implements OnClickFavoritos {

    private ImageView iconeLixeira;
    public static final String TOTAL_KEY = "total_key";
    private RecyclerViewFavoritosAdapter adapter;
    private RecyclerView recyclerView;
    private FavoritoViewModel viewModel;
    private List<Filme> listaDeFavoritos = new ArrayList<>();
    private int totalLista;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_favoritos, container, false);

        initView(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        viewModel.buscaFavoritos();

        viewModel.getListaFilme().observe(this, filmes -> {
            adapter.atualizaLista(filmes);

        });

        return view;
    }


    public void initView(View view) {
        adapter = new RecyclerViewFavoritosAdapter(this, listaDeFavoritos);
        recyclerView = view.findViewById(R.id.recyclerView_fragment_favoritos_id);
        viewModel = ViewModelProviders.of(this).get(FavoritoViewModel.class);
        iconeLixeira = view.findViewById(R.id.iconeLixeira);
    }


    @Override
    public void onClickFavoritos(Filme filme) {
        Bundle bundle = new Bundle();
        bundle.putString(MOVIE_ID_KEY, String.valueOf(filme.getId()));
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


    @Override
    public void removeClickFavoritos(Filme filme) {
        viewModel.deletaFilme(filme);
        Toast.makeText(getContext(), "Filme excluído", Toast.LENGTH_SHORT).show();


        FragmentTransaction tr = getFragmentManager().beginTransaction();
        ListaDeFavoritosFragment frag = new ListaDeFavoritosFragment();

        tr.replace(R.id.containerPrincipal, frag);
        tr.commit();


    }




}
