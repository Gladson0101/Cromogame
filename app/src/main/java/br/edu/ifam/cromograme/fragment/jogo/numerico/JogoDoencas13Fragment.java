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
public class JogoDoencas13Fragment extends Fragment {


    public JogoDoencas13Fragment() {
        // Required empty public constructor
    }


    // Imagens do ScrollView
    private ImageView tri9_01, tri9_02, tri9_03, tri9_04, tri9_05;
    private ImageView tri9_06, tri9_07, tri9_08, tri9_09, tri9_10;
    private ImageView tri9_11, tri9_12, tri9_13, tri9_14, tri9_15;
    private ImageView tri9_16, tri9_17, tri9_18, tri9_19, tri9_20;
    private ImageView tri9_21, tri9_22, tri9_23, tri9_24;

    // Imagens de Respostas
    private ImageView imgTri9_01, imgTri9_02, imgTri9_03, imgTri9_04, imgTri9_05;
    private ImageView imgTri9_06, imgTri9_07, imgTri9_08, imgTri9_09, imgTri9_10;
    private ImageView imgTri9_11, imgTri9_12, imgTri9_13, imgTri9_14, imgTri9_15;
    private ImageView imgTri9_16, imgTri9_17, imgTri9_18, imgTri9_19, imgTri9_20;
    private ImageView imgTri9_21, imgTri9_22, imgTri9_23, imgTri9_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas13, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 10/10");

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
                    tv.setText("Trissomia do 9");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.trissomia_9);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
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
        if (imgTri9_01.hasOnClickListeners()
                || imgTri9_02.hasOnClickListeners()
                || imgTri9_03.hasOnClickListeners()
                || imgTri9_04.hasOnClickListeners()
                || imgTri9_05.hasOnClickListeners()
                || imgTri9_06.hasOnClickListeners()
                || imgTri9_07.hasOnClickListeners()
                || imgTri9_08.hasOnClickListeners()
                || imgTri9_09.hasOnClickListeners()
                || imgTri9_10.hasOnClickListeners()
                || imgTri9_11.hasOnClickListeners()
                || imgTri9_12.hasOnClickListeners()
                || imgTri9_13.hasOnClickListeners()
                || imgTri9_14.hasOnClickListeners()
                || imgTri9_15.hasOnClickListeners()
                || imgTri9_16.hasOnClickListeners()
                || imgTri9_17.hasOnClickListeners()
                || imgTri9_18.hasOnClickListeners()
                || imgTri9_19.hasOnClickListeners()
                || imgTri9_20.hasOnClickListeners()
                || imgTri9_21.hasOnClickListeners()
                || imgTri9_22.hasOnClickListeners()
                || imgTri9_23.hasOnClickListeners()
                || imgTri9_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        tri9_01 = view.findViewById(R.id.tri9_01);
        tri9_02 = view.findViewById(R.id.tri9_02);
        tri9_03 = view.findViewById(R.id.tri9_03);
        tri9_04 = view.findViewById(R.id.tri9_04);
        tri9_05 = view.findViewById(R.id.tri9_05);
        tri9_06 = view.findViewById(R.id.tri9_06);
        tri9_07 = view.findViewById(R.id.tri9_07);
        tri9_08 = view.findViewById(R.id.tri9_08);
        tri9_09 = view.findViewById(R.id.tri9_09);
        tri9_10 = view.findViewById(R.id.tri9_10);
        tri9_11 = view.findViewById(R.id.tri9_11);
        tri9_12 = view.findViewById(R.id.tri9_12);
        tri9_13 = view.findViewById(R.id.tri9_13);
        tri9_14 = view.findViewById(R.id.tri9_14);
        tri9_15 = view.findViewById(R.id.tri9_15);
        tri9_16 = view.findViewById(R.id.tri9_16);
        tri9_17 = view.findViewById(R.id.tri9_17);
        tri9_18 = view.findViewById(R.id.tri9_18);
        tri9_19 = view.findViewById(R.id.tri9_19);
        tri9_20 = view.findViewById(R.id.tri9_20);
        tri9_21 = view.findViewById(R.id.tri9_21);
        tri9_22 = view.findViewById(R.id.tri9_22);
        tri9_23 = view.findViewById(R.id.tri9_23);
        tri9_24 = view.findViewById(R.id.tri9_24);

        tri9_01.setOnClickListener(clickListenerScrollView);
        tri9_02.setOnClickListener(clickListenerScrollView);
        tri9_03.setOnClickListener(clickListenerScrollView);
        tri9_04.setOnClickListener(clickListenerScrollView);
        tri9_05.setOnClickListener(clickListenerScrollView);
        tri9_06.setOnClickListener(clickListenerScrollView);
        tri9_07.setOnClickListener(clickListenerScrollView);
        tri9_08.setOnClickListener(clickListenerScrollView);
        tri9_09.setOnClickListener(clickListenerScrollView);
        tri9_10.setOnClickListener(clickListenerScrollView);
        tri9_11.setOnClickListener(clickListenerScrollView);
        tri9_12.setOnClickListener(clickListenerScrollView);
        tri9_13.setOnClickListener(clickListenerScrollView);
        tri9_14.setOnClickListener(clickListenerScrollView);
        tri9_15.setOnClickListener(clickListenerScrollView);
        tri9_16.setOnClickListener(clickListenerScrollView);
        tri9_17.setOnClickListener(clickListenerScrollView);
        tri9_18.setOnClickListener(clickListenerScrollView);
        tri9_19.setOnClickListener(clickListenerScrollView);
        tri9_20.setOnClickListener(clickListenerScrollView);
        tri9_21.setOnClickListener(clickListenerScrollView);
        tri9_22.setOnClickListener(clickListenerScrollView);
        tri9_23.setOnClickListener(clickListenerScrollView);
        tri9_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgTri9_01 = view.findViewById(R.id.imgTri9_01);
        imgTri9_02 = view.findViewById(R.id.imgTri9_02);
        imgTri9_03 = view.findViewById(R.id.imgTri9_03);
        imgTri9_04 = view.findViewById(R.id.imgTri9_04);
        imgTri9_05 = view.findViewById(R.id.imgTri9_05);
        imgTri9_06 = view.findViewById(R.id.imgTri9_06);
        imgTri9_07 = view.findViewById(R.id.imgTri9_07);
        imgTri9_08 = view.findViewById(R.id.imgTri9_08);
        imgTri9_09 = view.findViewById(R.id.imgTri9_09);
        imgTri9_10 = view.findViewById(R.id.imgTri9_10);
        imgTri9_11 = view.findViewById(R.id.imgTri9_11);
        imgTri9_12 = view.findViewById(R.id.imgTri9_12);
        imgTri9_13 = view.findViewById(R.id.imgTri9_13);
        imgTri9_14 = view.findViewById(R.id.imgTri9_14);
        imgTri9_15 = view.findViewById(R.id.imgTri9_15);
        imgTri9_16 = view.findViewById(R.id.imgTri9_16);
        imgTri9_17 = view.findViewById(R.id.imgTri9_17);
        imgTri9_18 = view.findViewById(R.id.imgTri9_18);
        imgTri9_19 = view.findViewById(R.id.imgTri9_19);
        imgTri9_20 = view.findViewById(R.id.imgTri9_20);
        imgTri9_21 = view.findViewById(R.id.imgTri9_21);
        imgTri9_22 = view.findViewById(R.id.imgTri9_22);
        imgTri9_23 = view.findViewById(R.id.imgTri9_23);
        imgTri9_24 = view.findViewById(R.id.imgTri9_24);

        imgTri9_01.setOnClickListener(clickListenerResposta);
        imgTri9_02.setOnClickListener(clickListenerResposta);
        imgTri9_03.setOnClickListener(clickListenerResposta);
        imgTri9_04.setOnClickListener(clickListenerResposta);
        imgTri9_05.setOnClickListener(clickListenerResposta);
        imgTri9_06.setOnClickListener(clickListenerResposta);
        imgTri9_07.setOnClickListener(clickListenerResposta);
        imgTri9_08.setOnClickListener(clickListenerResposta);
        imgTri9_09.setOnClickListener(clickListenerResposta);
        imgTri9_10.setOnClickListener(clickListenerResposta);
        imgTri9_11.setOnClickListener(clickListenerResposta);
        imgTri9_12.setOnClickListener(clickListenerResposta);
        imgTri9_13.setOnClickListener(clickListenerResposta);
        imgTri9_14.setOnClickListener(clickListenerResposta);
        imgTri9_15.setOnClickListener(clickListenerResposta);
        imgTri9_16.setOnClickListener(clickListenerResposta);
        imgTri9_17.setOnClickListener(clickListenerResposta);
        imgTri9_18.setOnClickListener(clickListenerResposta);
        imgTri9_19.setOnClickListener(clickListenerResposta);
        imgTri9_20.setOnClickListener(clickListenerResposta);
        imgTri9_21.setOnClickListener(clickListenerResposta);
        imgTri9_22.setOnClickListener(clickListenerResposta);
        imgTri9_23.setOnClickListener(clickListenerResposta);
        imgTri9_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tri9_01.setBackgroundResource(0);
            tri9_02.setBackgroundResource(0);
            tri9_03.setBackgroundResource(0);
            tri9_04.setBackgroundResource(0);
            tri9_05.setBackgroundResource(0);
            tri9_06.setBackgroundResource(0);
            tri9_07.setBackgroundResource(0);
            tri9_08.setBackgroundResource(0);
            tri9_09.setBackgroundResource(0);
            tri9_10.setBackgroundResource(0);
            tri9_11.setBackgroundResource(0);
            tri9_12.setBackgroundResource(0);
            tri9_13.setBackgroundResource(0);
            tri9_14.setBackgroundResource(0);
            tri9_15.setBackgroundResource(0);
            tri9_16.setBackgroundResource(0);
            tri9_17.setBackgroundResource(0);
            tri9_18.setBackgroundResource(0);
            tri9_19.setBackgroundResource(0);
            tri9_20.setBackgroundResource(0);
            tri9_21.setBackgroundResource(0);
            tri9_22.setBackgroundResource(0);
            tri9_23.setBackgroundResource(0);
            tri9_24.setBackgroundResource(0);

            tri9_01.setSelected(false);
            tri9_02.setSelected(false);
            tri9_03.setSelected(false);
            tri9_04.setSelected(false);
            tri9_05.setSelected(false);
            tri9_06.setSelected(false);
            tri9_07.setSelected(false);
            tri9_08.setSelected(false);
            tri9_09.setSelected(false);
            tri9_10.setSelected(false);
            tri9_11.setSelected(false);
            tri9_12.setSelected(false);
            tri9_13.setSelected(false);
            tri9_14.setSelected(false);
            tri9_15.setSelected(false);
            tri9_16.setSelected(false);
            tri9_17.setSelected(false);
            tri9_18.setSelected(false);
            tri9_19.setSelected(false);
            tri9_20.setSelected(false);
            tri9_21.setSelected(false);
            tri9_22.setSelected(false);
            tri9_23.setSelected(false);
            tri9_24.setSelected(false);

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
                case R.id.imgTri9_01:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_02:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_03:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_04:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_05:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_06:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_07:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_08:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_09:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_10:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_11:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_12:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_13:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_14:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_15:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_16:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_17:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_18:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_19:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_20:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_21:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_22:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_23:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgTri9_24:
                    switch (selected) {
                        case R.id.tri9_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.tri9_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.tri9_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
