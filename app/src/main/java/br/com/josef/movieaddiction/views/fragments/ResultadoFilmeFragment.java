package br.com.josef.movieaddiction.views.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.model.pojos.movieid.Genre;
import br.com.josef.movieaddiction.vielmodel.FavoritoViewModel;
import br.com.josef.movieaddiction.vielmodel.FilmeViewModel;
import br.com.josef.movieaddiction.views.interfaces.OnClickFavoritos;

import static br.com.josef.movieaddiction.views.fragments.HomeFragment.API_KEY;
import static br.com.josef.movieaddiction.views.fragments.HomeFragment.BANNER_ID_KEY;
import static br.com.josef.movieaddiction.views.fragments.HomeFragment.MOVIE_ID_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFilmeFragment extends Fragment implements OnClickFavoritos {
    private Filme filme;
    private ImageView imagemFilme;
    private TextView nomeFilme;
    private TextView sinopseDoFilme;
    private TextView notaDoFilme;
    private TextView anoDeLancamento;
    private TextView tempoDeDuracao;
    private TextView categoriaDoFilme;
    private TextView slogan;
    private TextView bilheteria;
    private TextView orcamento;
    private FilmeViewModel viewModel;
    private FavoritoViewModel favoritoViewModel;
    public static final String LINGUA_PAIS_KEY = "pt-BR";
    private ImageView iconeFavorito;
    private ImageView iconeCompartilhar;
    private View coracaoCheio;
    private View coracaoVazio;
    private ImageView iconeTrailler;

    public ResultadoFilmeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_filme, container, false);

        initViews(view);

        if (getArguments() != null) {

            String bannerFilme = getArguments().getString(BANNER_ID_KEY);
            String filmeID = getArguments().getString(MOVIE_ID_KEY);
            int bundleId = Integer.parseInt(filmeID);
            viewModel.getFilmeId(bundleId, API_KEY, LINGUA_PAIS_KEY);

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


                if (filme.getBudget() == 0) {
                    orcamento.setText("N/A");

                } else if (filme.getBudget() < 999999) {
                    BigDecimal bigDecimal = new BigDecimal(filme.getBudget());
                    BigDecimal porMil = new BigDecimal(1000);
                    bigDecimal = bigDecimal.divide(porMil, BigDecimal.ROUND_DOWN);
                    orcamento.setText(bigDecimal.toString() + "k");

                } else if (filme.getBudget() < 999999999) {
                    BigDecimal bigDecimal = new BigDecimal(filme.getBudget());
                    BigDecimal porMilao = new BigDecimal(1000000);
                    bigDecimal = bigDecimal.divide(porMilao, BigDecimal.ROUND_DOWN);
                    orcamento.setText(bigDecimal.toString() + "M");
                } else {
                    BigDecimal bigDecimal = new BigDecimal(filme.getBudget());
                    BigDecimal porBilao = new BigDecimal(1000000000);
                    bigDecimal = bigDecimal.divide(porBilao);
                    orcamento.setText(bigDecimal.toString() + "B!");
                }


                if (filme.getRevenue() == 0) {
                    bilheteria.setText("N/A");

                } else if (filme.getRevenue() < 999999) {
                    BigDecimal bigDecimal = new BigDecimal(filme.getRevenue());
                    BigDecimal porMil = new BigDecimal(1000);
                    bigDecimal = bigDecimal.divide(porMil, BigDecimal.ROUND_UP);
                    bilheteria.setText(bigDecimal.toString() + "k");

                } else if (filme.getBudget() < 999999999) {
                    BigDecimal bigDecimal = new BigDecimal(filme.getRevenue());
                    BigDecimal porMilao = new BigDecimal(1000000);
                    bigDecimal = bigDecimal.divide(porMilao, BigDecimal.ROUND_UP);
                    bilheteria.setText(bigDecimal.toString() + "M");
                } else {
                    BigDecimal bigDecimal = new BigDecimal(filme.getRevenue());
                    BigDecimal porBilao = new BigDecimal(1000000000);
                    bigDecimal = bigDecimal.divide(porBilao, BigDecimal.ROUND_DOWN);
                    bilheteria.setText(bigDecimal.toString() + "B");
                }


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


                if (filme.getBackdropPath() == null || filme.getBackdropPath().isEmpty()) {
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getPosterPath()).into(imagemFilme);

                } else {
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getBackdropPath()).into(imagemFilme);
                }

                iconeFavorito.setOnClickListener(v -> {
                    favoritoViewModel.insereFilme(filme);

                    favoritoViewModel.getFilmeBoolean().observe(this, aBoolean -> {
                        Boolean bool = aBoolean;
                        if (bool) {
                            mudarIconeCoracaoParaCheio();
                        }

                    });
                    Toast.makeText(getContext(), "Filme salvo nos favoritos", Toast.LENGTH_SHORT).show();
                });

            });
            if (!imagemFilme.isActivated()) {
                Picasso.get().load("https://image.tmdb.org/t/p/w500/" + bannerFilme).into(imagemFilme);
            }
        }

        iconeCompartilhar.setOnClickListener(view1 -> {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Acredito que você se interessaria pelo filme: " + nomeFilme.getText().toString() +"." +  " Sinopse: " + sinopseDoFilme.getText().toString();
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        return view;

    }

    private void mudarIconeCoracaoParaCheio() {
        iconeFavorito.setImageResource(R.drawable.favoritos_selecionado);
    }


    @SuppressLint("ResourceType")
    public void initViews(View view) {
        imagemFilme = view.findViewById(R.id.imagemFilmeDetalhe);
        nomeFilme = view.findViewById(R.id.nomeDetalheFilme_id);
        sinopseDoFilme = view.findViewById(R.id.textview_descricao_da_sinopse_id);
        notaDoFilme = view.findViewById(R.id.notaFilmeDetalhe_id);
        anoDeLancamento = view.findViewById(R.id.textAno_id);
        tempoDeDuracao = view.findViewById(R.id.textDuracao_id);
        categoriaDoFilme = view.findViewById(R.id.textGeneroDetalhe_id);
        slogan = view.findViewById(R.id.textview_titulo_da_slogan);
        bilheteria = view.findViewById(R.id.txtRevenue);
        orcamento = view.findViewById(R.id.textBudget);
        iconeTrailler = view.findViewById(R.id.icon_trailer_id);
        iconeFavorito = view.findViewById(R.id.icon_favorito_id);
        //iconeCompartilhar = view.findViewById(R.id.icon_favorito_id);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        favoritoViewModel = ViewModelProviders.of(this).get(FavoritoViewModel.class);
        coracaoVazio = view.findViewById(R.drawable.favoritos_nao_selecionado);
        coracaoCheio = view.findViewById(R.drawable.favoritos_selecionado);
        iconeCompartilhar = view.findViewById(R.id.icon_share_id);

    }

    @Override
    public void onClickFavoritos(Filme filme) {

    }

    @Override
    public void removeClickFavoritos(Filme filme) {

    }


}
