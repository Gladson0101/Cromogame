package br.edu.ifam.cromograme.activity;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.adapter.SliderPagerAdapter;
import br.edu.ifam.cromograme.fragment.estudo.cromossomo.CromossomoPart1Fragment;
import br.edu.ifam.cromograme.fragment.estudo.cromossomo.CromossomoPart2Fragment;
import br.edu.ifam.cromograme.fragment.estudo.cromossomo.CromossomoPart3Fragment;
import br.edu.ifam.cromograme.fragment.estudo.cromossomo.CromossomoPart4Fragment;
import br.edu.ifam.cromograme.fragment.estudo.cromossomo.CromossomoPart5Fragment;

public class EstudoCromossomoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private Button buttonProximo;
    private Button buttonAnterior;

    private int globalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_estudo_cromossomo);

        getSupportActionBar().setTitle("Cromossomos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inicializa os Fragments.
        final List<Fragment> list = new ArrayList<>();
        list.add(new CromossomoPart1Fragment());
        list.add(new CromossomoPart2Fragment());
        list.add(new CromossomoPart3Fragment());
        list.add(new CromossomoPart4Fragment());
        list.add(new CromossomoPart5Fragment());

        // Inicializa o adapter.
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), list);

        // Configura o ViewPager.
        viewPager = findViewById(R.id.viewPagerEstudoCromossomo);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                globalIndex = i;

                if (globalIndex == 0) {
                    buttonAnterior.setVisibility(View.GONE);
                } else {
                    buttonAnterior.setVisibility(View.VISIBLE);
                }

                if (globalIndex == list.size()-1) {
                    buttonProximo.setText("Sair");
                    buttonProximo.setBackgroundResource(R.drawable.button_red_rounded);
                } else {
                    buttonProximo.setText("Próximo");
                    buttonProximo.setBackgroundResource(R.drawable.button_blue_rounded);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        /* Configurações dos botões */
        buttonAnterior = findViewById(R.id.buttonEstudoCromossomoAnterior);
        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex > 0) viewPager.setCurrentItem(--globalIndex);

            }
        });

        buttonProximo = findViewById(R.id.buttonEstudoCromossomoProximo);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex < list.size()-1) viewPager.setCurrentItem(++globalIndex);
                else if (globalIndex == list.size()-1) finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }
}
