package br.com.josef.movieaddiction.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.FilmesModel;
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.views.activity.GeralProVideoActivity;

import static br.com.josef.movieaddiction.views.fragments.PesquisaFilmesFragment.FILME_KEY;

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

        if (getArguments() != null){


            FilmeNowPlaying filmeNowPlaying = getArguments().getParcelable(FILME_KEY);
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filmeNowPlaying.getBackdropPath()).into(imagemFilme);
            nomeFilme.setText(filmeNowPlaying.getTitle());
            sinopseDoFilme.setText(filmeNowPlaying.getOverview());
            
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
                t.replace(R.id.containerPrincipal, fragment);
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
                t.replace(R.id.containerPrincipal, fragment);
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

        iconeFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
                Fragment fragment = new ListaDeFavoritosFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = ResultadoFilmeFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.replace(R.id.containerPrincipal, fragment);
                t.commit();

            }
        });
    }

    public void initViews(View view){
        imagemFilme = view.findViewById(R.id.imagemFilmeDetalhe);
        nomeFilme = view.findViewById(R.id.nomeDetalheFilme_id);
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
