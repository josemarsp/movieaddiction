package br.com.josef.movieaddiction.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.adapter.ListaDeFilmesAssistidosAdapter;
import br.com.josef.movieaddiction.adapter.ListaDeFilmesNaoAssistidosAdapter;
import br.com.josef.movieaddiction.interfaces.RVOnClickFilmesAssistidos;
import br.com.josef.movieaddiction.interfaces.RVOnClickFilmesNaoAssistidos;
import br.com.josef.movieaddiction.model.FilmesAssistidosModel;
import br.com.josef.movieaddiction.model.FilmesNaoAssistidosModel;


public class ListaDeFilmesNaoAssistidosFragment extends Fragment implements RVOnClickFilmesNaoAssistidos {
    private ImageView capaDoFilme;
    private TextView tituloDoFilme;
    private TextView descricaoDoFilme;
    private TextView notaDoFilme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_filmes_nao_assistidos, container, false);

        ArrayList<FilmesNaoAssistidosModel> listaFilmesNaoAssistidos = new ArrayList<>();
        listaFilmesNaoAssistidos.add(new FilmesNaoAssistidosModel(R.drawable.hobbit, "10", "Hobbit", "Filme Muito Legal"));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_filmes_nao_assistidos_id);
        ListaDeFilmesNaoAssistidosAdapter listaDeFilmesNaoAssistidosAdapter = new ListaDeFilmesNaoAssistidosAdapter(this, listaFilmesNaoAssistidos);
        recyclerView.setAdapter(listaDeFilmesNaoAssistidosAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return view;
    }

    @Override
    public void onClickFilmesNaoAssistidos(FilmesNaoAssistidosModel filmesNaoAssistidosModel) {
        Log.d("nao_assistido", "Clicou");
    }
}