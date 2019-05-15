package br.edu.ifam.cromograme.activity;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.JogoCromossomo1Fragment;
import br.edu.ifam.cromograme.fragment.JogoCromossomo2Fragment;
import br.edu.ifam.cromograme.fragment.JogoCromossomo3Fragment;
import br.edu.ifam.cromograme.fragment.JogoCromossomo4Fragment;
import br.edu.ifam.cromograme.fragment.JogoCromossomo5Fragment;

public class JogoCromossomoActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_jogo_cromossomo);

        getSupportActionBar().hide();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutJogoCromossomo, new JogoCromossomo1Fragment());
        transaction.commit();

        textView = findViewById(R.id.textViewQuestaoCromossomo);
        textView.setText("Questão: " + index + "/5");

        button = findViewById(R.id.buttonJogoCromossomoConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (index) {
                    case 1: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo2Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/5");
                    }
                    break;
                    case 2: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo3Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/5");
                    }
                    break;
                    case 3: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo4Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/5");
                    }
                    break;
                    case 4: {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo5Fragment());
                        transaction.commit();
                        index++;
                        textView.setText("Questao: " + index + "/5");
                    }
                    break;
                }
            }
        });
    }
}
