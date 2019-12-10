package br.com.josef.movieaddiction.views.fragments.old;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.views.adapter.old.AdapterCategoriaRetorno;
import br.com.josef.movieaddiction.model.pojos.old.CategoriasListas;
import br.com.josef.movieaddiction.model.pojos.old.FilmesModel;
import br.com.josef.movieaddiction.views.fragments.ResultadoFilmeFragment;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickFilmes;

import static br.com.josef.movieaddiction.views.fragments.old.CategoriasFragment.CATEGORIA_KEY;
import static br.com.josef.movieaddiction.views.fragments.old.PesquisaFilmesFragment.FILME_KEY;

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
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }
}