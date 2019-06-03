package br.edu.ifam.cromograme.fragment.jogo.numerico;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.CorrectAlertFragment;
import br.edu.ifam.cromograme.fragment.CorrectLastAlertFragment;
import br.edu.ifam.cromograme.fragment.WrongAlertFragment;
import br.edu.ifam.cromograme.fragment.WrongLastAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas10Fragment extends Fragment {


    public JogoDoencas10Fragment() {
        // Required empty public constructor
    }


    // Imagens do ScrollView
    private ImageView down_01, down_02, down_03, down_04, down_05;
    private ImageView down_06, down_07, down_08, down_09, down_10;
    private ImageView down_11, down_12, down_13, down_14, down_15;
    private ImageView down_16, down_17, down_18, down_19, down_20;
    private ImageView down_21, down_22, down_23, down_24;

    // Imagens de Respostas
    private ImageView imgDown_01, imgDown_02, imgDown_03, imgDown_04, imgDown_05;
    private ImageView imgDown_06, imgDown_07, imgDown_08, imgDown_09, imgDown_10;
    private ImageView imgDown_11, imgDown_12, imgDown_13, imgDown_14, imgDown_15;
    private ImageView imgDown_16, imgDown_17, imgDown_18, imgDown_19, imgDown_20;
    private ImageView imgDown_21, imgDown_22, imgDown_23, imgDown_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas10, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 7/10");

        initImgScrollView(view);
        initImgResposta(view);

        Button buttonDesistir = getActivity().findViewById(R.id.buttonJogoDoencasDesistir);
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

        Button button = getActivity().findViewById(R.id.buttonJogoDoencasConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (acertou && !hasClickers()) {
                    DialogFragment dialogFragment = new CorrectAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    dialogFragment.show(transaction, "");
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    dialogFragment.show(transaction, "");
                }

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas12Fragment());
                transaction.commit();
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDica);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.dica_glow);
                builder.setTitle("Dica");
                builder.setMessage("Cabelos lisos\nDificuldade na fala");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean hasClickers() {
        if (imgDown_01.hasOnClickListeners()
                || imgDown_02.hasOnClickListeners()
                || imgDown_03.hasOnClickListeners()
                || imgDown_04.hasOnClickListeners()
                || imgDown_05.hasOnClickListeners()
                || imgDown_06.hasOnClickListeners()
                || imgDown_07.hasOnClickListeners()
                || imgDown_08.hasOnClickListeners()
                || imgDown_09.hasOnClickListeners()
                || imgDown_10.hasOnClickListeners()
                || imgDown_11.hasOnClickListeners()
                || imgDown_12.hasOnClickListeners()
                || imgDown_13.hasOnClickListeners()
                || imgDown_14.hasOnClickListeners()
                || imgDown_15.hasOnClickListeners()
                || imgDown_16.hasOnClickListeners()
                || imgDown_17.hasOnClickListeners()
                || imgDown_18.hasOnClickListeners()
                || imgDown_19.hasOnClickListeners()
                || imgDown_20.hasOnClickListeners()
                || imgDown_21.hasOnClickListeners()
                || imgDown_22.hasOnClickListeners()
                || imgDown_23.hasOnClickListeners()
                || imgDown_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        down_01 = view.findViewById(R.id.down_01);
        down_02 = view.findViewById(R.id.down_02);
        down_03 = view.findViewById(R.id.down_03);
        down_04 = view.findViewById(R.id.down_04);
        down_05 = view.findViewById(R.id.down_05);
        down_06 = view.findViewById(R.id.down_06);
        down_07 = view.findViewById(R.id.down_07);
        down_08 = view.findViewById(R.id.down_08);
        down_09 = view.findViewById(R.id.down_09);
        down_10 = view.findViewById(R.id.down_10);
        down_11 = view.findViewById(R.id.down_11);
        down_12 = view.findViewById(R.id.down_12);
        down_13 = view.findViewById(R.id.down_13);
        down_14 = view.findViewById(R.id.down_14);
        down_15 = view.findViewById(R.id.down_15);
        down_16 = view.findViewById(R.id.down_16);
        down_17 = view.findViewById(R.id.down_17);
        down_18 = view.findViewById(R.id.down_18);
        down_19 = view.findViewById(R.id.down_19);
        down_20 = view.findViewById(R.id.down_20);
        down_21 = view.findViewById(R.id.down_21);
        down_22 = view.findViewById(R.id.down_22);
        down_23 = view.findViewById(R.id.down_23);
        down_24 = view.findViewById(R.id.down_24);

        down_01.setOnClickListener(clickListenerScrollView);
        down_02.setOnClickListener(clickListenerScrollView);
        down_03.setOnClickListener(clickListenerScrollView);
        down_04.setOnClickListener(clickListenerScrollView);
        down_05.setOnClickListener(clickListenerScrollView);
        down_06.setOnClickListener(clickListenerScrollView);
        down_07.setOnClickListener(clickListenerScrollView);
        down_08.setOnClickListener(clickListenerScrollView);
        down_09.setOnClickListener(clickListenerScrollView);
        down_10.setOnClickListener(clickListenerScrollView);
        down_11.setOnClickListener(clickListenerScrollView);
        down_12.setOnClickListener(clickListenerScrollView);
        down_13.setOnClickListener(clickListenerScrollView);
        down_14.setOnClickListener(clickListenerScrollView);
        down_15.setOnClickListener(clickListenerScrollView);
        down_16.setOnClickListener(clickListenerScrollView);
        down_17.setOnClickListener(clickListenerScrollView);
        down_18.setOnClickListener(clickListenerScrollView);
        down_19.setOnClickListener(clickListenerScrollView);
        down_20.setOnClickListener(clickListenerScrollView);
        down_21.setOnClickListener(clickListenerScrollView);
        down_22.setOnClickListener(clickListenerScrollView);
        down_23.setOnClickListener(clickListenerScrollView);
        down_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgDown_01 = view.findViewById(R.id.imgDown_01);
        imgDown_02 = view.findViewById(R.id.imgDown_02);
        imgDown_03 = view.findViewById(R.id.imgDown_03);
        imgDown_04 = view.findViewById(R.id.imgDown_04);
        imgDown_05 = view.findViewById(R.id.imgDown_05);
        imgDown_06 = view.findViewById(R.id.imgDown_06);
        imgDown_07 = view.findViewById(R.id.imgDown_07);
        imgDown_08 = view.findViewById(R.id.imgDown_08);
        imgDown_09 = view.findViewById(R.id.imgDown_09);
        imgDown_10 = view.findViewById(R.id.imgDown_10);
        imgDown_11 = view.findViewById(R.id.imgDown_11);
        imgDown_12 = view.findViewById(R.id.imgDown_12);
        imgDown_13 = view.findViewById(R.id.imgDown_13);
        imgDown_14 = view.findViewById(R.id.imgDown_14);
        imgDown_15 = view.findViewById(R.id.imgDown_15);
        imgDown_16 = view.findViewById(R.id.imgDown_16);
        imgDown_17 = view.findViewById(R.id.imgDown_17);
        imgDown_18 = view.findViewById(R.id.imgDown_18);
        imgDown_19 = view.findViewById(R.id.imgDown_19);
        imgDown_20 = view.findViewById(R.id.imgDown_20);
        imgDown_21 = view.findViewById(R.id.imgDown_21);
        imgDown_22 = view.findViewById(R.id.imgDown_22);
        imgDown_23 = view.findViewById(R.id.imgDown_23);
        imgDown_24 = view.findViewById(R.id.imgDown_24);

        imgDown_01.setOnClickListener(clickListenerResposta);
        imgDown_02.setOnClickListener(clickListenerResposta);
        imgDown_03.setOnClickListener(clickListenerResposta);
        imgDown_04.setOnClickListener(clickListenerResposta);
        imgDown_05.setOnClickListener(clickListenerResposta);
        imgDown_06.setOnClickListener(clickListenerResposta);
        imgDown_07.setOnClickListener(clickListenerResposta);
        imgDown_08.setOnClickListener(clickListenerResposta);
        imgDown_09.setOnClickListener(clickListenerResposta);
        imgDown_10.setOnClickListener(clickListenerResposta);
        imgDown_11.setOnClickListener(clickListenerResposta);
        imgDown_12.setOnClickListener(clickListenerResposta);
        imgDown_13.setOnClickListener(clickListenerResposta);
        imgDown_14.setOnClickListener(clickListenerResposta);
        imgDown_15.setOnClickListener(clickListenerResposta);
        imgDown_16.setOnClickListener(clickListenerResposta);
        imgDown_17.setOnClickListener(clickListenerResposta);
        imgDown_18.setOnClickListener(clickListenerResposta);
        imgDown_19.setOnClickListener(clickListenerResposta);
        imgDown_20.setOnClickListener(clickListenerResposta);
        imgDown_21.setOnClickListener(clickListenerResposta);
        imgDown_22.setOnClickListener(clickListenerResposta);
        imgDown_23.setOnClickListener(clickListenerResposta);
        imgDown_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            down_01.setBackgroundResource(0);
            down_02.setBackgroundResource(0);
            down_03.setBackgroundResource(0);
            down_04.setBackgroundResource(0);
            down_05.setBackgroundResource(0);
            down_06.setBackgroundResource(0);
            down_07.setBackgroundResource(0);
            down_08.setBackgroundResource(0);
            down_09.setBackgroundResource(0);
            down_10.setBackgroundResource(0);
            down_11.setBackgroundResource(0);
            down_12.setBackgroundResource(0);
            down_13.setBackgroundResource(0);
            down_14.setBackgroundResource(0);
            down_15.setBackgroundResource(0);
            down_16.setBackgroundResource(0);
            down_17.setBackgroundResource(0);
            down_18.setBackgroundResource(0);
            down_19.setBackgroundResource(0);
            down_20.setBackgroundResource(0);
            down_21.setBackgroundResource(0);
            down_22.setBackgroundResource(0);
            down_23.setBackgroundResource(0);
            down_24.setBackgroundResource(0);

            down_01.setSelected(false);
            down_02.setSelected(false);
            down_03.setSelected(false);
            down_04.setSelected(false);
            down_05.setSelected(false);
            down_06.setSelected(false);
            down_07.setSelected(false);
            down_08.setSelected(false);
            down_09.setSelected(false);
            down_10.setSelected(false);
            down_11.setSelected(false);
            down_12.setSelected(false);
            down_13.setSelected(false);
            down_14.setSelected(false);
            down_15.setSelected(false);
            down_16.setSelected(false);
            down_17.setSelected(false);
            down_18.setSelected(false);
            down_19.setSelected(false);
            down_20.setSelected(false);
            down_21.setSelected(false);
            down_22.setSelected(false);
            down_23.setSelected(false);
            down_24.setSelected(false);

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
                case R.id.imgDown_01:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_02:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_03:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_04:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_05:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_06:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_07:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_08:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_09:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_10:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_11:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_12:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_13:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_14:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_15:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_16:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_17:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_18:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_19:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_20:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_21:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_22:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_23:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgDown_24:
                    switch (selected) {
                        case R.id.down_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.down_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.down_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}


