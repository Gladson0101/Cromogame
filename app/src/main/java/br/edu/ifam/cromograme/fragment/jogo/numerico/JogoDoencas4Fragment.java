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
import br.edu.ifam.cromograme.fragment.jogo.estrutura.JogoEstrutura1Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas4Fragment extends Fragment {


    public JogoDoencas4Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView ed_01, ed_02, ed_03, ed_04, ed_05;
    private ImageView ed_06, ed_07, ed_08, ed_09, ed_10;
    private ImageView ed_11, ed_12, ed_13, ed_14, ed_15;
    private ImageView ed_16, ed_17, ed_18, ed_19, ed_20;
    private ImageView ed_21, ed_22, ed_23, ed_24;

    // Imagens de Respostas
    private ImageView imgEd_01, imgEd_02, imgEd_03, imgEd_04, imgEd_05;
    private ImageView imgEd_06, imgEd_07, imgEd_08, imgEd_09, imgEd_10;
    private ImageView imgEd_11, imgEd_12, imgEd_13, imgEd_14, imgEd_15;
    private ImageView imgEd_16, imgEd_17, imgEd_18, imgEd_19, imgEd_20;
    private ImageView imgEd_21, imgEd_22, imgEd_23, imgEd_24;

    // Variável de controle
    private boolean acertou = true;
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas4, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 1/10");

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
                    tv.setText("Edwards");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.edwards);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas5Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas5Fragment());
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
                builder.setMessage("É uma trissomia\nOrelhas mal formadas");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean hasClickers() {
        if (imgEd_01.hasOnClickListeners()
                || imgEd_02.hasOnClickListeners()
                || imgEd_03.hasOnClickListeners()
                || imgEd_04.hasOnClickListeners()
                || imgEd_05.hasOnClickListeners()
                || imgEd_06.hasOnClickListeners()
                || imgEd_07.hasOnClickListeners()
                || imgEd_08.hasOnClickListeners()
                || imgEd_09.hasOnClickListeners()
                || imgEd_10.hasOnClickListeners()
                || imgEd_11.hasOnClickListeners()
                || imgEd_12.hasOnClickListeners()
                || imgEd_13.hasOnClickListeners()
                || imgEd_14.hasOnClickListeners()
                || imgEd_15.hasOnClickListeners()
                || imgEd_16.hasOnClickListeners()
                || imgEd_17.hasOnClickListeners()
                || imgEd_18.hasOnClickListeners()
                || imgEd_19.hasOnClickListeners()
                || imgEd_20.hasOnClickListeners()
                || imgEd_21.hasOnClickListeners()
                || imgEd_22.hasOnClickListeners()
                || imgEd_23.hasOnClickListeners()
                || imgEd_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        ed_01 = view.findViewById(R.id.ed_01);
        ed_02 = view.findViewById(R.id.ed_02);
        ed_03 = view.findViewById(R.id.ed_03);
        ed_04 = view.findViewById(R.id.ed_04);
        ed_05 = view.findViewById(R.id.ed_05);
        ed_06 = view.findViewById(R.id.ed_06);
        ed_07 = view.findViewById(R.id.ed_07);
        ed_08 = view.findViewById(R.id.ed_08);
        ed_09 = view.findViewById(R.id.ed_09);
        ed_10 = view.findViewById(R.id.ed_10);
        ed_11 = view.findViewById(R.id.ed_11);
        ed_12 = view.findViewById(R.id.ed_12);
        ed_13 = view.findViewById(R.id.ed_13);
        ed_14 = view.findViewById(R.id.ed_14);
        ed_15 = view.findViewById(R.id.ed_15);
        ed_16 = view.findViewById(R.id.ed_16);
        ed_17 = view.findViewById(R.id.ed_17);
        ed_18 = view.findViewById(R.id.ed_18);
        ed_19 = view.findViewById(R.id.ed_19);
        ed_20 = view.findViewById(R.id.ed_20);
        ed_21 = view.findViewById(R.id.ed_21);
        ed_22 = view.findViewById(R.id.ed_22);
        ed_23 = view.findViewById(R.id.ed_23);
        ed_24 = view.findViewById(R.id.ed_24);

        ed_01.setOnClickListener(clickListenerScrollView);
        ed_02.setOnClickListener(clickListenerScrollView);
        ed_03.setOnClickListener(clickListenerScrollView);
        ed_04.setOnClickListener(clickListenerScrollView);
        ed_05.setOnClickListener(clickListenerScrollView);
        ed_06.setOnClickListener(clickListenerScrollView);
        ed_07.setOnClickListener(clickListenerScrollView);
        ed_08.setOnClickListener(clickListenerScrollView);
        ed_09.setOnClickListener(clickListenerScrollView);
        ed_10.setOnClickListener(clickListenerScrollView);
        ed_11.setOnClickListener(clickListenerScrollView);
        ed_12.setOnClickListener(clickListenerScrollView);
        ed_13.setOnClickListener(clickListenerScrollView);
        ed_14.setOnClickListener(clickListenerScrollView);
        ed_15.setOnClickListener(clickListenerScrollView);
        ed_16.setOnClickListener(clickListenerScrollView);
        ed_17.setOnClickListener(clickListenerScrollView);
        ed_18.setOnClickListener(clickListenerScrollView);
        ed_19.setOnClickListener(clickListenerScrollView);
        ed_20.setOnClickListener(clickListenerScrollView);
        ed_21.setOnClickListener(clickListenerScrollView);
        ed_22.setOnClickListener(clickListenerScrollView);
        ed_23.setOnClickListener(clickListenerScrollView);
        ed_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgEd_01 = view.findViewById(R.id.imgEd_01);
        imgEd_02 = view.findViewById(R.id.imgEd_02);
        imgEd_03 = view.findViewById(R.id.imgEd_03);
        imgEd_04 = view.findViewById(R.id.imgEd_04);
        imgEd_05 = view.findViewById(R.id.imgEd_05);
        imgEd_06 = view.findViewById(R.id.imgEd_06);
        imgEd_07 = view.findViewById(R.id.imgEd_07);
        imgEd_08 = view.findViewById(R.id.imgEd_08);
        imgEd_09 = view.findViewById(R.id.imgEd_09);
        imgEd_10 = view.findViewById(R.id.imgEd_10);
        imgEd_11 = view.findViewById(R.id.imgEd_11);
        imgEd_12 = view.findViewById(R.id.imgEd_12);
        imgEd_13 = view.findViewById(R.id.imgEd_13);
        imgEd_14 = view.findViewById(R.id.imgEd_14);
        imgEd_15 = view.findViewById(R.id.imgEd_15);
        imgEd_16 = view.findViewById(R.id.imgEd_16);
        imgEd_17 = view.findViewById(R.id.imgEd_17);
        imgEd_18 = view.findViewById(R.id.imgEd_18);
        imgEd_19 = view.findViewById(R.id.imgEd_19);
        imgEd_20 = view.findViewById(R.id.imgEd_20);
        imgEd_21 = view.findViewById(R.id.imgEd_21);
        imgEd_22 = view.findViewById(R.id.imgEd_22);
        imgEd_23 = view.findViewById(R.id.imgEd_23);
        imgEd_24 = view.findViewById(R.id.imgEd_24);

        imgEd_01.setOnClickListener(clickListenerResposta);
        imgEd_02.setOnClickListener(clickListenerResposta);
        imgEd_03.setOnClickListener(clickListenerResposta);
        imgEd_04.setOnClickListener(clickListenerResposta);
        imgEd_05.setOnClickListener(clickListenerResposta);
        imgEd_06.setOnClickListener(clickListenerResposta);
        imgEd_07.setOnClickListener(clickListenerResposta);
        imgEd_08.setOnClickListener(clickListenerResposta);
        imgEd_09.setOnClickListener(clickListenerResposta);
        imgEd_10.setOnClickListener(clickListenerResposta);
        imgEd_11.setOnClickListener(clickListenerResposta);
        imgEd_12.setOnClickListener(clickListenerResposta);
        imgEd_13.setOnClickListener(clickListenerResposta);
        imgEd_14.setOnClickListener(clickListenerResposta);
        imgEd_15.setOnClickListener(clickListenerResposta);
        imgEd_16.setOnClickListener(clickListenerResposta);
        imgEd_17.setOnClickListener(clickListenerResposta);
        imgEd_18.setOnClickListener(clickListenerResposta);
        imgEd_19.setOnClickListener(clickListenerResposta);
        imgEd_20.setOnClickListener(clickListenerResposta);
        imgEd_21.setOnClickListener(clickListenerResposta);
        imgEd_22.setOnClickListener(clickListenerResposta);
        imgEd_23.setOnClickListener(clickListenerResposta);
        imgEd_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ed_01.setBackgroundResource(0);
            ed_02.setBackgroundResource(0);
            ed_03.setBackgroundResource(0);
            ed_04.setBackgroundResource(0);
            ed_05.setBackgroundResource(0);
            ed_06.setBackgroundResource(0);
            ed_07.setBackgroundResource(0);
            ed_08.setBackgroundResource(0);
            ed_09.setBackgroundResource(0);
            ed_10.setBackgroundResource(0);
            ed_11.setBackgroundResource(0);
            ed_12.setBackgroundResource(0);
            ed_13.setBackgroundResource(0);
            ed_14.setBackgroundResource(0);
            ed_15.setBackgroundResource(0);
            ed_16.setBackgroundResource(0);
            ed_17.setBackgroundResource(0);
            ed_18.setBackgroundResource(0);
            ed_19.setBackgroundResource(0);
            ed_20.setBackgroundResource(0);
            ed_21.setBackgroundResource(0);
            ed_22.setBackgroundResource(0);
            ed_23.setBackgroundResource(0);
            ed_24.setBackgroundResource(0);

            ed_01.setSelected(false);
            ed_02.setSelected(false);
            ed_03.setSelected(false);
            ed_04.setSelected(false);
            ed_05.setSelected(false);
            ed_06.setSelected(false);
            ed_07.setSelected(false);
            ed_08.setSelected(false);
            ed_09.setSelected(false);
            ed_10.setSelected(false);
            ed_11.setSelected(false);
            ed_12.setSelected(false);
            ed_13.setSelected(false);
            ed_14.setSelected(false);
            ed_15.setSelected(false);
            ed_16.setSelected(false);
            ed_17.setSelected(false);
            ed_18.setSelected(false);
            ed_19.setSelected(false);
            ed_20.setSelected(false);
            ed_21.setSelected(false);
            ed_22.setSelected(false);
            ed_23.setSelected(false);
            ed_24.setSelected(false);

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
                case R.id.imgEd_01:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_02:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_03:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_04:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_05:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_06:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_07:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_08:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_09:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_10:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_11:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_12:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_13:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_14:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_15:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_16:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_17:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_18:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_19:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_20:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_21:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_22:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_23:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                    }
                    selected = 0;
                    break;
                case R.id.imgEd_24:
                    switch (selected) {
                        case R.id.ed_01:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_01);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_02:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_02);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_03:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_03);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_04:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_04);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_05:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_05);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_06:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_06);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_07:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_07);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_08:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_08);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_09:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_09);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_10:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_10);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_11:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_11);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_12:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_12);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_13:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_13);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_14:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_14);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_15:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_15);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_16:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_16);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_17:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_17);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_18:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_18);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_19:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_19);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_20:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_20);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_21:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_21);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_22:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_22);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_23:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_23);
                            iv.setOnClickListener(null);
                            acertou = false;
                            break;
                        case R.id.ed_24:
                            viewSelected.setVisibility(View.GONE);
                            iv.setImageResource(R.drawable.ed_24);
                            iv.setOnClickListener(null);
                            break;
                    }
                    selected = 0;
                    break;
            }
        }
    };

}
