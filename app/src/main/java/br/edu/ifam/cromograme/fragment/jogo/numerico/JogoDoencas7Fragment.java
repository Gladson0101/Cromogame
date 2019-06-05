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
import br.edu.ifam.cromograme.fragment.WrongAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas7Fragment extends Fragment {


    public JogoDoencas7Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView kli_01, kli_02, kli_03, kli_04, kli_05;
    private ImageView kli_06, kli_07, kli_08, kli_09, kli_10;
    private ImageView kli_11, kli_12, kli_13, kli_14, kli_15;
    private ImageView kli_16, kli_17, kli_18, kli_19, kli_20;
    private ImageView kli_21, kli_22, kli_23, kli_24;

    // Imagens de Respostas
    private ImageView imgKli_01, imgKli_02, imgKli_03, imgKli_04, imgKli_05;
    private ImageView imgKli_06, imgKli_07, imgKli_08, imgKli_09, imgKli_10;
    private ImageView imgKli_11, imgKli_12, imgKli_13, imgKli_14, imgKli_15;
    private ImageView imgKli_16, imgKli_17, imgKli_18, imgKli_19, imgKli_20;
    private ImageView imgKli_21, imgKli_22, imgKli_23, imgKli_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas7, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 4/10");

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
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View viewRoot = inflater.inflate(R.layout.fragment_certo, null);
                    ImageView imgResposta = viewRoot.findViewById(R.id.imgCerto);
                    imgResposta.setImageResource(R.drawable.klinefelter);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas8Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas8Fragment());
                    dialogFragment.show(transaction, "");
                }
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDica);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.dica_glow);
                builder.setTitle("Dica");
                builder.setMessage("Cromossomo extra\nAcomete somente o sexo masculino");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean hasClickers() {
        if (imgKli_01.hasOnClickListeners()
                || imgKli_02.hasOnClickListeners()
                || imgKli_03.hasOnClickListeners()
                || imgKli_04.hasOnClickListeners()
                || imgKli_05.hasOnClickListeners()
                || imgKli_06.hasOnClickListeners()
                || imgKli_07.hasOnClickListeners()
                || imgKli_08.hasOnClickListeners()
                || imgKli_09.hasOnClickListeners()
                || imgKli_10.hasOnClickListeners()
                || imgKli_11.hasOnClickListeners()
                || imgKli_12.hasOnClickListeners()
                || imgKli_13.hasOnClickListeners()
                || imgKli_14.hasOnClickListeners()
                || imgKli_15.hasOnClickListeners()
                || imgKli_16.hasOnClickListeners()
                || imgKli_17.hasOnClickListeners()
                || imgKli_18.hasOnClickListeners()
                || imgKli_19.hasOnClickListeners()
                || imgKli_20.hasOnClickListeners()
                || imgKli_21.hasOnClickListeners()
                || imgKli_22.hasOnClickListeners()
                || imgKli_23.hasOnClickListeners()
                || imgKli_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        kli_01 = view.findViewById(R.id.kli_01);
        kli_02 = view.findViewById(R.id.kli_02);
        kli_03 = view.findViewById(R.id.kli_03);
        kli_04 = view.findViewById(R.id.kli_04);
        kli_05 = view.findViewById(R.id.kli_05);
        kli_06 = view.findViewById(R.id.kli_06);
        kli_07 = view.findViewById(R.id.kli_07);
        kli_08 = view.findViewById(R.id.kli_08);
        kli_09 = view.findViewById(R.id.kli_09);
        kli_10 = view.findViewById(R.id.kli_10);
        kli_11 = view.findViewById(R.id.kli_11);
        kli_12 = view.findViewById(R.id.kli_12);
        kli_13 = view.findViewById(R.id.kli_13);
        kli_14 = view.findViewById(R.id.kli_14);
        kli_15 = view.findViewById(R.id.kli_15);
        kli_16 = view.findViewById(R.id.kli_16);
        kli_17 = view.findViewById(R.id.kli_17);
        kli_18 = view.findViewById(R.id.kli_18);
        kli_19 = view.findViewById(R.id.kli_19);
        kli_20 = view.findViewById(R.id.kli_20);
        kli_21 = view.findViewById(R.id.kli_21);
        kli_22 = view.findViewById(R.id.kli_22);
        kli_23 = view.findViewById(R.id.kli_23);
        kli_24 = view.findViewById(R.id.kli_24);

        kli_01.setOnClickListener(clickListenerScrollView);
        kli_02.setOnClickListener(clickListenerScrollView);
        kli_03.setOnClickListener(clickListenerScrollView);
        kli_04.setOnClickListener(clickListenerScrollView);
        kli_05.setOnClickListener(clickListenerScrollView);
        kli_06.setOnClickListener(clickListenerScrollView);
        kli_07.setOnClickListener(clickListenerScrollView);
        kli_08.setOnClickListener(clickListenerScrollView);
        kli_09.setOnClickListener(clickListenerScrollView);
        kli_10.setOnClickListener(clickListenerScrollView);
        kli_11.setOnClickListener(clickListenerScrollView);
        kli_12.setOnClickListener(clickListenerScrollView);
        kli_13.setOnClickListener(clickListenerScrollView);
        kli_14.setOnClickListener(clickListenerScrollView);
        kli_15.setOnClickListener(clickListenerScrollView);
        kli_16.setOnClickListener(clickListenerScrollView);
        kli_17.setOnClickListener(clickListenerScrollView);
        kli_18.setOnClickListener(clickListenerScrollView);
        kli_19.setOnClickListener(clickListenerScrollView);
        kli_20.setOnClickListener(clickListenerScrollView);
        kli_21.setOnClickListener(clickListenerScrollView);
        kli_22.setOnClickListener(clickListenerScrollView);
        kli_23.setOnClickListener(clickListenerScrollView);
        kli_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgKli_01 = view.findViewById(R.id.imgKli_01);
        imgKli_02 = view.findViewById(R.id.imgKli_02);
        imgKli_03 = view.findViewById(R.id.imgKli_03);
        imgKli_04 = view.findViewById(R.id.imgKli_04);
        imgKli_05 = view.findViewById(R.id.imgKli_05);
        imgKli_06 = view.findViewById(R.id.imgKli_06);
        imgKli_07 = view.findViewById(R.id.imgKli_07);
        imgKli_08 = view.findViewById(R.id.imgKli_08);
        imgKli_09 = view.findViewById(R.id.imgKli_09);
        imgKli_10 = view.findViewById(R.id.imgKli_10);
        imgKli_11 = view.findViewById(R.id.imgKli_11);
        imgKli_12 = view.findViewById(R.id.imgKli_12);
        imgKli_13 = view.findViewById(R.id.imgKli_13);
        imgKli_14 = view.findViewById(R.id.imgKli_14);
        imgKli_15 = view.findViewById(R.id.imgKli_15);
        imgKli_16 = view.findViewById(R.id.imgKli_16);
        imgKli_17 = view.findViewById(R.id.imgKli_17);
        imgKli_18 = view.findViewById(R.id.imgKli_18);
        imgKli_19 = view.findViewById(R.id.imgKli_19);
        imgKli_20 = view.findViewById(R.id.imgKli_20);
        imgKli_21 = view.findViewById(R.id.imgKli_21);
        imgKli_22 = view.findViewById(R.id.imgKli_22);
        imgKli_23 = view.findViewById(R.id.imgKli_23);
        imgKli_24 = view.findViewById(R.id.imgKli_24);

        imgKli_01.setOnClickListener(clickListenerResposta);
        imgKli_02.setOnClickListener(clickListenerResposta);
        imgKli_03.setOnClickListener(clickListenerResposta);
        imgKli_04.setOnClickListener(clickListenerResposta);
        imgKli_05.setOnClickListener(clickListenerResposta);
        imgKli_06.setOnClickListener(clickListenerResposta);
        imgKli_07.setOnClickListener(clickListenerResposta);
        imgKli_08.setOnClickListener(clickListenerResposta);
        imgKli_09.setOnClickListener(clickListenerResposta);
        imgKli_10.setOnClickListener(clickListenerResposta);
        imgKli_11.setOnClickListener(clickListenerResposta);
        imgKli_12.setOnClickListener(clickListenerResposta);
        imgKli_13.setOnClickListener(clickListenerResposta);
        imgKli_14.setOnClickListener(clickListenerResposta);
        imgKli_15.setOnClickListener(clickListenerResposta);
        imgKli_16.setOnClickListener(clickListenerResposta);
        imgKli_17.setOnClickListener(clickListenerResposta);
        imgKli_18.setOnClickListener(clickListenerResposta);
        imgKli_19.setOnClickListener(clickListenerResposta);
        imgKli_20.setOnClickListener(clickListenerResposta);
        imgKli_21.setOnClickListener(clickListenerResposta);
        imgKli_22.setOnClickListener(clickListenerResposta);
        imgKli_23.setOnClickListener(clickListenerResposta);
        imgKli_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kli_01.setBackgroundResource(0);
            kli_02.setBackgroundResource(0);
            kli_03.setBackgroundResource(0);
            kli_04.setBackgroundResource(0);
            kli_05.setBackgroundResource(0);
            kli_06.setBackgroundResource(0);
            kli_07.setBackgroundResource(0);
            kli_08.setBackgroundResource(0);
            kli_09.setBackgroundResource(0);
            kli_10.setBackgroundResource(0);
            kli_11.setBackgroundResource(0);
            kli_12.setBackgroundResource(0);
            kli_13.setBackgroundResource(0);
            kli_14.setBackgroundResource(0);
            kli_15.setBackgroundResource(0);
            kli_16.setBackgroundResource(0);
            kli_17.setBackgroundResource(0);
            kli_18.setBackgroundResource(0);
            kli_19.setBackgroundResource(0);
            kli_20.setBackgroundResource(0);
            kli_21.setBackgroundResource(0);
            kli_22.setBackgroundResource(0);
            kli_23.setBackgroundResource(0);
            kli_24.setBackgroundResource(0);

            kli_01.setSelected(false);
            kli_02.setSelected(false);
            kli_03.setSelected(false);
            kli_04.setSelected(false);
            kli_05.setSelected(false);
            kli_06.setSelected(false);
            kli_07.setSelected(false);
            kli_08.setSelected(false);
            kli_09.setSelected(false);
            kli_10.setSelected(false);
            kli_11.setSelected(false);
            kli_12.setSelected(false);
            kli_13.setSelected(false);
            kli_14.setSelected(false);
            kli_15.setSelected(false);
            kli_16.setSelected(false);
            kli_17.setSelected(false);
            kli_18.setSelected(false);
            kli_19.setSelected(false);
            kli_20.setSelected(false);
            kli_21.setSelected(false);
            kli_22.setSelected(false);
            kli_23.setSelected(false);
            kli_24.setSelected(false);

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
                case R.id.imgKli_01:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_02:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_03:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_04:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_05:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_06:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_07:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_08:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_09:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_10:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_11:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_12:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_13:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_14:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_15:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_16:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_17:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_18:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_19:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_20:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_21:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_22:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_23:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgKli_24:
                    switch (selected) {
                        case R.id.kli_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.kli_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.kli_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
