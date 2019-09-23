package br.com.josef.movieaddiction.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.josef.movieaddiction.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView imgSplash;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide(); // tira a AppBar

        imgSplash = findViewById(R.id.img_splash_id);

        imgSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

}
