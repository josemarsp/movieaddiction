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
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickAtores;
import br.com.josef.movieaddiction.model.pojos.old.AtoresModel;

public class AtoresAdapter extends RecyclerView.Adapter<AtoresAdapter.ViewHolder> {

    private List<AtoresModel> atoresList;

    private RVOnClickAtores listener;

    public AtoresAdapter(List<AtoresModel> atoresList, RVOnClickAtores listener) {
        this.atoresList = atoresList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pesquisa_atores, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AtoresAdapter.ViewHolder holder, int position) {
        final AtoresModel atores = atoresList.get(position);
        holder.onBind(atores);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(atores);
            }
        });

    }

    @Override
    public int getItemCount() {
        return atoresList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemAtor;
        private TextView nomeAtor;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagemAtor = itemView.findViewById(R.id.fotoAtor);
            nomeAtor = itemView.findViewById(R.id.nomeAtor);
        }

        public void onBind(AtoresModel atores){
            Drawable drawable = itemView.getResources().getDrawable(atores.getImagem());
            imagemAtor.setImageDrawable(drawable);
            nomeAtor.setText(atores.getNome());
        }

    }
}
