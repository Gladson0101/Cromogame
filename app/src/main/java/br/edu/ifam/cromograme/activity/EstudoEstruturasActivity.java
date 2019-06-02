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
import br.edu.ifam.cromograme.fragment.DoencasPart1Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart2Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart3Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart4Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart5Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart6Fragment;
import br.edu.ifam.cromograme.fragment.DoencasPart7Fragment;
import br.edu.ifam.cromograme.fragment.EstudoEstrutural1Fragment;
import br.edu.ifam.cromograme.fragment.EstudoEstrutural2Fragment;
import br.edu.ifam.cromograme.fragment.EstudoEstrutural3Fragment;
import br.edu.ifam.cromograme.fragment.EstudoEstrutural4Fragment;
import br.edu.ifam.cromograme.fragment.EstudoEstrutural5Fragment;

public class EstudoEstruturasActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_estudo_estruturas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Alterações Estruturais");

        // Inicializa os Fragments.
        final List<Fragment> list = new ArrayList<>();
        list.add(new EstudoEstrutural1Fragment());
        list.add(new EstudoEstrutural2Fragment());
        list.add(new EstudoEstrutural3Fragment());
        list.add(new EstudoEstrutural4Fragment());
        list.add(new EstudoEstrutural5Fragment());

        // Inicializa o adapter.
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), list);

        // Configura o ViewPager.
        viewPager = findViewById(R.id.viewPagerEstudoEstruturas);
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

                if (globalIndex == list.size() - 1) {
                    buttonProximo.setText("Sair");
                } else {
                    buttonProximo.setText("Próximo");
                }

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        buttonAnterior = findViewById(R.id.buttonEstudoEstruturasAnterior);
        buttonAnterior.setVisibility(View.GONE);
        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex > 0) viewPager.setCurrentItem(--globalIndex);
            }
        });

        buttonProximo = findViewById(R.id.buttonEstudoEstruturasProximo);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalIndex < list.size() - 1) viewPager.setCurrentItem(++globalIndex);
                else if (globalIndex == list.size() - 1) finish();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }
}
