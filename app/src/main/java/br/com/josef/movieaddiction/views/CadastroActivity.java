package br.com.josef.movieaddiction.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String nome, email, senha, confSenhas;

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
        txtEmail = findViewById(R.id.cadTxtEmail);
        txtSenha = findViewById(R.id.cadTxtSenha);
        txtConfSenha = findViewById(R.id.cadTxtConfSenha);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validarCamposCAD();

/*
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
                Snackbar.make(btnGoogle, "Cadastro via Google não disponível no momento!", Snackbar.LENGTH_SHORT).show();
            }
        });


    }
    public void validarCamposCAD(){
        txtNome.setErrorEnabled(false);
        txtEmail.setErrorEnabled(false);
        txtSenha.setErrorEnabled(false);
        txtConfSenha.setErrorEnabled(false);

        nome = txtNome.getEditText().getText().toString().trim();
        email = txtEmail.getEditText().getText().toString().trim();
        senha = txtSenha.getEditText().getText().toString().trim();
        confSenhas= txtConfSenha.getEditText().getText().toString().trim();

        if (!validateEmailCAD(email) && !validatePasswordCAd(senha) && !nomeCAd(nome)) {
            txtNome.setError("Nome precisa ter mais de 5 caracteres");
            txtEmail.setError("Digite um e-mail válido");
            txtSenha.setError("Sua senha deve ter pelo menos 6 caractéres!");
            txtConfSenha.setError("Sua senha deve ter pelo menos 6 caractéres!");

        } else if(!validateEmailCAD(email)){
            txtEmail.setError("Digite um e-mail válido");
            txtSenha.setErrorEnabled(false);
            txtNome.setErrorEnabled(false);
            txtConfSenha.setErrorEnabled(false);
        } else if (!validatePasswordCAd(senha)) {
            txtSenha.setError("Sua senha deve ter pelo menos 6 caractéres!");
            txtEmail.setErrorEnabled(false);
            txtNome.setErrorEnabled(false);
            txtConfSenha.setErrorEnabled(false);
        }else if (confSenhas.equals(senha)) { // tem de trocar o sinal para "!=" validar, mas nao valida
            startActivity(new Intent(CadastroActivity.this, PrincipalActivity.class));
        } else{
            txtConfSenha.setError("Confirmação de senha inválida!");
            txtEmail.setErrorEnabled(false);
            txtNome.setErrorEnabled(false);
            txtSenha.setErrorEnabled(false);

        }

    }
    public boolean validateEmailCAD(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePasswordCAd(String password) {
        return password.length() > 5;
    }

    public boolean nomeCAd(String nomeStr) {
        return nomeStr.length() > 5;
    }

}
