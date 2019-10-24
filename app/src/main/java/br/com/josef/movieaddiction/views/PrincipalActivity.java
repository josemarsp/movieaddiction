package br.com.josef.movieaddiction.views;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.fragments.CategoriasFragment;
import br.com.josef.movieaddiction.fragments.HomeFragment;
import br.com.josef.movieaddiction.fragments.MinhaListaFragment;
import br.com.josef.movieaddiction.fragments.PerfilInternoFragment;
import br.com.josef.movieaddiction.fragments.PesquisaAtoresFragment;

public class PrincipalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        initViews();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        openFragment(new HomeFragment());

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.conainter_principal_id, new HomeFragment()).commit();


//todo: como fazer minha parte
//todo e o pojo ta certo?
//        me explica a diferenca entre comunicacao entre fragment com ativitity e vice versa. pq ja sei frag pra frag e act p act

    }

    private void initViews() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.sair) {

            finish();

            return true;
        }

        if (id == R.id.perfil) {

            Objects.requireNonNull(getSupportActionBar()).setTitle("Perfil");
            fragmentManager.beginTransaction().replace(R.id.conainter_principal_id, new PerfilInternoFragment()).commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
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
        transaction.replace(R.id.conainter_principal_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
