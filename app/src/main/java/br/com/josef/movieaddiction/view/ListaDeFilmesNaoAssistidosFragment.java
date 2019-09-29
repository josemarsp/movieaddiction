package br.com.josef.movieaddiction.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.Adapter.ListaDeFilmesNaoAssistidosAdapter;
import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.FilmesNaoAssistidosModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeFilmesNaoAssistidosFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListaDeFilmesNaoAssistidosAdapter adapter;
    private List<FilmesNaoAssistidosModel> listaFilmes = new ArrayList<>();


    public ListaDeFilmesNaoAssistidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_lista_de_filmes_nao_assistidos, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_fragment_filmes_nao_assistidos_id);
        adapter = new ListaDeFilmesNaoAssistidosAdapter(retornarListaDeFilmesNaoAssistidos());

        recyclerView.setAdapter(adapter);

//    todo: pq nao deixar o this?
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        return view;
    }

    public List<FilmesNaoAssistidosModel> retornarListaDeFilmesNaoAssistidos(){
        return listaFilmes;
    }

}
