package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

/**
 * Created by Arthur on 26/02/2016.
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    private static final long Tempo_limite= 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler SplashScreen = new Handler();
        SplashScreen.postDelayed( this, Tempo_limite);
    }


    public void run() {
        Intent intent = new Intent(this, BuscarNomeActivity.class);
        startActivity(intent);
        finish();
    }

}
