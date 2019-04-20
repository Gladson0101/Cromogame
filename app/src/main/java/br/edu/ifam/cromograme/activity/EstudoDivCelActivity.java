package br.edu.ifam.cromograme.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.adapter.SliderPagerAdapter;
import br.edu.ifam.cromograme.fragment.MitosePart1Fragment;
import br.edu.ifam.cromograme.fragment.MitosePart2Fragment;
import br.edu.ifam.cromograme.fragment.MitosePart3Fragment;
import br.edu.ifam.cromograme.fragment.MitosePart4Fragment;
import br.edu.ifam.cromograme.fragment.MitosePart5Fragment;
import br.edu.ifam.cromograme.fragment.MitosePart6Fragment;

public class EstudoDivCelActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private Button buttonProximo;
    private Button buttonAnterior;

    private int globalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudo_div_cel);

        // Inicializa os Fragments.
        final List<Fragment> list = new ArrayList<>();
        list.add(new MitosePart1Fragment());
        list.add(new MitosePart2Fragment());
        list.add(new MitosePart3Fragment());
        list.add(new MitosePart4Fragment());
        list.add(new MitosePart5Fragment());
        list.add(new MitosePart6Fragment());

        // Inicializa o adapter.
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), list);

        // Configura o ViewPager.
        viewPager = findViewById(R.id.viewPagerMitose);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                globalIndex = i;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        buttonAnterior = findViewById(R.id.buttonAnterior);
        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex > 0) viewPager.setCurrentItem(--globalIndex);
            }
        });

        buttonProximo = findViewById(R.id.buttonProximo);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex < list.size()-1) viewPager.setCurrentItem(++globalIndex);
            }
        });


    }
}
