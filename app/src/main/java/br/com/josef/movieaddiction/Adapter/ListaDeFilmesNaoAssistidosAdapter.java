package br.com.josef.movieaddiction.Adapter;

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
import br.com.josef.movieaddiction.model.FilmesNaoAssistidosModel;

public class ListaDeFilmesNaoAssistidosAdapter extends RecyclerView.Adapter<ListaDeFilmesNaoAssistidosAdapter.ViewHolder>{

    private List<FilmesNaoAssistidosModel>listaFilmesM;

    public ListaDeFilmesNaoAssistidosAdapter(List<FilmesNaoAssistidosModel> listaFilmesA){
        this.listaFilmesM = listaFilmesA;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_do_item_da_lista_filmes_nao_assistidos,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaDeFilmesNaoAssistidosAdapter.ViewHolder holder, int position) {
        FilmesNaoAssistidosModel filmesNaoAssistidosModel = listaFilmesM.get(position);
        //todo: qual opcao eu escolho pro viewHolder?
        viewHolder.onBind(filmesNaoAssistidosModel);
    }

    @Override
    public int getItemCount() {
        return listaFilmesM.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView capaFilme;
        private TextView tituloDoFilme;
        private TextView descriecaoDoFilme;
        private ImageView estrelaRating;
        private TextView notaFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            capaFilme = itemView.findViewById(R.id.img_capa_filme_nao_vistos_id);
            tituloDoFilme = itemView.findViewById(R.id.textView_titulo_filme_nao_assistido_id);
            descriecaoDoFilme = itemView.findViewById(R.id.textView_descricao_filme_nao_assistido_id);
            estrelaRating = itemView.findViewById(R.id.imageView_rating_img_star_nao_assistido_id);
            notaFilme = itemView.findViewById(R.id.textView_rating_nota_nao_assistido_id);


        }
//todo:pq onBind ta cinza?
        public void onBind(FilmesNaoAssistidosModel filmesNaoAssistidosModel){

            tituloDoFilme.setText(filmesNaoAssistidosModel.getDescricaoDoFilme());
            descriecaoDoFilme.setText(filmesNaoAssistidosModel.getDescricaoDoFilme());
            capaFilme.setImageDrawable(filmesNaoAssistidosModel.getCapaDoFilme());
            estrelaRating.setImageDrawable(filmesNaoAssistidosModel.getEstrelaRating());
//            todo:ta certo? pq o tipo eh double e ele pediu int
            notaFilme.setText((int) filmesNaoAssistidosModel.getNotaDoFilme());

        }
    }
}
