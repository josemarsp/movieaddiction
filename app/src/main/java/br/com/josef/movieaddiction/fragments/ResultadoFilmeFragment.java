package br.com.josef.movieaddiction.fragments;


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

import static br.com.josef.movieaddiction.fragments.PesquisaFilmesFragment.FILME_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFilmeFragment extends Fragment {
    private ImageView imagemFilme;
    private TextView nomeFilme;
    private TextView sinopseDoFilme;
    private TextView elencoDoFilme;
    private TextView notaDoFilme;
    private TextView anoDeLancamento;
    private TextView tempoDeDuracao;
    private TextView idadeRecomendada;
    private TextView categoriaDoFilme;
//todos esses atributos acima serao retornados atraves da API e exibidos nesse fragmento
//esse atributos de baixo nao retornam da API esses a gente tem que fazer a logica especifica
    private ImageView iconeNaoAssitido;
    private ImageView iconeJaAssistido;
    private ImageView iconeTrailler;
    private ImageView iconeFavorito;
    private ImageView iconeCompartilhar;

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
        nomeFilme = view.findViewById(R.id.nomeFilme_id);
        sinopseDoFilme = view.findViewById(R.id.textview_descricao_da_sinopse_id);
        elencoDoFilme = view.findViewById(R.id.textview_descricao_do_elenco_id);
        notaDoFilme = view.findViewById(R.id.notaFilme_id);
        anoDeLancamento = view.findViewById(R.id.textAno_id);
        tempoDeDuracao = view.findViewById(R.id.textDuracao_id);
        idadeRecomendada = view.findViewById(R.id.textCensura_id);
        categoriaDoFilme = view.findViewById(R.id.textGenero_id);
        iconeNaoAssitido = view.findViewById(R.id.icon_naoassitido_id);
        iconeJaAssistido = view.findViewById(R.id.icon_jaassistido_id);
        iconeTrailler = view.findViewById(R.id.icon_trailer_id);
        iconeFavorito = view.findViewById(R.id.icon_favorito_id);
        iconeCompartilhar = view.findViewById(R.id.icon_favorito_id);
    }


    }
