package br.edu.ifam.cromograme.fragment.jogo.estrutura;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.WrongLastAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoEstrutura0Fragment extends Fragment {


    public JogoEstrutura0Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView car_01, car_02, car_03, car_04, car_05;
    private ImageView car_06, car_07, car_08, car_09, car_10;
    private ImageView car_11, car_12, car_13, car_14, car_15;
    private ImageView car_16, car_17, car_18, car_19, car_20;
    private ImageView car_21, car_22, car_23, car_24;

    // Imagens de Respostas
    private ImageView imgCar_01, imgCar_02, imgCar_03, imgCar_04, imgCar_05;
    private ImageView imgCar_06, imgCar_07, imgCar_08, imgCar_09, imgCar_10;
    private ImageView imgCar_11, imgCar_12, imgCar_13, imgCar_14, imgCar_15;
    private ImageView imgCar_16, imgCar_17, imgCar_18, imgCar_19, imgCar_20;
    private ImageView imgCar_21, imgCar_22, imgCar_23, imgCar_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura0, container, false);

        initImgScrollView(view);
        initImgResposta(view);

        Button buttonDesistir = getActivity().findViewById(R.id.buttonHumanoDesistir);
        buttonDesistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Desistir");
                builder.setMessage("Deseja mesmo desistir?");
                builder.setCancelable(false);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton("Não", null);
                builder.create().show();
            }
        });

        Button button = getActivity().findViewById(R.id.buttonHumanoConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (acertou && !hasClickers()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View viewRoot = inflater.inflate(R.layout.fragment_certo, null);
                    ImageView imgResposta = viewRoot.findViewById(R.id.imgCerto);
                    imgResposta.setImageResource(R.drawable.cariotipo_normal);
                    builder.setView(viewRoot);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongLastAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    dialogFragment.show(transaction, "");
                }


            }
        });

        return view;
    }

    private boolean hasClickers() {
        if (imgCar_01.hasOnClickListeners()
                || imgCar_02.hasOnClickListeners()
                || imgCar_03.hasOnClickListeners()
                || imgCar_04.hasOnClickListeners()
                || imgCar_05.hasOnClickListeners()
                || imgCar_06.hasOnClickListeners()
                || imgCar_07.hasOnClickListeners()
                || imgCar_08.hasOnClickListeners()
                || imgCar_09.hasOnClickListeners()
                || imgCar_10.hasOnClickListeners()
                || imgCar_11.hasOnClickListeners()
                || imgCar_12.hasOnClickListeners()
                || imgCar_13.hasOnClickListeners()
                || imgCar_14.hasOnClickListeners()
                || imgCar_15.hasOnClickListeners()
                || imgCar_16.hasOnClickListeners()
                || imgCar_17.hasOnClickListeners()
                || imgCar_18.hasOnClickListeners()
                || imgCar_19.hasOnClickListeners()
                || imgCar_20.hasOnClickListeners()
                || imgCar_21.hasOnClickListeners()
                || imgCar_22.hasOnClickListeners()
                || imgCar_23.hasOnClickListeners()
                || imgCar_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        car_01 = view.findViewById(R.id.car_01);
        car_02 = view.findViewById(R.id.car_02);
        car_03 = view.findViewById(R.id.car_03);
        car_04 = view.findViewById(R.id.car_04);
        car_05 = view.findViewById(R.id.car_05);
        car_06 = view.findViewById(R.id.car_06);
        car_07 = view.findViewById(R.id.car_07);
        car_08 = view.findViewById(R.id.car_08);
        car_09 = view.findViewById(R.id.car_09);
        car_10 = view.findViewById(R.id.car_10);
        car_11 = view.findViewById(R.id.car_11);
        car_12 = view.findViewById(R.id.car_12);
        car_13 = view.findViewById(R.id.car_13);
        car_14 = view.findViewById(R.id.car_14);
        car_15 = view.findViewById(R.id.car_15);
        car_16 = view.findViewById(R.id.car_16);
        car_17 = view.findViewById(R.id.car_17);
        car_18 = view.findViewById(R.id.car_18);
        car_19 = view.findViewById(R.id.car_19);
        car_20 = view.findViewById(R.id.car_20);
        car_21 = view.findViewById(R.id.car_21);
        car_22 = view.findViewById(R.id.car_22);
        car_23 = view.findViewById(R.id.car_23);
        car_24 = view.findViewById(R.id.car_24);

        car_01.setOnClickListener(clickListenerScrollView);
        car_02.setOnClickListener(clickListenerScrollView);
        car_03.setOnClickListener(clickListenerScrollView);
        car_04.setOnClickListener(clickListenerScrollView);
        car_05.setOnClickListener(clickListenerScrollView);
        car_06.setOnClickListener(clickListenerScrollView);
        car_07.setOnClickListener(clickListenerScrollView);
        car_08.setOnClickListener(clickListenerScrollView);
        car_09.setOnClickListener(clickListenerScrollView);
        car_10.setOnClickListener(clickListenerScrollView);
        car_11.setOnClickListener(clickListenerScrollView);
        car_12.setOnClickListener(clickListenerScrollView);
        car_13.setOnClickListener(clickListenerScrollView);
        car_14.setOnClickListener(clickListenerScrollView);
        car_15.setOnClickListener(clickListenerScrollView);
        car_16.setOnClickListener(clickListenerScrollView);
        car_17.setOnClickListener(clickListenerScrollView);
        car_18.setOnClickListener(clickListenerScrollView);
        car_19.setOnClickListener(clickListenerScrollView);
        car_20.setOnClickListener(clickListenerScrollView);
        car_21.setOnClickListener(clickListenerScrollView);
        car_22.setOnClickListener(clickListenerScrollView);
        car_23.setOnClickListener(clickListenerScrollView);
        car_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgCar_01 = view.findViewById(R.id.imgCar_01);
        imgCar_02 = view.findViewById(R.id.imgCar_02);
        imgCar_03 = view.findViewById(R.id.imgCar_03);
        imgCar_04 = view.findViewById(R.id.imgCar_04);
        imgCar_05 = view.findViewById(R.id.imgCar_05);
        imgCar_06 = view.findViewById(R.id.imgCar_06);
        imgCar_07 = view.findViewById(R.id.imgCar_07);
        imgCar_08 = view.findViewById(R.id.imgCar_08);
        imgCar_09 = view.findViewById(R.id.imgCar_09);
        imgCar_10 = view.findViewById(R.id.imgCar_10);
        imgCar_11 = view.findViewById(R.id.imgCar_11);
        imgCar_12 = view.findViewById(R.id.imgCar_12);
        imgCar_13 = view.findViewById(R.id.imgCar_13);
        imgCar_14 = view.findViewById(R.id.imgCar_14);
        imgCar_15 = view.findViewById(R.id.imgCar_15);
        imgCar_16 = view.findViewById(R.id.imgCar_16);
        imgCar_17 = view.findViewById(R.id.imgCar_17);
        imgCar_18 = view.findViewById(R.id.imgCar_18);
        imgCar_19 = view.findViewById(R.id.imgCar_19);
        imgCar_20 = view.findViewById(R.id.imgCar_20);
        imgCar_21 = view.findViewById(R.id.imgCar_21);
        imgCar_22 = view.findViewById(R.id.imgCar_22);
        imgCar_23 = view.findViewById(R.id.imgCar_23);
        imgCar_24 = view.findViewById(R.id.imgCar_24);

        imgCar_01.setOnClickListener(clickListenerResposta);
        imgCar_02.setOnClickListener(clickListenerResposta);
        imgCar_03.setOnClickListener(clickListenerResposta);
        imgCar_04.setOnClickListener(clickListenerResposta);
        imgCar_05.setOnClickListener(clickListenerResposta);
        imgCar_06.setOnClickListener(clickListenerResposta);
        imgCar_07.setOnClickListener(clickListenerResposta);
        imgCar_08.setOnClickListener(clickListenerResposta);
        imgCar_09.setOnClickListener(clickListenerResposta);
        imgCar_10.setOnClickListener(clickListenerResposta);
        imgCar_11.setOnClickListener(clickListenerResposta);
        imgCar_12.setOnClickListener(clickListenerResposta);
        imgCar_13.setOnClickListener(clickListenerResposta);
        imgCar_14.setOnClickListener(clickListenerResposta);
        imgCar_15.setOnClickListener(clickListenerResposta);
        imgCar_16.setOnClickListener(clickListenerResposta);
        imgCar_17.setOnClickListener(clickListenerResposta);
        imgCar_18.setOnClickListener(clickListenerResposta);
        imgCar_19.setOnClickListener(clickListenerResposta);
        imgCar_20.setOnClickListener(clickListenerResposta);
        imgCar_21.setOnClickListener(clickListenerResposta);
        imgCar_22.setOnClickListener(clickListenerResposta);
        imgCar_23.setOnClickListener(clickListenerResposta);
        imgCar_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            car_01.setBackgroundResource(0);
            car_02.setBackgroundResource(0);
            car_03.setBackgroundResource(0);
            car_04.setBackgroundResource(0);
            car_05.setBackgroundResource(0);
            car_06.setBackgroundResource(0);
            car_07.setBackgroundResource(0);
            car_08.setBackgroundResource(0);
            car_09.setBackgroundResource(0);
            car_10.setBackgroundResource(0);
            car_11.setBackgroundResource(0);
            car_12.setBackgroundResource(0);
            car_13.setBackgroundResource(0);
            car_14.setBackgroundResource(0);
            car_15.setBackgroundResource(0);
            car_16.setBackgroundResource(0);
            car_17.setBackgroundResource(0);
            car_18.setBackgroundResource(0);
            car_19.setBackgroundResource(0);
            car_20.setBackgroundResource(0);
            car_21.setBackgroundResource(0);
            car_22.setBackgroundResource(0);
            car_23.setBackgroundResource(0);
            car_24.setBackgroundResource(0);

            car_01.setSelected(false);
            car_02.setSelected(false);
            car_03.setSelected(false);
            car_04.setSelected(false);
            car_05.setSelected(false);
            car_06.setSelected(false);
            car_07.setSelected(false);
            car_08.setSelected(false);
            car_09.setSelected(false);
            car_10.setSelected(false);
            car_11.setSelected(false);
            car_12.setSelected(false);
            car_13.setSelected(false);
            car_14.setSelected(false);
            car_15.setSelected(false);
            car_16.setSelected(false);
            car_17.setSelected(false);
            car_18.setSelected(false);
            car_19.setSelected(false);
            car_20.setSelected(false);
            car_21.setSelected(false);
            car_22.setSelected(false);
            car_23.setSelected(false);
            car_24.setSelected(false);

            v.setBackgroundResource(R.color.colorPrimary);
            v.setSelected(true);

            viewSelected = v;
            selected = v.getId();
        }
    };

    View.OnClickListener clickListenerResposta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ImageView iv = (ImageView) v;

            switch (v.getId()) {
                case R.id.imgCar_01:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_02:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_03:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_04:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_05:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_06:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_07:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_08:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_09:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_10:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_11:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_12:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_13:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_14:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_15:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_16:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_17:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_18:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_19:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_20:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_21:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_22:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_23:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgCar_24:
                    switch (selected) {
                        case R.id.car_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.car_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.car_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
