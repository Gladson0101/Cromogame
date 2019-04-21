package br.edu.ifam.cromograme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.ifam.cromograme.R;

public class EstudoCitogeneticaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudo_citogenetica);

        getSupportActionBar().setTitle("Citogenética");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }
}
