package br.com.josef.movieaddiction.views.adapter.old;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickCategorias;
import br.com.josef.movieaddiction.model.pojos.old.CategoriasListas;


public class AdapterCategoria extends RecyclerView.Adapter <AdapterCategoria.ViewHolder> {

    private List<CategoriasListas> listaCategorias;
    private RVOnClickCategorias listener;


    public AdapterCategoria(List<CategoriasListas> listaCategorias, RVOnClickCategorias listener) {
        this.listaCategorias = listaCategorias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categorias_modelo,viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        final CategoriasListas categoriasListas = listaCategorias.get(posicao);
        viewHolder.onBind(categoriasListas);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(categoriasListas);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    //CLASSE A VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Declaração dos componentes
        private TextView txtNome;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.textoLista);

        }

        public void onBind(CategoriasListas categoriasListas){

            txtNome.setText(categoriasListas.getTexTCategoria());


        }
    }
}