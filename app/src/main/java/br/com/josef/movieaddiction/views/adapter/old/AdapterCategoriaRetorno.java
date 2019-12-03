package br.com.josef.movieaddiction.views.adapter.old;

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
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickFilmes;
import br.com.josef.movieaddiction.model.pojos.old.FilmesModel;


public class AdapterCategoriaRetorno extends RecyclerView.Adapter<AdapterCategoriaRetorno.ViewHolder>{

    private List<FilmesModel> retornoFilmesCat;
    private RVOnClickFilmes listener;


    public AdapterCategoriaRetorno(List<FilmesModel> categoriasListasRetornos, RVOnClickFilmes listener) {
        this.retornoFilmesCat = categoriasListasRetornos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.retorno_da_categoria_modelo,viewGroup, false);
        return new ViewHolder(view);
}


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int posicao) {
        final FilmesModel filmesModel = retornoFilmesCat.get(posicao);
        holder.onBind(filmesModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(filmesModel);
            }
        });

    }


    @Override
    public int getItemCount() {
        return retornoFilmesCat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cartzFilme;
        private TextView tituloFilme;
        private TextView sinopse;
        private TextView notaFilme;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartzFilme = itemView.findViewById(R.id.cardDeDilmesRetornoCat);
            tituloFilme = itemView.findViewById(R.id.nomeFilmeRetornoCat);
            sinopse = itemView.findViewById(R.id.descricaoFilmeRetornoCat);
            notaFilme = itemView.findViewById(R.id.retornoAvaliacaoCat);
        }

        public void onBind(FilmesModel filmesModel) {
            Drawable drawable = itemView.getResources().getDrawable(filmesModel.getImagem());
            cartzFilme.setImageDrawable(drawable);
            tituloFilme.setText(filmesModel.getNome());
            sinopse.setText(filmesModel.getSinopse());
            notaFilme.setText(filmesModel.getNotaFilme());

        }
    }
}
