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
public class JogoDoencas8Fragment extends Fragment {


    public JogoDoencas8Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView jac_01, jac_02, jac_03, jac_04, jac_05;
    private ImageView jac_06, jac_07, jac_08, jac_09, jac_10;
    private ImageView jac_11, jac_12, jac_13, jac_14, jac_15;
    private ImageView jac_16, jac_17, jac_18, jac_19, jac_20;
    private ImageView jac_21, jac_22, jac_23, jac_24;

    // Imagens de Respostas
    private ImageView imgJac_01, imgJac_02, imgJac_03, imgJac_04, imgJac_05;
    private ImageView imgJac_06, imgJac_07, imgJac_08, imgJac_09, imgJac_10;
    private ImageView imgJac_11, imgJac_12, imgJac_13, imgJac_14, imgJac_15;
    private ImageView imgJac_16, imgJac_17, imgJac_18, imgJac_19, imgJac_20;
    private ImageView imgJac_21, imgJac_22, imgJac_23, imgJac_24;

    // Variável de controle
    private int selected = 0;
    private View viewSelected = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas8, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 5/10");

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

                if (acertou() && !hasClickers()) {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View viewRoot = inflater.inflate(R.layout.fragment_certo_doenca, null);
                    TextView tv = viewRoot.findViewById(R.id.textViewNomeDoenca);
                    tv.setText("Jacob");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.jacob);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas9Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas9Fragment());
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
                builder.setMessage("Um cromossomo extra\nOcorrência no sexo masculino.");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean acertou() {
        if (imgJac_01.getDrawable().equals(R.drawable.jac_01)
                && imgJac_02.getDrawable().equals(R.drawable.jac_02)
                && imgJac_03.getDrawable().equals(R.drawable.jac_03)
                && imgJac_04.getDrawable().equals(R.drawable.jac_04)
                && imgJac_05.getDrawable().equals(R.drawable.jac_05)
                && imgJac_06.getDrawable().equals(R.drawable.jac_06)
                && imgJac_07.getDrawable().equals(R.drawable.jac_07)
                && imgJac_08.getDrawable().equals(R.drawable.jac_08)
                && imgJac_09.getDrawable().equals(R.drawable.jac_09)
                && imgJac_10.getDrawable().equals(R.drawable.jac_10)
                && imgJac_11.getDrawable().equals(R.drawable.jac_11)
                && imgJac_12.getDrawable().equals(R.drawable.jac_12)
                && imgJac_13.getDrawable().equals(R.drawable.jac_13)
                && imgJac_14.getDrawable().equals(R.drawable.jac_14)
                && imgJac_15.getDrawable().equals(R.drawable.jac_15)
                && imgJac_16.getDrawable().equals(R.drawable.jac_16)
                && imgJac_17.getDrawable().equals(R.drawable.jac_17)
                && imgJac_18.getDrawable().equals(R.drawable.jac_18)
                && imgJac_19.getDrawable().equals(R.drawable.jac_19)
                && imgJac_20.getDrawable().equals(R.drawable.jac_20)
                && imgJac_21.getDrawable().equals(R.drawable.jac_21)
                && imgJac_22.getDrawable().equals(R.drawable.jac_22)
                && imgJac_23.getDrawable().equals(R.drawable.jac_23)
                && imgJac_24.getDrawable().equals(R.drawable.jac_24)) return true;
        else return false;
    }

    private boolean hasClickers() {
        if (imgJac_01.hasOnClickListeners()
                || imgJac_02.hasOnClickListeners()
                || imgJac_03.hasOnClickListeners()
                || imgJac_04.hasOnClickListeners()
                || imgJac_05.hasOnClickListeners()
                || imgJac_06.hasOnClickListeners()
                || imgJac_07.hasOnClickListeners()
                || imgJac_08.hasOnClickListeners()
                || imgJac_09.hasOnClickListeners()
                || imgJac_10.hasOnClickListeners()
                || imgJac_11.hasOnClickListeners()
                || imgJac_12.hasOnClickListeners()
                || imgJac_13.hasOnClickListeners()
                || imgJac_14.hasOnClickListeners()
                || imgJac_15.hasOnClickListeners()
                || imgJac_16.hasOnClickListeners()
                || imgJac_17.hasOnClickListeners()
                || imgJac_18.hasOnClickListeners()
                || imgJac_19.hasOnClickListeners()
                || imgJac_20.hasOnClickListeners()
                || imgJac_21.hasOnClickListeners()
                || imgJac_22.hasOnClickListeners()
                || imgJac_23.hasOnClickListeners()
                || imgJac_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        jac_01 = view.findViewById(R.id.jac_01);
        jac_02 = view.findViewById(R.id.jac_02);
        jac_03 = view.findViewById(R.id.jac_03);
        jac_04 = view.findViewById(R.id.jac_04);
        jac_05 = view.findViewById(R.id.jac_05);
        jac_06 = view.findViewById(R.id.jac_06);
        jac_07 = view.findViewById(R.id.jac_07);
        jac_08 = view.findViewById(R.id.jac_08);
        jac_09 = view.findViewById(R.id.jac_09);
        jac_10 = view.findViewById(R.id.jac_10);
        jac_11 = view.findViewById(R.id.jac_11);
        jac_12 = view.findViewById(R.id.jac_12);
        jac_13 = view.findViewById(R.id.jac_13);
        jac_14 = view.findViewById(R.id.jac_14);
        jac_15 = view.findViewById(R.id.jac_15);
        jac_16 = view.findViewById(R.id.jac_16);
        jac_17 = view.findViewById(R.id.jac_17);
        jac_18 = view.findViewById(R.id.jac_18);
        jac_19 = view.findViewById(R.id.jac_19);
        jac_20 = view.findViewById(R.id.jac_20);
        jac_21 = view.findViewById(R.id.jac_21);
        jac_22 = view.findViewById(R.id.jac_22);
        jac_23 = view.findViewById(R.id.jac_23);
        jac_24 = view.findViewById(R.id.jac_24);

        jac_01.setOnClickListener(clickListenerScrollView);
        jac_02.setOnClickListener(clickListenerScrollView);
        jac_03.setOnClickListener(clickListenerScrollView);
        jac_04.setOnClickListener(clickListenerScrollView);
        jac_05.setOnClickListener(clickListenerScrollView);
        jac_06.setOnClickListener(clickListenerScrollView);
        jac_07.setOnClickListener(clickListenerScrollView);
        jac_08.setOnClickListener(clickListenerScrollView);
        jac_09.setOnClickListener(clickListenerScrollView);
        jac_10.setOnClickListener(clickListenerScrollView);
        jac_11.setOnClickListener(clickListenerScrollView);
        jac_12.setOnClickListener(clickListenerScrollView);
        jac_13.setOnClickListener(clickListenerScrollView);
        jac_14.setOnClickListener(clickListenerScrollView);
        jac_15.setOnClickListener(clickListenerScrollView);
        jac_16.setOnClickListener(clickListenerScrollView);
        jac_17.setOnClickListener(clickListenerScrollView);
        jac_18.setOnClickListener(clickListenerScrollView);
        jac_19.setOnClickListener(clickListenerScrollView);
        jac_20.setOnClickListener(clickListenerScrollView);
        jac_21.setOnClickListener(clickListenerScrollView);
        jac_22.setOnClickListener(clickListenerScrollView);
        jac_23.setOnClickListener(clickListenerScrollView);
        jac_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgJac_01 = view.findViewById(R.id.imgJac_01);
        imgJac_02 = view.findViewById(R.id.imgJac_02);
        imgJac_03 = view.findViewById(R.id.imgJac_03);
        imgJac_04 = view.findViewById(R.id.imgJac_04);
        imgJac_05 = view.findViewById(R.id.imgJac_05);
        imgJac_06 = view.findViewById(R.id.imgJac_06);
        imgJac_07 = view.findViewById(R.id.imgJac_07);
        imgJac_08 = view.findViewById(R.id.imgJac_08);
        imgJac_09 = view.findViewById(R.id.imgJac_09);
        imgJac_10 = view.findViewById(R.id.imgJac_10);
        imgJac_11 = view.findViewById(R.id.imgJac_11);
        imgJac_12 = view.findViewById(R.id.imgJac_12);
        imgJac_13 = view.findViewById(R.id.imgJac_13);
        imgJac_14 = view.findViewById(R.id.imgJac_14);
        imgJac_15 = view.findViewById(R.id.imgJac_15);
        imgJac_16 = view.findViewById(R.id.imgJac_16);
        imgJac_17 = view.findViewById(R.id.imgJac_17);
        imgJac_18 = view.findViewById(R.id.imgJac_18);
        imgJac_19 = view.findViewById(R.id.imgJac_19);
        imgJac_20 = view.findViewById(R.id.imgJac_20);
        imgJac_21 = view.findViewById(R.id.imgJac_21);
        imgJac_22 = view.findViewById(R.id.imgJac_22);
        imgJac_23 = view.findViewById(R.id.imgJac_23);
        imgJac_24 = view.findViewById(R.id.imgJac_24);

        imgJac_01.setOnClickListener(clickListenerResposta);
        imgJac_02.setOnClickListener(clickListenerResposta);
        imgJac_03.setOnClickListener(clickListenerResposta);
        imgJac_04.setOnClickListener(clickListenerResposta);
        imgJac_05.setOnClickListener(clickListenerResposta);
        imgJac_06.setOnClickListener(clickListenerResposta);
        imgJac_07.setOnClickListener(clickListenerResposta);
        imgJac_08.setOnClickListener(clickListenerResposta);
        imgJac_09.setOnClickListener(clickListenerResposta);
        imgJac_10.setOnClickListener(clickListenerResposta);
        imgJac_11.setOnClickListener(clickListenerResposta);
        imgJac_12.setOnClickListener(clickListenerResposta);
        imgJac_13.setOnClickListener(clickListenerResposta);
        imgJac_14.setOnClickListener(clickListenerResposta);
        imgJac_15.setOnClickListener(clickListenerResposta);
        imgJac_16.setOnClickListener(clickListenerResposta);
        imgJac_17.setOnClickListener(clickListenerResposta);
        imgJac_18.setOnClickListener(clickListenerResposta);
        imgJac_19.setOnClickListener(clickListenerResposta);
        imgJac_20.setOnClickListener(clickListenerResposta);
        imgJac_21.setOnClickListener(clickListenerResposta);
        imgJac_22.setOnClickListener(clickListenerResposta);
        imgJac_23.setOnClickListener(clickListenerResposta);
        imgJac_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            jac_01.setBackgroundResource(0);
            jac_02.setBackgroundResource(0);
            jac_03.setBackgroundResource(0);
            jac_04.setBackgroundResource(0);
            jac_05.setBackgroundResource(0);
            jac_06.setBackgroundResource(0);
            jac_07.setBackgroundResource(0);
            jac_08.setBackgroundResource(0);
            jac_09.setBackgroundResource(0);
            jac_10.setBackgroundResource(0);
            jac_11.setBackgroundResource(0);
            jac_12.setBackgroundResource(0);
            jac_13.setBackgroundResource(0);
            jac_14.setBackgroundResource(0);
            jac_15.setBackgroundResource(0);
            jac_16.setBackgroundResource(0);
            jac_17.setBackgroundResource(0);
            jac_18.setBackgroundResource(0);
            jac_19.setBackgroundResource(0);
            jac_20.setBackgroundResource(0);
            jac_21.setBackgroundResource(0);
            jac_22.setBackgroundResource(0);
            jac_23.setBackgroundResource(0);
            jac_24.setBackgroundResource(0);

            jac_01.setSelected(false);
            jac_02.setSelected(false);
            jac_03.setSelected(false);
            jac_04.setSelected(false);
            jac_05.setSelected(false);
            jac_06.setSelected(false);
            jac_07.setSelected(false);
            jac_08.setSelected(false);
            jac_09.setSelected(false);
            jac_10.setSelected(false);
            jac_11.setSelected(false);
            jac_12.setSelected(false);
            jac_13.setSelected(false);
            jac_14.setSelected(false);
            jac_15.setSelected(false);
            jac_16.setSelected(false);
            jac_17.setSelected(false);
            jac_18.setSelected(false);
            jac_19.setSelected(false);
            jac_20.setSelected(false);
            jac_21.setSelected(false);
            jac_22.setSelected(false);
            jac_23.setSelected(false);
            jac_24.setSelected(false);

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

            switch (selected) {
                case R.id.jac_01:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_01);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_02:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_02);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_03:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_03);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_04:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_04);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_05:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_05);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_06:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_06);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_07:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_07);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_08:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_08);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_09:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_09);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_10:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_10);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_11:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_11);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_12:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_12);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_13:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_13);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_14:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_14);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_15:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_15);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_16:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_16);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_17:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_17);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_18:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_18);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_19:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_19);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_20:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_20);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_21:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_21);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_22:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_22);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_23:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_23);
                    iv.setOnClickListener(null);
                    break;
                case R.id.jac_24:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.jac_24);
                    iv.setOnClickListener(null);
                    break;
            }
            selected = 0;
        }
    };
}