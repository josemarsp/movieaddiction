package br.com.josef.movieaddiction.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.josef.movieaddiction.R;

public class CadastroActivity extends AppCompatActivity {

    public TextInputLayout txtNome;
    public TextInputLayout txtEmail;
    public TextInputLayout txtSenha;
    public TextInputLayout txtConfSenha;
    public TextInputLayout txtIdade;
    public Button btnFacebook;
    public Button btnRegistrar;
    public Button btnGoogle;

    public static final String EMAIL_KEY_CAD = "email";
    public static final String SENHA_KEY_CAD = "senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();



        btnRegistrar = findViewById(R.id.cadBtnRegistrar);
        btnFacebook = findViewById(R.id.cadBtnFacebook);
        btnGoogle = findViewById(R.id.cadBtnGoogle);
        txtNome = findViewById(R.id.cadTxtNome);
        txtEmail= findViewById(R.id.cadTxtEmail);
        txtSenha= findViewById(R.id.cadTxtSenha);
        txtConfSenha=findViewById(R.id.cadTxtConfSenha);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String localNome = txtNome.getEditText().getText().toString();
                String localEmail = txtEmail.getEditText().getText().toString();
                String localSenha = txtSenha.getEditText().getText().toString();
                String localConfSenha = txtConfSenha.getEditText().getText().toString();


//                if (!localNome.isEmpty() && !localEmail.isEmpty()&& !localSenha.isEmpty() && !localConfSenha.isEmpty()){



                    //Criando uma nova instancia do tipo Intent
                    Intent intent = new Intent(CadastroActivity.this, PrincipalActivity.class);

                    //Criando uma nova instancia do Bundle
                    Bundle bundle = new Bundle();

                    //Passando os dados para o bundle
                    bundle.putString(EMAIL_KEY_CAD , localEmail);
                    bundle.putString(SENHA_KEY_CAD, localSenha);

                    //Passo bundle para a intent
                    intent.putExtras(bundle);

                    //Passo a intent para o startActivity
                    startActivity(intent);

//                }
//                else{

                    Snackbar.make(btnRegistrar, "Todos os campos devem ser preenchidos!", Snackbar.LENGTH_LONG).show();
                    /* txtNome.setError("Preencha o campo nome!");
                    txtEmail.setError("Preencha o campo e-mail!");
                    txtSenha.setError("Preencha o campo senha!");
                    txtConfSenha.setError("Preencha o campo Confirmação de Senha!");*/

//                }


            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(btnFacebook, "Cadastro via Facebook não disponível no momento!", Snackbar.LENGTH_SHORT).show();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(btnGoogle,"Cadastro via Google não disponível no momento!",Snackbar.LENGTH_SHORT).show();
            }
        });


    }



}
