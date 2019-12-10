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
import br.com.josef.movieaddiction.model.pojos.searchmovies.Search;
import br.com.josef.movieaddiction.views.interfaces.OnClickSearch;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private OnClickSearch listener;
    private List<Search> listaSearch;

    public SearchAdapter(OnClickSearch listener, List<Search> listaSearch) {
        this.listener = listener;
        this.listaSearch = listaSearch;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_do_item_da_lista_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Search search = listaSearch.get(position);
        holder.onBind(search);

        holder.itemView.setOnClickListener(v -> {
            listener.click(search);
        });
    }

    @Override
    public int getItemCount() {
        return listaSearch.size();
    }

    public void atualizaLista(List<Search> novaLista) {
        if (listaSearch.isEmpty()) {
            this.listaSearch = novaLista;
        } else {
            this.listaSearch.addAll(novaLista);
        }
        notifyDataSetChanged();
    }

    public void clear(){
        listaSearch.clear();
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

        public void onBind(Search search) {
            notaDoFilme.setText(search.getVoteAverage().toString());
            nomeDoFilme.setText(search.getTitle());
            descricaoDoFilme.setText(search.getOverview());

            Picasso.get().load("https://image.tmdb.org/t/p/w200/" + search.getPosterPath()).into(capaDoFilme);

        }
    }
}
