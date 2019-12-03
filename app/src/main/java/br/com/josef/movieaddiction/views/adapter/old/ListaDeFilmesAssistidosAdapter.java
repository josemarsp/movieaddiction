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
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickFilmesAssistidos;
import br.com.josef.movieaddiction.model.pojos.old.FilmesAssistidosModel;

public class ListaDeFilmesAssistidosAdapter extends RecyclerView.Adapter<ListaDeFilmesAssistidosAdapter.ViewHolder>{
    private RVOnClickFilmesAssistidos listener;
    private List<FilmesAssistidosModel> listaFilmesAssistidos;

    public ListaDeFilmesAssistidosAdapter(RVOnClickFilmesAssistidos listener, List<FilmesAssistidosModel>listaFilmesAssistidos){
        this.listener = listener;
        this.listaFilmesAssistidos = listaFilmesAssistidos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_do_item_da_lista_filmes_assistidos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FilmesAssistidosModel filmesAssistidosModel = listaFilmesAssistidos.get(position);
        holder.onBind(filmesAssistidosModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickFilmesAssistidos(filmesAssistidosModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaFilmesAssistidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView capaDoFilme;
        public TextView notaDoFilme;
        public TextView nomeDoFilme;
        public TextView descricaoDoFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            capaDoFilme = itemView.findViewById(R.id.img_capa_filme_vistos_id);
            nomeDoFilme = itemView.findViewById(R.id.textView_titulo_filme_assistido_id);
            notaDoFilme = itemView.findViewById(R.id.textView_rating_nota_assistido_id);
            descricaoDoFilme = itemView.findViewById(R.id.textView_descricao_filme_assistido_id);
        }

        public void onBind(FilmesAssistidosModel filmesAssistidosModel) {
            Drawable drawable = itemView.getResources().getDrawable(filmesAssistidosModel.getCapaDoFilme());
            capaDoFilme.setImageDrawable(drawable);
            notaDoFilme.setText(filmesAssistidosModel.getNotaDoFilme());
            nomeDoFilme.setText(filmesAssistidosModel.getNomeDoFilme());
            descricaoDoFilme.setText(filmesAssistidosModel.getDescricaoDoFilme());


        }
    }
}