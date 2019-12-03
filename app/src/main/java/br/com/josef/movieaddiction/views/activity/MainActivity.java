package br.com.josef.movieaddiction.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.util.AppUtil;

public class MainActivity extends AppCompatActivity {
    public TextInputLayout txtEmailMain;
    public TextInputLayout txtSenhaMain;
    public Button btnREg;
    public Button btnLogin;

    public Button btnFacebookMain;
    public Button btnGoogleMain;
    public CallbackManager callbackManager;


    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViews();


        callbackManager = CallbackManager.Factory.create();

        btnREg.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CadastroActivity.class)));

        btnLogin.setOnClickListener(v -> loginEmail());

        btnFacebookMain.setOnClickListener(v -> loginFacebook());

        btnGoogleMain.setOnClickListener(v -> loginGoogle());

        AppUtil.printKeyHash(this);

    }


    private void initViews() {
        btnLogin = findViewById(R.id.mainBtnLogin);
        btnFacebookMain = findViewById(R.id.mainBtnFacebook);
        btnGoogleMain = findViewById(R.id.mainBtnGoogle);
        txtEmailMain = findViewById(R.id.mainTxtEmail);
        txtSenhaMain = findViewById(R.id.mainTxtSenha);
        btnREg = findViewById(R.id.mainBtnRegistre);
    }

    public void loginEmail() {

        String email = txtEmailMain.getEditText().getText().toString();
        String password = txtSenhaMain.getEditText().getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Campos não podem ser vazios :(", Toast.LENGTH_SHORT).show();
            return;
        }

        // tentamos fazer o login com o email e senha no firebase
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        irParaHome(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    } else {
                        Snackbar.make(btnLogin, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                });

    }

    private void loginGoogle() {
        // TODO: Login Google
    }


    public void loginFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                irParaHome(loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void irParaHome(String uiid) {
        AppUtil.salvarIdUsuario(getApplication().getApplicationContext(), uiid);
        startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));
        finish();
    }

    private void autenticacaoGoogle(GoogleSignInAccount account) {
        // TODO: autenticar com google e ir para home
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        // TODO: validar requestcode para google
//        if (requestCode == RC_SIGN_IN) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            if (result.isSuccess()) {
//                GoogleSignInAccount account = result.getSignInAccount();
//                autenticacaoGoogle(account);
//            }
//        }
//        private void setFragment (Fragment fragment){
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction t = fragmentManager.beginTransaction();
//            t.replace(R.id.containerPrincipal, fragment);
//            t.commit();
//        }
    }
}


