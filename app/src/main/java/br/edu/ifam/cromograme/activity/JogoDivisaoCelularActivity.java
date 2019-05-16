package br.edu.ifam.cromograme.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_divisao_celular);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel1Fragment());
        transaction.commit();

    }
}
