package br.com.josef.movieaddiction.views;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.fragments.MinhaListaFragment;
import br.com.josef.movieaddiction.fragments.CategoriasFragment;
import br.com.josef.movieaddiction.fragments.HomeFragment;
import br.com.josef.movieaddiction.fragments.PesquisaAtoresFragment;

public class PrincipalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        openFragment(new HomeFragment());

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home: {

                Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
                Fragment homeFragment = HomeFragment.newInstance();
                openFragment(homeFragment);
                break;
            }
            case R.id.navigation_minha_lista: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Minha Lista");
                Fragment minhaListaFragment = MinhaListaFragment.newInstance();
                openFragment(minhaListaFragment);
                break;

            }
            case R.id.navigation_categorias: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Categorias");
                Fragment categoriasFragment = CategoriasFragment.newInstance();
                openFragment(categoriasFragment);
                break;
            }
            case R.id.navigation_paparazzi: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Paparazzi");
                Fragment paparazziFragment = PesquisaAtoresFragment.newInstance();
                openFragment(paparazziFragment);
                break;
            }
        }

        return true;
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conainter_principal, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}

