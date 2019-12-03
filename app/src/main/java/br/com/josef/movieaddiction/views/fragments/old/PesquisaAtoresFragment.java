package br.com.josef.movieaddiction.views.fragments.old;


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
import br.com.josef.movieaddiction.views.adapter.old.AtoresAdapter;
import br.com.josef.movieaddiction.model.pojos.old.AtoresModel;
import br.com.josef.movieaddiction.views.interfaces.old.RVOnClickAtores;

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

    public static Fragment newInstance() {
        PesquisaAtoresFragment pesquisaAtoresFragment = new PesquisaAtoresFragment();
        return pesquisaAtoresFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pesquisa_atores, container, false);

        initViews (view);

        adapter = new AtoresAdapter(recebeListaAtores(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private List<AtoresModel> recebeListaAtores(){
        atoresList.add(new AtoresModel("Ian McKellen", R.drawable.ian));
        atoresList.add(new AtoresModel("Sandra Bullock", R.drawable.sandra));
        atoresList.add(new AtoresModel("Tom Cruise", R.drawable.tom));
        atoresList.add(new AtoresModel("Emma Stone", R.drawable.emma));

        return atoresList;
    }

    public void initViews(View view){
        recyclerView = view.findViewById(R.id.listaAtoresRecyclerView);
    }

    public void onClick (AtoresModel atores){
        Bundle bundle = new Bundle();
        bundle.putParcelable(ATOR_KEY, atores);

        Fragment detalheFragmento = new ResultadoAtorFragment();
        detalheFragmento.setArguments(bundle);
        replaceFragment(detalheFragmento);
    }

    public void replaceFragment (Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }


}