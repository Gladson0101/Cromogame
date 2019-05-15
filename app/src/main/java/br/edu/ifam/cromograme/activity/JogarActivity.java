package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import br.edu.ifam.cromograme.R;

public class JogarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jogar);
        getSupportActionBar().hide();
    }

    public void jogoCromossomos(View view) {
        startActivity(new Intent(getApplicationContext(), JogoCromossomoActivity.class));
    }

    public void jogoDivisaoCelular(View view) {
        startActivity(new Intent(getApplicationContext(), JogoDivisaoCelularActivity.class));
    }

    public void jogarDoencas(View view) {

    }
}
