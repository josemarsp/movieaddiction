package br.com.josef.movieaddiction.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.FilmesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.imageView_hobbit_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilmesModel model = new FilmesModel(
                        R.drawable.hobbit,
                        "O Hobbit",
                        "Teste",
                        "todo",
                        "todo",
                        "2019",
                        "5 minutos",
                        "50 anos",
                        "infantil",
                        "https://www.youtube.com/watch?v=nOGsB9dORBg&t=47s"
                );

                Bundle bundle = new Bundle();
                bundle.putParcelable(PesquisaFilmesFragment.FILME_KEY, model);
                ResultadoFilmeFragment fragment = new ResultadoFilmeFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.replace(R.id.conainter_principal_id, fragment);
                t.commit();
            }
        });

        return view;

    }
}
