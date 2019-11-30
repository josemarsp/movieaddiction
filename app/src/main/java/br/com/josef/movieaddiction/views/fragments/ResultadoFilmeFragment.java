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
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.model.pojos.movieid.Genre;
import br.com.josef.movieaddiction.vielmodel.FilmeViewModel;
import br.com.josef.movieaddiction.views.activity.GeralProVideoActivity;
import br.com.josef.movieaddiction.views.fragments.old.ListaDeFilmeAssistidosFragment;
import br.com.josef.movieaddiction.views.fragments.old.ListaDeFilmesNaoAssistidosFragment;

import static br.com.josef.movieaddiction.views.fragments.HomeFragment.API_KEY;
import static br.com.josef.movieaddiction.views.fragments.HomeFragment.MOVIE_ID_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFilmeFragment extends Fragment {
    private Filme filme;
    private ImageView imagemFilme;
    private TextView nomeFilme;
    private TextView sinopseDoFilme;
    private TextView elencoDoFilme;
    private TextView notaDoFilme;
    private TextView anoDeLancamento;
    private TextView tempoDeDuracao;
    private TextView categoriaDoFilme;
    private TextView slogan;
    private TextView bilheteria;
    private TextView orcamento;
    private TextView idioma;
    private FilmeViewModel viewModel;
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
        //initIcons();

        if (getArguments() != null) {

            String bundle = getArguments().getString(MOVIE_ID_KEY);
            int bundleId = Integer.parseInt(bundle);
            viewModel.getFilmeId(bundleId, API_KEY);

            viewModel.getFilme().observe(this, filme1 -> {
                Filme filme = new Filme(
                        filme1.getRevenue(),
                        filme1.getTagline(),
                        filme1.getRuntime(),
                        filme1.getBackdropPath(),
                        filme1.getBudget(),
                        filme1.getGenres(),
                        filme1.getHomepage(),
                        filme1.getId(),
                        filme1.getImdbId(),
                        filme1.getOriginalLanguage(),
                        filme1.getOriginalTitle(),
                        filme1.getOverview(),
                        filme1.getPosterPath(),
                        filme1.getReleaseDate(),
                        filme1.getTitle(),
                        filme1.getVideo(),
                        filme1.getVoteAverage());
                nomeFilme.setText(filme.getTitle());
                sinopseDoFilme.setText(filme.getOverview());
                notaDoFilme.setText(filme.getVoteAverage().toString());
                tempoDeDuracao.setText(filme.getRuntime().toString() + "”");
                slogan.setText(filme.getTagline());

                String generos = null;
                for (Genre i : filme.getGenres()) {
                    if (generos == null) {
                        generos = i.getName();
                    } else {
                        generos = generos + ", " + i.getName();
                    }
                }

                categoriaDoFilme.setText(generos);

                String[] data = filme.getReleaseDate().split("-");
                anoDeLancamento.setText(data[2] + "/" + data[1] + "/" + data[0]);

                Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getBackdropPath()).into(imagemFilme);

            });


        }

        return view;


    }

    private void initIcons() {
        iconeJaAssistido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                // bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
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
                //  bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
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
                Intent intent = new Intent(getActivity(), GeralProVideoActivity.class);
                // intent.putExtra(FILME_KEY, filme);
                startActivity(intent);
            }
        });

        iconeFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                //bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, filme);
                Fragment fragment = new ListaDeFavoritosFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = ResultadoFilmeFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.replace(R.id.containerPrincipal, fragment);
                t.commit();

            }
        });
    }

    public void initViews(View view) {
        imagemFilme = view.findViewById(R.id.imagemFilmeDetalhe);
        nomeFilme = view.findViewById(R.id.nomeDetalheFilme_id);
        sinopseDoFilme = view.findViewById(R.id.textview_descricao_da_sinopse_id);
        notaDoFilme = view.findViewById(R.id.notaFilmeDetalhe_id);
        anoDeLancamento = view.findViewById(R.id.textAno_id);
        tempoDeDuracao = view.findViewById(R.id.textDuracao_id);
        categoriaDoFilme = view.findViewById(R.id.textGeneroDetalhe_id);
        slogan = view.findViewById(R.id.textview_titulo_da_slogan);
//                bilheteria
//        orcamento
        iconeTrailler = view.findViewById(R.id.icon_trailer_id);
        iconeFavorito = view.findViewById(R.id.icon_favorito_id);
        iconeCompartilhar = view.findViewById(R.id.icon_favorito_id);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);

    }

}
