package br.com.josef.movieaddiction.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.fragments.ListaDeFilmesPorCategoriaFragment;
import br.com.josef.movieaddiction.interfaces.RVOnClickFilmes;
import br.com.josef.movieaddiction.model.FilmesModel;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.ViewHolder> {

    private List<FilmesModel> filmesList;

    private RVOnClickFilmes listener;

    public FilmesAdapter(List<FilmesModel> atoresList, ListaDeFilmesPorCategoriaFragment listaDeFilmesPorCategoriaFragment){};

    public FilmesAdapter(List<FilmesModel> atoresList, RVOnClickFilmes listener) {
        this.filmesList = atoresList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public FilmesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pesquisa_filmes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmesAdapter.ViewHolder holder, int position) {
        final FilmesModel filmes = filmesList.get(position);
        holder.onBind(filmes);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClick(filmes);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemFilme;
        private TextView nomeFilme;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagemFilme = itemView.findViewById(R.id.imagemFilme);
            nomeFilme = itemView.findViewById(R.id.nomeFilme_id);
        }

        public void onBind(FilmesModel filmes){
            Drawable drawable = itemView.getResources().getDrawable(filmes.getImagem());
            imagemFilme.setImageDrawable(drawable);
            nomeFilme.setText(filmes.getNome());
        }

    }
}