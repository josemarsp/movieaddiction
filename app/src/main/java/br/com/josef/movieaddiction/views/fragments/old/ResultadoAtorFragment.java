package br.com.josef.movieaddiction.views.fragments.old;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.old.AtoresModel;

import static br.com.josef.movieaddiction.views.fragments.old.PesquisaAtoresFragment.ATOR_KEY;

//import static br.com.josef.movieaddiction.views.fragments.old.PesquisaAtoresFragment.ATOR_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoAtorFragment extends Fragment {
    private ImageView imagemAtor;
    private TextView nomeAtor;

    public ResultadoAtorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_ator, container, false);

        initViews(view);

        if (getArguments() != null){

            AtoresModel atores = getArguments().getParcelable(ATOR_KEY);

            if (atores != null){
                Drawable drawable = getResources().getDrawable(atores.getImagem());

                imagemAtor.setImageDrawable(drawable);
                nomeAtor.setText(atores.getNome());
            }

        }

        return view;
    }



    public void initViews(View view){
        imagemAtor = view.findViewById(R.id.imagemAtor);
        nomeAtor = view.findViewById(R.id.nomeAtor);
    }

}
