package br.com.josef.movieaddiction.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.util.AppUtil;

public class CadastroActivity extends AppCompatActivity {

    public TextInputLayout txtNome;
    public TextInputLayout txtEmail;
    public TextInputLayout txtSenha;
    public TextInputLayout txtConfSenha;
    public Button btnRegistrar;


    private String nome, email, senha, confSenhas;

    public static final String EMAIL_KEY_CAD = "email";
    public static final String SENHA_KEY_CAD = "senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        initViews();

        btnRegistrar.setOnClickListener(v -> {
            String email = txtEmail.getEditText().getText().toString();
            String password = txtSenha.getEditText().getText().toString();

            // Se e-mail e senha são válidos, tentamos o registro no firebase
            if (validar(email, password)) {
                registrarUsuario(email, password);
            }
        });
    }

    public void initViews(){
        btnRegistrar = findViewById(R.id.cadBtnRegistrar);
        txtNome = findViewById(R.id.cadTxtNome);
        txtEmail = findViewById(R.id.cadTxtEmail);
        txtSenha = findViewById(R.id.cadTxtSenha);
        txtConfSenha = findViewById(R.id.cadTxtConfSenha);
    }
    private void registrarUsuario(String email, String password) {
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        AppUtil.salvarIdUsuario(CadastroActivity.this, FirebaseAuth.getInstance().getCurrentUser().getUid());
                        startActivity(new Intent(CadastroActivity.this, PrincipalActivity.class));
                        finish();
                    } else {
                        Snackbar.make(btnRegistrar, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                });
    }

    private boolean validar(String email, String password) {
        if (email.isEmpty()) {
            txtEmail.setError("Email não pode ser vazio");
            txtEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.setError("Email inválido");
            txtEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            txtSenha.setError("Senha não pode ser vazio");
            txtSenha.requestFocus();
            return false;
        }

        if (password.length() < 6) {
            txtSenha.setError("Senha deve ser maior qeu 6 caracters");
            txtSenha.requestFocus();
            return false;
        }

        return true;
    }
}
