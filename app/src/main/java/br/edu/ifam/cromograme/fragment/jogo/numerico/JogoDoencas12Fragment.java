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
public class JogoDoencas12Fragment extends Fragment {


    public JogoDoencas12Fragment() {
        // Required empty public constructor
    }


    // Imagens do ScrollView
    private ImageView wark_01, wark_02, wark_03, wark_04, wark_05;
    private ImageView wark_06, wark_07, wark_08, wark_09, wark_10;
    private ImageView wark_11, wark_12, wark_13, wark_14, wark_15;
    private ImageView wark_16, wark_17, wark_18, wark_19, wark_20;
    private ImageView wark_21, wark_22, wark_23, wark_24;

    // Imagens de Respostas
    private ImageView imgWar_01, imgWar_02, imgWar_03, imgWar_04, imgWar_05;
    private ImageView imgWar_06, imgWar_07, imgWar_08, imgWar_09, imgWar_10;
    private ImageView imgWar_11, imgWar_12, imgWar_13, imgWar_14, imgWar_15;
    private ImageView imgWar_16, imgWar_17, imgWar_18, imgWar_19, imgWar_20;
    private ImageView imgWar_21, imgWar_22, imgWar_23, imgWar_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas12, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 9/10");

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
                    imgResposta.setImageResource(R.drawable.warkany);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas13Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas13Fragment());
                    dialogFragment.show(transaction, "");
                }
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDica);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.dica_glow);
                builder.setTitle("Dica");
                builder.setMessage("Sem dicas dessa vez!");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean hasClickers() {
        if (imgWar_01.hasOnClickListeners()
                || imgWar_02.hasOnClickListeners()
                || imgWar_03.hasOnClickListeners()
                || imgWar_04.hasOnClickListeners()
                || imgWar_05.hasOnClickListeners()
                || imgWar_06.hasOnClickListeners()
                || imgWar_07.hasOnClickListeners()
                || imgWar_08.hasOnClickListeners()
                || imgWar_09.hasOnClickListeners()
                || imgWar_10.hasOnClickListeners()
                || imgWar_11.hasOnClickListeners()
                || imgWar_12.hasOnClickListeners()
                || imgWar_13.hasOnClickListeners()
                || imgWar_14.hasOnClickListeners()
                || imgWar_15.hasOnClickListeners()
                || imgWar_16.hasOnClickListeners()
                || imgWar_17.hasOnClickListeners()
                || imgWar_18.hasOnClickListeners()
                || imgWar_19.hasOnClickListeners()
                || imgWar_20.hasOnClickListeners()
                || imgWar_21.hasOnClickListeners()
                || imgWar_22.hasOnClickListeners()
                || imgWar_23.hasOnClickListeners()
                || imgWar_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        wark_01 = view.findViewById(R.id.wark_01);
        wark_02 = view.findViewById(R.id.wark_02);
        wark_03 = view.findViewById(R.id.wark_03);
        wark_04 = view.findViewById(R.id.wark_04);
        wark_05 = view.findViewById(R.id.wark_05);
        wark_06 = view.findViewById(R.id.wark_06);
        wark_07 = view.findViewById(R.id.wark_07);
        wark_08 = view.findViewById(R.id.wark_08);
        wark_09 = view.findViewById(R.id.wark_09);
        wark_10 = view.findViewById(R.id.wark_10);
        wark_11 = view.findViewById(R.id.wark_11);
        wark_12 = view.findViewById(R.id.wark_12);
        wark_13 = view.findViewById(R.id.wark_13);
        wark_14 = view.findViewById(R.id.wark_14);
        wark_15 = view.findViewById(R.id.wark_15);
        wark_16 = view.findViewById(R.id.wark_16);
        wark_17 = view.findViewById(R.id.wark_17);
        wark_18 = view.findViewById(R.id.wark_18);
        wark_19 = view.findViewById(R.id.wark_19);
        wark_20 = view.findViewById(R.id.wark_20);
        wark_21 = view.findViewById(R.id.wark_21);
        wark_22 = view.findViewById(R.id.wark_22);
        wark_23 = view.findViewById(R.id.wark_23);
        wark_24 = view.findViewById(R.id.wark_24);

        wark_01.setOnClickListener(clickListenerScrollView);
        wark_02.setOnClickListener(clickListenerScrollView);
        wark_03.setOnClickListener(clickListenerScrollView);
        wark_04.setOnClickListener(clickListenerScrollView);
        wark_05.setOnClickListener(clickListenerScrollView);
        wark_06.setOnClickListener(clickListenerScrollView);
        wark_07.setOnClickListener(clickListenerScrollView);
        wark_08.setOnClickListener(clickListenerScrollView);
        wark_09.setOnClickListener(clickListenerScrollView);
        wark_10.setOnClickListener(clickListenerScrollView);
        wark_11.setOnClickListener(clickListenerScrollView);
        wark_12.setOnClickListener(clickListenerScrollView);
        wark_13.setOnClickListener(clickListenerScrollView);
        wark_14.setOnClickListener(clickListenerScrollView);
        wark_15.setOnClickListener(clickListenerScrollView);
        wark_16.setOnClickListener(clickListenerScrollView);
        wark_17.setOnClickListener(clickListenerScrollView);
        wark_18.setOnClickListener(clickListenerScrollView);
        wark_19.setOnClickListener(clickListenerScrollView);
        wark_20.setOnClickListener(clickListenerScrollView);
        wark_21.setOnClickListener(clickListenerScrollView);
        wark_22.setOnClickListener(clickListenerScrollView);
        wark_23.setOnClickListener(clickListenerScrollView);
        wark_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgWar_01 = view.findViewById(R.id.imgWar_01);
        imgWar_02 = view.findViewById(R.id.imgWar_02);
        imgWar_03 = view.findViewById(R.id.imgWar_03);
        imgWar_04 = view.findViewById(R.id.imgWar_04);
        imgWar_05 = view.findViewById(R.id.imgWar_05);
        imgWar_06 = view.findViewById(R.id.imgWar_06);
        imgWar_07 = view.findViewById(R.id.imgWar_07);
        imgWar_08 = view.findViewById(R.id.imgWar_08);
        imgWar_09 = view.findViewById(R.id.imgWar_09);
        imgWar_10 = view.findViewById(R.id.imgWar_10);
        imgWar_11 = view.findViewById(R.id.imgWar_11);
        imgWar_12 = view.findViewById(R.id.imgWar_12);
        imgWar_13 = view.findViewById(R.id.imgWar_13);
        imgWar_14 = view.findViewById(R.id.imgWar_14);
        imgWar_15 = view.findViewById(R.id.imgWar_15);
        imgWar_16 = view.findViewById(R.id.imgWar_16);
        imgWar_17 = view.findViewById(R.id.imgWar_17);
        imgWar_18 = view.findViewById(R.id.imgWar_18);
        imgWar_19 = view.findViewById(R.id.imgWar_19);
        imgWar_20 = view.findViewById(R.id.imgWar_20);
        imgWar_21 = view.findViewById(R.id.imgWar_21);
        imgWar_22 = view.findViewById(R.id.imgWar_22);
        imgWar_23 = view.findViewById(R.id.imgWar_23);
        imgWar_24 = view.findViewById(R.id.imgWar_24);

        imgWar_01.setOnClickListener(clickListenerResposta);
        imgWar_02.setOnClickListener(clickListenerResposta);
        imgWar_03.setOnClickListener(clickListenerResposta);
        imgWar_04.setOnClickListener(clickListenerResposta);
        imgWar_05.setOnClickListener(clickListenerResposta);
        imgWar_06.setOnClickListener(clickListenerResposta);
        imgWar_07.setOnClickListener(clickListenerResposta);
        imgWar_08.setOnClickListener(clickListenerResposta);
        imgWar_09.setOnClickListener(clickListenerResposta);
        imgWar_10.setOnClickListener(clickListenerResposta);
        imgWar_11.setOnClickListener(clickListenerResposta);
        imgWar_12.setOnClickListener(clickListenerResposta);
        imgWar_13.setOnClickListener(clickListenerResposta);
        imgWar_14.setOnClickListener(clickListenerResposta);
        imgWar_15.setOnClickListener(clickListenerResposta);
        imgWar_16.setOnClickListener(clickListenerResposta);
        imgWar_17.setOnClickListener(clickListenerResposta);
        imgWar_18.setOnClickListener(clickListenerResposta);
        imgWar_19.setOnClickListener(clickListenerResposta);
        imgWar_20.setOnClickListener(clickListenerResposta);
        imgWar_21.setOnClickListener(clickListenerResposta);
        imgWar_22.setOnClickListener(clickListenerResposta);
        imgWar_23.setOnClickListener(clickListenerResposta);
        imgWar_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            wark_01.setBackgroundResource(0);
            wark_02.setBackgroundResource(0);
            wark_03.setBackgroundResource(0);
            wark_04.setBackgroundResource(0);
            wark_05.setBackgroundResource(0);
            wark_06.setBackgroundResource(0);
            wark_07.setBackgroundResource(0);
            wark_08.setBackgroundResource(0);
            wark_09.setBackgroundResource(0);
            wark_10.setBackgroundResource(0);
            wark_11.setBackgroundResource(0);
            wark_12.setBackgroundResource(0);
            wark_13.setBackgroundResource(0);
            wark_14.setBackgroundResource(0);
            wark_15.setBackgroundResource(0);
            wark_16.setBackgroundResource(0);
            wark_17.setBackgroundResource(0);
            wark_18.setBackgroundResource(0);
            wark_19.setBackgroundResource(0);
            wark_20.setBackgroundResource(0);
            wark_21.setBackgroundResource(0);
            wark_22.setBackgroundResource(0);
            wark_23.setBackgroundResource(0);
            wark_24.setBackgroundResource(0);

            wark_01.setSelected(false);
            wark_02.setSelected(false);
            wark_03.setSelected(false);
            wark_04.setSelected(false);
            wark_05.setSelected(false);
            wark_06.setSelected(false);
            wark_07.setSelected(false);
            wark_08.setSelected(false);
            wark_09.setSelected(false);
            wark_10.setSelected(false);
            wark_11.setSelected(false);
            wark_12.setSelected(false);
            wark_13.setSelected(false);
            wark_14.setSelected(false);
            wark_15.setSelected(false);
            wark_16.setSelected(false);
            wark_17.setSelected(false);
            wark_18.setSelected(false);
            wark_19.setSelected(false);
            wark_20.setSelected(false);
            wark_21.setSelected(false);
            wark_22.setSelected(false);
            wark_23.setSelected(false);
            wark_24.setSelected(false);

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
                case R.id.imgWar_01:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_02:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_03:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_04:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_05:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_06:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_07:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_08:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_09:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_10:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_11:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_12:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_13:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_14:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_15:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_16:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_17:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_18:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_19:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_20:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_21:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_22:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_23:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgWar_24:
                    switch (selected) {
                        case R.id.wark_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.wark_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.wark_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
