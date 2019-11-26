package br.com.josef.movieaddiction.views.fragments.old;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.josef.movieaddiction.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MinhaListaFragment extends Fragment {


    public MinhaListaFragment() {
        // Required empty public constructor
    }

    public static MinhaListaFragment newInstance() {
        MinhaListaFragment minhaListaFragment = new MinhaListaFragment();
        return minhaListaFragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minha_lista, container, false);
    }

}