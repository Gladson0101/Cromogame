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
import br.edu.ifam.cromograme.fragment.DivCelNivel1Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel2Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel3Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel4Fragment;
import br.edu.ifam.cromograme.fragment.DivCelNivel5Fragment;

public class JogoMitoseActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private TextView textView;

    private Button buttonProximo;

    private int globalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_mitose);

        // Inicializa os Fragments.
        final List<Fragment> list = new ArrayList<>();

        DivCelNivel1Fragment n1 = new DivCelNivel1Fragment();
        DivCelNivel2Fragment n2 = new DivCelNivel2Fragment();
        DivCelNivel3Fragment n3 = new DivCelNivel3Fragment();
        DivCelNivel4Fragment n4 = new DivCelNivel4Fragment();
        DivCelNivel5Fragment n5 = new DivCelNivel5Fragment();

        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);

        textView = findViewById(R.id.textViewQuestaoMitose);


        // Inicializa o adapter.
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), list);

        // Configura o ViewPager.
        viewPager = findViewById(R.id.viewPagerJogoMitose);
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
        buttonProximo = findViewById(R.id.buttonJogoMitose);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex < list.size()-1) viewPager.setCurrentItem(++globalIndex);
            }
        });
    }
}
