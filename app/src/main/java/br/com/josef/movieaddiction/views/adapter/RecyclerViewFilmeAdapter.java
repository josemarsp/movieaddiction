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
import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;
import br.com.josef.movieaddiction.views.interfaces.OnClickFilmePlayingNow;

public class RecyclerViewFilmeAdapter extends RecyclerView.Adapter<RecyclerViewFilmeAdapter.ViewHolder> {

    private List<FilmeNowPlaying> filmeNowPlayingList;
    private OnClickFilmePlayingNow listener;

    public RecyclerViewFilmeAdapter(List<FilmeNowPlaying> filmeNowPlayingList, OnClickFilmePlayingNow listener) {
        this.filmeNowPlayingList = filmeNowPlayingList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_lista_um, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFilmeAdapter.ViewHolder holder, int position) {
        FilmeNowPlaying filmeNowPlaying = filmeNowPlayingList.get(position);
        holder.onBind(filmeNowPlaying);

        holder.itemView.setOnClickListener(v -> {
            listener.click(filmeNowPlaying);
        });
    }

    @Override
    public int getItemCount() {
        return filmeNowPlayingList.size();
    }

    public void atualizaLista(List<FilmeNowPlaying> novaLista) {
        if (this.filmeNowPlayingList.isEmpty()) {
            this.filmeNowPlayingList = novaLista;
        } else {
            this.filmeNowPlayingList.addAll(novaLista);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitulo;
        private ImageView imgFilme;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txtTituloItemHome);
            imgFilme = itemView.findViewById(R.id.imgFilmeHome);
        }

        public void onBind(FilmeNowPlaying filmeNowPlaying) {

            txtTitulo.setText(filmeNowPlaying.getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/w200/" + filmeNowPlaying.getPosterPath()).into(imgFilme);
        }
    }
}
