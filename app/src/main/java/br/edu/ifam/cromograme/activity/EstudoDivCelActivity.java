package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import br.edu.ifam.cromograme.R;

public class EstudoDivCelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudo_div_cel);

        getSupportActionBar().setTitle("Divisão Celular");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void estudarMitose(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoMitoseActivity.class));
    }

    public  void estudarMeiose(View view) {
        startActivity(new Intent(getApplicationContext(), EstudoMeioseActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }
}
