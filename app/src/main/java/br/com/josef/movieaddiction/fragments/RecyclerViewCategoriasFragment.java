package br.com.josef.movieaddiction.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.adapter.AdapterCategoria;
import br.com.josef.movieaddiction.model.CategoriasListas;


public class RecyclerViewCategoriasFragment extends Fragment {
    private RecyclerView recyclerViewCategorias;
    private AdapterCategoria adapterCat;



    public RecyclerViewCategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater. inflate(R.layout.fragment_recycler_view_categorias, container, false);

        recyclerViewCategorias = view.findViewById(R.id.lista_categorias);

        adapterCat = new AdapterCategoria(categorias());

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
        categoriasListasList.add(new CategoriasListas("Terror"));

        return categoriasListasList;


    }
}
