package br.edu.ifam.cromograme.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.DivCelNivel10Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel1Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel2Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel3Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel4Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel5Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel6Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel7Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel8Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel9Fragment;

public class JogoDivisaoCelularActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_divisao_celular);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel1Fragment());
        transaction.commit();

        textView = findViewById(R.id.textViewQuestaoDivisaoCelular);
        textView.setText("Questao: " + index + "/10");

        button = findViewById(R.id.buttonJogoDivisaoCelularConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (index) {
                    case 1: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel2Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 2: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel3Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 3: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel4Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 4: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel5Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 5: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel6Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 6: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel7Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 7: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel8Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 8: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel9Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                    case 9: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel10Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/10");
                    }
                    break;
                }
            }
        });
    }
}
