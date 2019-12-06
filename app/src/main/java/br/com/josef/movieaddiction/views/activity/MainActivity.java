package br.com.josef.movieaddiction.views.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.util.AppUtil;

public class MainActivity extends AppCompatActivity {
    public TextInputLayout txtEmailMain;
    public TextInputLayout txtSenhaMain;
    public Button btnREg;
    public Button btnLogin;

    public Button btnFacebookMain;
    public CallbackManager callbackManager;

    private static final int RC_SIGN_IN = 1001;
    public Button btnGoogleMain;
    private GoogleSignInClient googleSignInClient;
    public static final String GOOGLE_ACCOUNT = "google_account";


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
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        btnGoogleMain.setOnClickListener(view -> {
            Intent signInIntent = googleSignInClient.getSignInIntent();

            startActivityForResult(signInIntent, 101);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount alreadyLoggedAccount = GoogleSignIn.getLastSignedInAccount(this);

        if (alreadyLoggedAccount != null) {
            Toast.makeText(this, "Você já está logado", Toast.LENGTH_LONG).show();
            autenticacaoGoogle(alreadyLoggedAccount);
        } else {
            Toast.makeText(this, "Entre em alguma conta", Toast.LENGTH_LONG).show();
        }
    }


    public void loginFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AuthCredential credential = FacebookAuthProvider
                        .getCredential(loginResult.getAccessToken().getToken());

                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(task -> {
                            irParaHome(loginResult.getAccessToken().getUserId());
                        });
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

    private void autenticacaoGoogle(GoogleSignInAccount conta) {
        Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
        intent.putExtra(GOOGLE_ACCOUNT, conta);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                autenticacaoGoogle(account);
            }
        }

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 101:
                    try {
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount conta = task.getResult(ApiException.class);
                        autenticacaoGoogle(conta);

                    } catch (ApiException e) {
                        Log.i("LOG", "Error: " + e.getMessage());
                        Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }
}