package br.com.josef.movieaddiction.views.fragments.old;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.views.adapter.old.AdapterCategoria;
import br.com.josef.movieaddiction.model.pojos.old.CategoriasListas;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickCategorias;


public class CategoriasFragment extends Fragment implements RVOnClickCategorias {
    private RecyclerView recyclerViewCategorias;
    private AdapterCategoria adapterCat;
    public static final String CATEGORIA_KEY = "categoria";


    public static Fragment newInstance() {
        CategoriasFragment categoriasFragment = new CategoriasFragment();
        return categoriasFragment;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater. inflate(R.layout.fragment_recycler_view_categorias, container, false);

        recyclerViewCategorias = view.findViewById(R.id.lista_categorias);

        adapterCat = new AdapterCategoria(categorias(), this);

        recyclerViewCategorias.setAdapter(adapterCat);


        // setar o activite contendo o conteiner para abrir a lista
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(getContext()));



                return view;

    }

    public List<CategoriasListas> categorias(){
        List<CategoriasListas> categoriasListasList = new ArrayList<>();

        categoriasListasList.add(new CategoriasListas("Aventura"));
        categoriasListasList.add(new CategoriasListas("Animação"));
        categoriasListasList.add(new CategoriasListas("Drama"));
        categoriasListasList.add(new CategoriasListas("Romance"));
        categoriasListasList.add(new CategoriasListas("Comédia"));
        categoriasListasList.add(new CategoriasListas("Ação"));
        categoriasListasList.add(new CategoriasListas("Comédia Dramatica"));
        categoriasListasList.add(new CategoriasListas("Comédia Romantica"));
        categoriasListasList.add(new CategoriasListas("Dança"));
        categoriasListasList.add(new CategoriasListas("Musical"));
        categoriasListasList.add(new CategoriasListas("Filme Polícial"));
        categoriasListasList.add(new CategoriasListas("Espionagem"));

        return categoriasListasList;

    }


    @Override
    public void onClick(CategoriasListas categoriasListas) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CATEGORIA_KEY, categoriasListas);

        Fragment envioFragment = new ListaDeFilmesPorCategoriaFragment();
        envioFragment.setArguments(bundle);
        replaceFragment(envioFragment);
    }

    public void replaceFragment (Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }

    private class ResultadoCategoriaFragment extends Fragment {
    }
}

