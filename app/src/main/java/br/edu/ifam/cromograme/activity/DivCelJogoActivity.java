package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.ifam.cromograme.R;

public class DivCelJogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_cel_jogo);
    }

    public void jogoMitose(View view) {
        startActivity(new Intent(getApplicationContext(), JogoMitoseActivity.class));
    }

    public void jogoMeiose(View view) {
        startActivity(new Intent(getApplicationContext(), JogoMeioseActivity.class));
    }
}
