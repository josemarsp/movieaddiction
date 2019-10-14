package br.com.josef.movieaddiction.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.fragments.ResultadoFilmeFragment;

import static br.com.josef.movieaddiction.views.CadastroActivity.EMAIL_KEY_CAD;
import static br.com.josef.movieaddiction.views.CadastroActivity.SENHA_KEY_CAD;

public class MainActivity extends AppCompatActivity {


    public TextInputLayout txtEmailMain;
    public TextInputLayout txtSenhaMain;
    public Button btnREg;
    public Button btnLogin;
    public Button btnFacebookMain;
    public Button btnGoogleMain;
    private ImageView imagemHobbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtEmailMain = findViewById(R.id.mainTxtEmail);
        txtSenhaMain = findViewById(R.id.mainTxtSenha);
        btnREg = findViewById(R.id.mainBtnRegistre);
        btnFacebookMain = findViewById((R.id.mainBtnFacebook));
        btnGoogleMain = findViewById(R.id.mainBtnGoogle);


        btnREg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });

        btnLogin = findViewById(R.id.mainBtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String localemailMain = (txtEmailMain).getEditText().getText().toString();
                String localsenhaMain = (txtSenhaMain).getEditText().getText().toString();

                if(!localemailMain.isEmpty() && !localsenhaMain.isEmpty()) {


                    Intent intent = getIntent();

                    //Verificação para saber se o intent que está chegando não é null e não possui dados nulos
                    if (getIntent() != null && intent.getExtras() != null) {

                        //Variavel do tipo bundle que recebe as informações vindas do Intent
                        Bundle bundle = intent.getExtras();


                        String emails = bundle.getString(EMAIL_KEY_CAD);
                        String senhas = bundle.getString(SENHA_KEY_CAD);


                        if (localemailMain == emails && localsenhaMain == senhas) {
                            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
                        } else {
                            Snackbar.make(txtEmailMain, "E-mail ou senha incorretos", Snackbar.LENGTH_LONG).show();
                        }

                    } else {
                        txtEmailMain.setError("Email ou senha inválidos");
                    }

                }else{
                    Snackbar.make(txtEmailMain, "Email ou senha não pode ser vazio", Snackbar.LENGTH_LONG).show();
                }



            }
        });

        btnFacebookMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(txtEmailMain, "Login via Facebook não disponível no momento!", Snackbar.LENGTH_LONG).show();
            }
        });

        btnGoogleMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(txtEmailMain, "Login via Google não disponível no momento!", Snackbar.LENGTH_LONG).show();
            }
        });


    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction t = fragmentManager.beginTransaction();
        t.replace(R.id.conainter_principal_id, fragment);
        t.commit();
    }

}