package br.com.josef.movieaddiction.views.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.views.fragments.HomeFragment;
import br.com.josef.movieaddiction.views.fragments.MinhaListaFragment;
import br.com.josef.movieaddiction.views.fragments.PesquisaAtoresFragment;

public class PrincipalActivity extends AppCompatActivity {//implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private BottomNavigationView bottomNavigationView;
    //FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportActionBar().hide();

        replaceFragment(new HomeFragment());

        //     initViews();

        //bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // fragmentManager = getSupportFragmentManager();
        // fragmentManager.beginTransaction().replace(R.id.recyclerViewFilmes, new HomeFragment()).commit();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_minha_lista, R.id.navigation_perfil)
                .build();

        navView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            if (id == R.id.navigation_home){
                replaceFragment(new HomeFragment());

            }else if(id == R.id.navigation_minha_lista){
                replaceFragment(new MinhaListaFragment());

            }else if(id == R.id.navigation_perfil){
                replaceFragment(new PesquisaAtoresFragment());
            }
                return true;

        });




    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

//    private void initViews() {
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
//    }

    /*
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
            fragmentManager.beginTransaction().replace(R.id.recyclerViewFilmes, new PerfilInternoFragment()).commit();

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
                // Fragment homeFragment = HomeFragment.newInstance();
                replaceFragment(new HomeFragment());
                break;
            }
            case R.id.navigation_minha_lista: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Minha Lista");
                Fragment minhaListaFragment = MinhaListaFragment.newInstance();
                replaceFragment(minhaListaFragment);
                break;

            }
            case R.id.navigation_categorias: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Categorias");
                Fragment categoriasFragment = CategoriasFragment.newInstance();
                replaceFragment(categoriasFragment);
                break;
            }
            case R.id.navigation_paparazzi: {
                Objects.requireNonNull(getSupportActionBar()).setTitle("Paparazzi");
                Fragment paparazziFragment = PesquisaAtoresFragment.newInstance();
                replaceFragment(paparazziFragment);
                break;
            }
        }

        return true;
    }


*/

}
