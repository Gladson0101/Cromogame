package br.edu.ifam.cromograme.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
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

    private Button buttonDesistir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_divisao_celular);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        buttonDesistir = findViewById(R.id.buttonJogoDivisaoCelularDesistir);
        buttonDesistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Desistir");
                builder.setMessage("Você deseja realmente sair?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Não", null);
                builder.create().show();
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel1Fragment());
        transaction.commit();

    }
}
