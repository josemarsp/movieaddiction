package br.com.josef.movieaddiction.fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.adapter.AdapterCategoriaRetorno;
import br.com.josef.movieaddiction.adapter.FilmesAdapter;
import br.com.josef.movieaddiction.interfaces.RVOnClickFilmes;
import br.com.josef.movieaddiction.model.AtoresModel;
import br.com.josef.movieaddiction.model.CategoriasListas;
import br.com.josef.movieaddiction.model.FilmesModel;

import static br.com.josef.movieaddiction.fragments.CategoriasFragment.CATEGORIA_KEY;
import static br.com.josef.movieaddiction.fragments.CategoriasFragment.newInstance;
import static br.com.josef.movieaddiction.fragments.PesquisaAtoresFragment.ATOR_KEY;
import static br.com.josef.movieaddiction.fragments.PesquisaFilmesFragment.FILME_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeFilmesPorCategoriaFragment extends Fragment implements RVOnClickFilmes {
    private TextView nomeCategoria;
    private RecyclerView recyclerView;
    private AdapterCategoriaRetorno adpter;



    public ListaDeFilmesPorCategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retorno_da_categoria, container, false);


        initViews(view);

        adpter= new AdapterCategoriaRetorno(listaDeFilmes(),this);

        recyclerView.setAdapter(adpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null){

            CategoriasListas categoria  = getArguments().getParcelable(CATEGORIA_KEY);

            if (categoria != null){

                nomeCategoria.setText(categoria.getTexTCategoria());
            }

        }

        return view;
    }

    public List<FilmesModel> listaDeFilmes() {
        List<FilmesModel> filmesModelArrayList = new ArrayList<>();

      filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
      filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.avatar,"Avatar","No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos.","9,5"));
        filmesModelArrayList.add(new FilmesModel(R.drawable.cartazhobbit,"O Hobbit","O Hobbit é uma série de três filmes de fantasia épica e de aventura dirigido, coescrito e produzido por Peter Jackson e baseado no livro The Hobbit ","8,9"));




      return filmesModelArrayList;
    }




    public void initViews(View view){

        nomeCategoria = view.findViewById(R.id.nomeRetornoCategoria);
        recyclerView = view.findViewById(R.id.retornoCategoriaLista);

    }

    @Override
    public void onClick(FilmesModel filmes) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(FILME_KEY, filmes);

        Fragment envioFragment = new ResultadoFilmeFragment();
        envioFragment.setArguments(bundle);
        replaceFragment(envioFragment);
    }

    public void replaceFragment (Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.conainter_principal_id, fragment);
        transaction.commit();
    }
}