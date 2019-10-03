package br.com.josef.movieaddiction.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.josef.movieaddiction.R;

public class PrincipalActivity extends AppCompatActivity {

    private BottomNavigationView menuNavigationInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        menuNavigationInferior = (BottomNavigationView) findViewById(R.id.navigationView);

    }
}
