package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import br.edu.ifam.cromograme.R;

public class EstudarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_estudar);
        getSupportActionBar().hide();
    }

    public void estudarDivisaoCelular(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoDivCelActivity.class));
    }

    public void estudarEstruturas(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoEstruturasActivity.class));
    }

    public void estudarCromossomos(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoCromossomoActivity.class));
    }

    public void estudarDoencas(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoDoencasActivity.class));
    }

    public void voltar(View view) {
        finish();
    }
}
