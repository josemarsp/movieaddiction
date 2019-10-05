package br.com.josef.movieaddiction.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.FilmesModel;

import static br.com.josef.movieaddiction.fragment.PesquisaFilmesFragment.FILME_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFilmeFragment extends Fragment {
    private ImageView imagemFilme;
    private TextView nomeFilme;


    public ResultadoFilmeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_filme, container, false);

        initViews(view);

        if (!getArguments().isEmpty()){

            FilmesModel filmes = getArguments().getParcelable(FILME_KEY);

            if (filmes != null) {
                Drawable drawable = getResources().getDrawable(filmes.getImagem());

                imagemFilme.setImageDrawable(drawable);
                nomeFilme.setText(filmes.getNome());
            }
        }

        return view;


    }

    public void initViews(View view){
        imagemFilme = view.findViewById(R.id.imagemFilme);
        nomeFilme = view.findViewById(R.id.nomeFilme);

    }


    }
