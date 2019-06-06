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
public class JogoDoencas11Fragment extends Fragment {


    public JogoDoencas11Fragment() {
        // Required empty public constructor
    }


    // Imagens do ScrollView
    private ImageView olho_01, olho_02, olho_03, olho_04, olho_05;
    private ImageView olho_06, olho_07, olho_08, olho_09, olho_10;
    private ImageView olho_11, olho_12, olho_13, olho_14, olho_15;
    private ImageView olho_16, olho_17, olho_18, olho_19, olho_20;
    private ImageView olho_21, olho_22, olho_23, olho_24;

    // Imagens de Respostas
    private ImageView imgOlho_01, imgOlho_02, imgOlho_03, imgOlho_04, imgOlho_05;
    private ImageView imgOlho_06, imgOlho_07, imgOlho_08, imgOlho_09, imgOlho_10;
    private ImageView imgOlho_11, imgOlho_12, imgOlho_13, imgOlho_14, imgOlho_15;
    private ImageView imgOlho_16, imgOlho_17, imgOlho_18, imgOlho_19, imgOlho_20;
    private ImageView imgOlho_21, imgOlho_22, imgOlho_23, imgOlho_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas11, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 8/10");

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
                    View viewRoot = inflater.inflate(R.layout.fragment_certo_doenca, null);
                    TextView tv = viewRoot.findViewById(R.id.textViewNomeDoenca);
                    tv.setText("Olho de Gato");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.olho_de_gato);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas12Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas12Fragment());
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
        if (imgOlho_01.hasOnClickListeners()
                || imgOlho_02.hasOnClickListeners()
                || imgOlho_03.hasOnClickListeners()
                || imgOlho_04.hasOnClickListeners()
                || imgOlho_05.hasOnClickListeners()
                || imgOlho_06.hasOnClickListeners()
                || imgOlho_07.hasOnClickListeners()
                || imgOlho_08.hasOnClickListeners()
                || imgOlho_09.hasOnClickListeners()
                || imgOlho_10.hasOnClickListeners()
                || imgOlho_11.hasOnClickListeners()
                || imgOlho_12.hasOnClickListeners()
                || imgOlho_13.hasOnClickListeners()
                || imgOlho_14.hasOnClickListeners()
                || imgOlho_15.hasOnClickListeners()
                || imgOlho_16.hasOnClickListeners()
                || imgOlho_17.hasOnClickListeners()
                || imgOlho_18.hasOnClickListeners()
                || imgOlho_19.hasOnClickListeners()
                || imgOlho_20.hasOnClickListeners()
                || imgOlho_21.hasOnClickListeners()
                || imgOlho_22.hasOnClickListeners()
                || imgOlho_23.hasOnClickListeners()
                || imgOlho_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        olho_01 = view.findViewById(R.id.olho_01);
        olho_02 = view.findViewById(R.id.olho_02);
        olho_03 = view.findViewById(R.id.olho_03);
        olho_04 = view.findViewById(R.id.olho_04);
        olho_05 = view.findViewById(R.id.olho_05);
        olho_06 = view.findViewById(R.id.olho_06);
        olho_07 = view.findViewById(R.id.olho_07);
        olho_08 = view.findViewById(R.id.olho_08);
        olho_09 = view.findViewById(R.id.olho_09);
        olho_10 = view.findViewById(R.id.olho_10);
        olho_11 = view.findViewById(R.id.olho_11);
        olho_12 = view.findViewById(R.id.olho_12);
        olho_13 = view.findViewById(R.id.olho_13);
        olho_14 = view.findViewById(R.id.olho_14);
        olho_15 = view.findViewById(R.id.olho_15);
        olho_16 = view.findViewById(R.id.olho_16);
        olho_17 = view.findViewById(R.id.olho_17);
        olho_18 = view.findViewById(R.id.olho_18);
        olho_19 = view.findViewById(R.id.olho_19);
        olho_20 = view.findViewById(R.id.olho_20);
        olho_21 = view.findViewById(R.id.olho_21);
        olho_22 = view.findViewById(R.id.olho_22);
        olho_23 = view.findViewById(R.id.olho_23);
        olho_24 = view.findViewById(R.id.olho_24);

        olho_01.setOnClickListener(clickListenerScrollView);
        olho_02.setOnClickListener(clickListenerScrollView);
        olho_03.setOnClickListener(clickListenerScrollView);
        olho_04.setOnClickListener(clickListenerScrollView);
        olho_05.setOnClickListener(clickListenerScrollView);
        olho_06.setOnClickListener(clickListenerScrollView);
        olho_07.setOnClickListener(clickListenerScrollView);
        olho_08.setOnClickListener(clickListenerScrollView);
        olho_09.setOnClickListener(clickListenerScrollView);
        olho_10.setOnClickListener(clickListenerScrollView);
        olho_11.setOnClickListener(clickListenerScrollView);
        olho_12.setOnClickListener(clickListenerScrollView);
        olho_13.setOnClickListener(clickListenerScrollView);
        olho_14.setOnClickListener(clickListenerScrollView);
        olho_15.setOnClickListener(clickListenerScrollView);
        olho_16.setOnClickListener(clickListenerScrollView);
        olho_17.setOnClickListener(clickListenerScrollView);
        olho_18.setOnClickListener(clickListenerScrollView);
        olho_19.setOnClickListener(clickListenerScrollView);
        olho_20.setOnClickListener(clickListenerScrollView);
        olho_21.setOnClickListener(clickListenerScrollView);
        olho_22.setOnClickListener(clickListenerScrollView);
        olho_23.setOnClickListener(clickListenerScrollView);
        olho_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgOlho_01 = view.findViewById(R.id.imgOlho_01);
        imgOlho_02 = view.findViewById(R.id.imgOlho_02);
        imgOlho_03 = view.findViewById(R.id.imgOlho_03);
        imgOlho_04 = view.findViewById(R.id.imgOlho_04);
        imgOlho_05 = view.findViewById(R.id.imgOlho_05);
        imgOlho_06 = view.findViewById(R.id.imgOlho_06);
        imgOlho_07 = view.findViewById(R.id.imgOlho_07);
        imgOlho_08 = view.findViewById(R.id.imgOlho_08);
        imgOlho_09 = view.findViewById(R.id.imgOlho_09);
        imgOlho_10 = view.findViewById(R.id.imgOlho_10);
        imgOlho_11 = view.findViewById(R.id.imgOlho_11);
        imgOlho_12 = view.findViewById(R.id.imgOlho_12);
        imgOlho_13 = view.findViewById(R.id.imgOlho_13);
        imgOlho_14 = view.findViewById(R.id.imgOlho_14);
        imgOlho_15 = view.findViewById(R.id.imgOlho_15);
        imgOlho_16 = view.findViewById(R.id.imgOlho_16);
        imgOlho_17 = view.findViewById(R.id.imgOlho_17);
        imgOlho_18 = view.findViewById(R.id.imgOlho_18);
        imgOlho_19 = view.findViewById(R.id.imgOlho_19);
        imgOlho_20 = view.findViewById(R.id.imgOlho_20);
        imgOlho_21 = view.findViewById(R.id.imgOlho_21);
        imgOlho_22 = view.findViewById(R.id.imgOlho_22);
        imgOlho_23 = view.findViewById(R.id.imgOlho_23);
        imgOlho_24 = view.findViewById(R.id.imgOlho_24);

        imgOlho_01.setOnClickListener(clickListenerResposta);
        imgOlho_02.setOnClickListener(clickListenerResposta);
        imgOlho_03.setOnClickListener(clickListenerResposta);
        imgOlho_04.setOnClickListener(clickListenerResposta);
        imgOlho_05.setOnClickListener(clickListenerResposta);
        imgOlho_06.setOnClickListener(clickListenerResposta);
        imgOlho_07.setOnClickListener(clickListenerResposta);
        imgOlho_08.setOnClickListener(clickListenerResposta);
        imgOlho_09.setOnClickListener(clickListenerResposta);
        imgOlho_10.setOnClickListener(clickListenerResposta);
        imgOlho_11.setOnClickListener(clickListenerResposta);
        imgOlho_12.setOnClickListener(clickListenerResposta);
        imgOlho_13.setOnClickListener(clickListenerResposta);
        imgOlho_14.setOnClickListener(clickListenerResposta);
        imgOlho_15.setOnClickListener(clickListenerResposta);
        imgOlho_16.setOnClickListener(clickListenerResposta);
        imgOlho_17.setOnClickListener(clickListenerResposta);
        imgOlho_18.setOnClickListener(clickListenerResposta);
        imgOlho_19.setOnClickListener(clickListenerResposta);
        imgOlho_20.setOnClickListener(clickListenerResposta);
        imgOlho_21.setOnClickListener(clickListenerResposta);
        imgOlho_22.setOnClickListener(clickListenerResposta);
        imgOlho_23.setOnClickListener(clickListenerResposta);
        imgOlho_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            olho_01.setBackgroundResource(0);
            olho_02.setBackgroundResource(0);
            olho_03.setBackgroundResource(0);
            olho_04.setBackgroundResource(0);
            olho_05.setBackgroundResource(0);
            olho_06.setBackgroundResource(0);
            olho_07.setBackgroundResource(0);
            olho_08.setBackgroundResource(0);
            olho_09.setBackgroundResource(0);
            olho_10.setBackgroundResource(0);
            olho_11.setBackgroundResource(0);
            olho_12.setBackgroundResource(0);
            olho_13.setBackgroundResource(0);
            olho_14.setBackgroundResource(0);
            olho_15.setBackgroundResource(0);
            olho_16.setBackgroundResource(0);
            olho_17.setBackgroundResource(0);
            olho_18.setBackgroundResource(0);
            olho_19.setBackgroundResource(0);
            olho_20.setBackgroundResource(0);
            olho_21.setBackgroundResource(0);
            olho_22.setBackgroundResource(0);
            olho_23.setBackgroundResource(0);
            olho_24.setBackgroundResource(0);

            olho_01.setSelected(false);
            olho_02.setSelected(false);
            olho_03.setSelected(false);
            olho_04.setSelected(false);
            olho_05.setSelected(false);
            olho_06.setSelected(false);
            olho_07.setSelected(false);
            olho_08.setSelected(false);
            olho_09.setSelected(false);
            olho_10.setSelected(false);
            olho_11.setSelected(false);
            olho_12.setSelected(false);
            olho_13.setSelected(false);
            olho_14.setSelected(false);
            olho_15.setSelected(false);
            olho_16.setSelected(false);
            olho_17.setSelected(false);
            olho_18.setSelected(false);
            olho_19.setSelected(false);
            olho_20.setSelected(false);
            olho_21.setSelected(false);
            olho_22.setSelected(false);
            olho_23.setSelected(false);
            olho_24.setSelected(false);

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
                case R.id.imgOlho_01:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_02:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_03:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_04:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_05:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_06:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_07:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_08:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_09:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_10:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_11:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_12:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_13:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_14:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_15:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_16:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_17:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_18:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_19:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_20:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_21:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_22:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_23:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgOlho_24:
                    switch (selected) {
                        case R.id.olho_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.olho_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.olho_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
