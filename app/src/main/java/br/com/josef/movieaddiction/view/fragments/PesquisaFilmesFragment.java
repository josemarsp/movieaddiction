package br.com.josef.movieaddiction.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.josef.movieaddiction.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisaFilmesFragment extends Fragment {


    public PesquisaFilmesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesquisa_filmes, container, false);
    }

}
