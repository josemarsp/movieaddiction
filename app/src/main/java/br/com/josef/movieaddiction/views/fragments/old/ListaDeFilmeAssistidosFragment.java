package br.com.josef.movieaddiction.views.fragments.old;

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
import br.com.josef.movieaddiction.views.adapter.old.ListaDeFilmesAssistidosAdapter;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickFilmesAssistidos;
import br.com.josef.movieaddiction.model.pojos.old.FilmesAssistidosModel;

public class ListaDeFilmeAssistidosFragment extends Fragment implements RVOnClickFilmesAssistidos {

    private ImageView capaDoFilme;
    private TextView tituloDoFilme;
    private TextView descricaoDoFilme;
    private TextView notaDoFilme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_filmes_assistidos, container, false);

        ArrayList<FilmesAssistidosModel> listaDeFilmesAssistidos = new ArrayList<>();
        listaDeFilmesAssistidos.add(new FilmesAssistidosModel(R.drawable.hobbit, "10", "Hobbit", "Filme Muito Legal"));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_filmes_assistidos_id);
        ListaDeFilmesAssistidosAdapter listaDeFilmesAssistidosAdapter = new ListaDeFilmesAssistidosAdapter(this, listaDeFilmesAssistidos);
        recyclerView.setAdapter(listaDeFilmesAssistidosAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return view;
    }

    @Override
    public void onClickFilmesAssistidos(FilmesAssistidosModel filmesAssistidosModel) {
        Log.d("filme_assistido", "clicou");
    }
}