package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifam.cromograme.R;

public class CitogeneticaActivity extends AppCompatActivity {

    private Button buttonEstudar;
    private Button buttonJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citogenetica);

        buttonEstudar = findViewById(R.id.buttonEstudarCitogenetica);
        buttonEstudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EstudoCromossomoActivity.class));
            }
        });

        buttonJogar = findViewById(R.id.buttonJogarCitogenetica);
        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO startActivity(new Intent(getApplicationContext(), JogoCromossomoActivity.class));
            }
        });
    }
}
