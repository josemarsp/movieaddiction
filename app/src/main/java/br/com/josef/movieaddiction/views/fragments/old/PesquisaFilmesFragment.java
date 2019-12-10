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
import br.com.josef.movieaddiction.model.pojos.old.FilmesModel;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickFilmes;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisaFilmesFragment extends Fragment implements RVOnClickFilmes {
    private RecyclerView recyclerView;
   // private FilmesAdapter adapter;
    private List<FilmesModel> filmesList = new ArrayList<>();
    public static final String FILME_KEY = "filme";

    public PesquisaFilmesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pesquisa_filmes, container, false);

        initViews (view);

      //  adapter = new FilmesAdapter(recebeListaFilmes(), this);

     //   recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    private List<FilmesModel> recebeListaFilmes(){
        filmesList.add(new FilmesModel(R.drawable.hobbit, "O Hobbit"));

        return filmesList;
    }

    public void initViews(View view){
        recyclerView = view.findViewById(R.id.listaFilmesRecyclerView);
    }

    @Override
    public void onClick(FilmesModel filmes) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, getParentFragment());
        transaction.commit();

    }
}
