package br.com.josef.movieaddiction.views.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.facebook.login.LoginManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.views.fragments.HomeFragment;
import br.com.josef.movieaddiction.views.fragments.ListaDeFavoritosFragment;
import br.com.josef.movieaddiction.views.fragments.PerfilInternoFragment;
import br.com.josef.movieaddiction.views.fragments.SearchFragment;

public class PrincipalActivity extends AppCompatActivity {


    // private BottomNavigationView bottomNavigationView;
    //FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportActionBar();

        replaceFragment(new HomeFragment());

        //     initViews();

        //  bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // fragmentManager = getSupportFragmentManager();
        // fragmentManager.beginTransaction().replace(R.id.recyclerViewFilmes, new HomeFragment()).commit();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_minha_lista, R.id.navigation_perfil)
                .build();

        navView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            if (id == R.id.navigation_home) {
                replaceFragment(new HomeFragment());

            } else if (id == R.id.navigation_minha_lista) {
                replaceFragment(new ListaDeFavoritosFragment());

            } else if (id == R.id.navigation_search) {
                replaceFragment(new SearchFragment());

            } else if (id == R.id.navigation_perfil) {
                replaceFragment(new PerfilInternoFragment());
            }
            return true;

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.sair) {

            deslogar();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void deslogar() {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(PrincipalActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}

//    private void initViews() {
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
//    }

    /*


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)



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


