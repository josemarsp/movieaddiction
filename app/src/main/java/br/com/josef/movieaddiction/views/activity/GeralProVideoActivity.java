package br.com.josef.movieaddiction.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.model.pojos.old.FilmesModel;

import static br.com.josef.movieaddiction.views.fragments.old.PesquisaFilmesFragment.FILME_KEY;

public class GeralProVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral_pro_video);

        Intent intent = getIntent();
        FilmesModel filme = intent.getExtras().getParcelable(FILME_KEY);
        final String videoURL = filme.getVideoURL();

        final WebView webView = findViewById(R.id.geral_video_webview_id);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(videoURL);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.d("deu_ruim", error.toString());
            }
        });
    }
}
