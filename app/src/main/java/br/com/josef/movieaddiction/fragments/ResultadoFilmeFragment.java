package br.com.josef.movieaddiction.fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.FilmesModel;
import br.com.josef.movieaddiction.views.GeralProVideoActivity;

import static br.com.josef.movieaddiction.fragments.PesquisaFilmesFragment.FILME_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFilmeFragment extends Fragment {
    private FilmesModel filme;

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
        initIcons();

        if (!getArguments().isEmpty()){

            filme = getArguments().getParcelable(FILME_KEY);

            if (filme != null) {
                Drawable drawable = getResources().getDrawable(filme.getImagem());

                imagemFilme.setImageDrawable(drawable);
                nomeFilme.setText(filme.getNome());
            }
        }

        return view;


    }

    private void initIcons() {
        iconeJaAssistido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
                Fragment fragment = new ListaDeFilmeAssistidosFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.replace(R.id.conainter_principal_id, fragment);
                t.addToBackStack(null);
                t.commit();
            }
        });

        iconeNaoAssitido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
                Fragment fragment = new ListaDeFilmesNaoAssistidosFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.replace(R.id.conainter_principal_id, fragment);
                t.addToBackStack(null);
                t.commit();
            }
        });

        iconeTrailler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),GeralProVideoActivity.class);
                intent.putExtra(FILME_KEY, filme);
                startActivity(intent);
            }
        });
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
