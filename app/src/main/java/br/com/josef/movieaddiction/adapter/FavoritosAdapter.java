package br.com.josef.movieaddiction.adapter;
import android.content.Context;
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
import br.com.josef.movieaddiction.interfaces.RVOnClickFavoritos;
import br.com.josef.movieaddiction.model.FavoritosModel;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private RVOnClickFavoritos listener;
    private List<FavoritosModel> listaFavoritos;

    public FavoritosAdapter(RVOnClickFavoritos listener, List<FavoritosModel> listaFavoritos) {
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
        final FavoritosModel favoritosModel = listaFavoritos.get(position);
        holder.onBind(favoritosModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickFavoritos(favoritosModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView capaDoFilme;
        public TextView notaDoFilme;
        public TextView nomeDoFilme;
        public TextView descricaoDoFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            capaDoFilme = itemView.findViewById(R.id.img_capa_favoritos_id);
            nomeDoFilme = itemView.findViewById(R.id.textView_titulo_favoritos_id);
            notaDoFilme = itemView.findViewById(R.id.textView_rating_nota_favoritos_id);
            descricaoDoFilme = itemView.findViewById(R.id.textView_descricao_favoritos_id);
        }

        public void onBind(FavoritosModel favoritosModel) {
            Drawable drawable = itemView.getResources().getDrawable(favoritosModel.getCapaDoFilme());
            capaDoFilme.setImageDrawable(drawable);
            notaDoFilme.setText(favoritosModel.getNotaDoFilme());
            nomeDoFilme.setText(favoritosModel.getNomeDoFilme());
            descricaoDoFilme.setText(favoritosModel.getDescricaoDoFilme());
        }
    }
}
