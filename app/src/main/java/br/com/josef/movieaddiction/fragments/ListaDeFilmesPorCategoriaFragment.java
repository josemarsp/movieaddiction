package br.com.josef.movieaddiction.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.josef.movieaddiction.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeFilmesPorCategoriaFragment extends Fragment {


    public ListaDeFilmesPorCategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retorno_da_categoria, container, false);
    }

}