package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifam.cromograme.R;

public class DivCelActivity extends AppCompatActivity {

    private Button buttonEstudar;
    private Button buttonJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_cel);

        getSupportActionBar().setTitle("Divisão Celular");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonEstudar = findViewById(R.id.buttonEstudarDivCel);
        buttonEstudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EstudoDivCelActivity.class));
            }
        });

        buttonJogar = findViewById(R.id.buttonJogarDivCel);
        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DivCelJogoActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }
}
