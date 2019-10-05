package br.com.josef.movieaddiction.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.adapter.AtoresAdapter;
import br.com.josef.movieaddiction.interfaces.RVOnClickAtores;
import br.com.josef.movieaddiction.model.AtoresModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisaAtoresFragment extends Fragment implements RVOnClickAtores {
    private RecyclerView recyclerView;
    private AtoresAdapter adapter;
    private List<AtoresModel> atoresList = new ArrayList<>();
    public static final String ATOR_KEY = "ator";


    public PesquisaAtoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pesquisa_atores, container, false);

        initViews (view);

        adapter = new AtoresAdapter(recebeListaAtores(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private List<AtoresModel> recebeListaAtores(){
        atoresList.add(new AtoresModel(R.drawable.ian2, "Ian McKellen"));

        return atoresList;
    }

    public void initViews(View view){
        recyclerView = view.findViewById(R.id.listaAtoresRecyclerView);
    }

    public void onClick (AtoresModel atores){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, getParentFragment());
        transaction.commit();
    }


}
