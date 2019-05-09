package br.edu.ifam.cromograme.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.adapter.SliderPagerAdapter;
import br.edu.ifam.cromograme.fragment.DivCelNivel10Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel6Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel7Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel8Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel9Fragment;

public class JogoMeioseActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private TextView textView;

    private Button buttonProximo;
    private int globalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_meiose);

        // Inicializa os Fragments.
        final List<Fragment> list = new ArrayList<>();
        list.add(new DivCelNivel6Fragment());
        list.add(new DivCelNivel7Fragment());
        list.add(new DivCelNivel8Fragment());
        list.add(new DivCelNivel9Fragment());
        list.add(new DivCelNivel10Fragment());

        textView = findViewById(R.id.textViewQuestaoMeiose);

        // Inicializa o adapter.
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), list);

        // Configura o ViewPager.
        viewPager = findViewById(R.id.viewPagerJogoMeiose);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                globalIndex = i;
                textView.setText("Questão: " + (globalIndex+1) + "/5");
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        /* Configurações dos botões */
        buttonProximo = findViewById(R.id.buttonJogoMeiose);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex < list.size()-1) viewPager.setCurrentItem(++globalIndex);
            }
        });
    }
}
