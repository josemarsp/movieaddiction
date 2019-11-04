package br.com.josef.movieaddiction.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.adapter.FavoritosAdapter;
import br.com.josef.movieaddiction.interfaces.RVOnClickFavoritos;
import br.com.josef.movieaddiction.model.FavoritosModel;

public class ListaDeFavoritosFragment extends Fragment implements RVOnClickFavoritos {

    private ImageView capaDoFilme;
    private TextView tituloDoFilme;
    private TextView descricaoDoFilme;
    private TextView notaDoFilme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_favoritos,container,false);

        ArrayList<FavoritosModel> listaDeFavoritos = new ArrayList<>();
        listaDeFavoritos.add(new FavoritosModel(R.drawable.hobbit, "8.5", "Hobbit", "Frase sobre o filme"));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_favoritos_id);
        FavoritosAdapter favoritosAdapter = new FavoritosAdapter(this, listaDeFavoritos);
        recyclerView.setAdapter(favoritosAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        return view;
    }

    @Override
    public void onClickFavoritos(FavoritosModel favoritosModel) {
        Log.d("favorito", "clicou");
    }
}
