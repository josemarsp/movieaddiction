package br.com.josef.movieaddiction.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.josef.movieaddiction.R;


public class ListaDeFilmesNaoAssistidosFragment extends Fragment {
    private ImageView capaDoFilme;
    private TextView tituloDoFilme;
    private TextView descricaoDoFilme;
    private TextView notaDoFilme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_filmes_nao_assistidos, container, false);
        return view;
    }

}