package br.edu.ifam.cromograme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifam.cromograme.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonDivCel;
    private Button buttonCitogene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDivCel = findViewById(R.id.buttonDivCel);
        buttonDivCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DivCelActivity.class));
            }
        });

        buttonCitogene = findViewById(R.id.buttonCitogene);
        buttonCitogene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CitogeneticaActivity.class));
            }
        });
    }
}
