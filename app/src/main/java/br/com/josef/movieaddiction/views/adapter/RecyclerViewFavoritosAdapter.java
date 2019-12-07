package br.com.josef.movieaddiction.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.movieid.Filme;
import br.com.josef.movieaddiction.views.interfaces.OnClickFavoritos;

public class RecyclerViewFavoritosAdapter extends RecyclerView.Adapter<RecyclerViewFavoritosAdapter.ViewHolder> {

    private OnClickFavoritos listener;
    private List<Filme> listaFavoritos;

    public RecyclerViewFavoritosAdapter(OnClickFavoritos listener, List<Filme> listaFavoritos) {
        this.listener = listener;
        this.listaFavoritos = listaFavoritos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_do_item_da_lista_favoritos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Filme favoritos = listaFavoritos.get(position);
        holder.onBind(favoritos);

        holder.itemView.setOnClickListener(view -> listener.onClickFavoritos(favoritos));
        holder.iconeLixeira.setOnClickListener(view -> listener.removeClickFavoritos(favoritos));

    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public void atualizaLista(List<Filme> novaLista) {
        if (this.listaFavoritos.isEmpty()) {
            this.listaFavoritos = novaLista;
        } else {
            this.listaFavoritos.addAll(novaLista);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView capaDoFilme;
        public TextView notaDoFilme;
        public TextView nomeDoFilme;
        public TextView descricaoDoFilme;
        public ImageView iconeLixeira;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            capaDoFilme = itemView.findViewById(R.id.img_capa_favoritos_id);
            nomeDoFilme = itemView.findViewById(R.id.textView_titulo_favoritos_id);
            notaDoFilme = itemView.findViewById(R.id.textView_rating_nota_favoritos_id);
            descricaoDoFilme = itemView.findViewById(R.id.textView_descricao_favoritos_id);
            iconeLixeira = itemView.findViewById(R.id.iconeLixeira);
        }

        public void onBind(Filme filme) {
            notaDoFilme.setText(filme.getVoteAverage().toString());
            nomeDoFilme.setText(filme.getTitle());
            descricaoDoFilme.setText(filme.getOverview());


            Picasso.get().load("https://image.tmdb.org/t/p/w200/" + filme.getPosterPath()).into(capaDoFilme);


        }
    }

}
