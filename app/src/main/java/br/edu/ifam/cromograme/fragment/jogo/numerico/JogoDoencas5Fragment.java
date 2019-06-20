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
public class JogoDoencas5Fragment extends Fragment {


    public JogoDoencas5Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView tur_01, tur_02, tur_03, tur_04, tur_05;
    private ImageView tur_06, tur_07, tur_08, tur_09, tur_10;
    private ImageView tur_11, tur_12, tur_13, tur_14, tur_15;
    private ImageView tur_16, tur_17, tur_18, tur_19, tur_20;
    private ImageView tur_21, tur_22, tur_23;

    // Imagens de Respostas
    private ImageView imgTur_01, imgTur_02, imgTur_03, imgTur_04, imgTur_05;
    private ImageView imgTur_06, imgTur_07, imgTur_08, imgTur_09, imgTur_10;
    private ImageView imgTur_11, imgTur_12, imgTur_13, imgTur_14, imgTur_15;
    private ImageView imgTur_16, imgTur_17, imgTur_18, imgTur_19, imgTur_20;
    private ImageView imgTur_21, imgTur_22, imgTur_23, imgTur_24;

    // Variável de controle
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas5, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 2/10");

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
                    tv.setText("Turner");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.turner);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas6Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas6Fragment());
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
                builder.setMessage("Ausência de um cromossomo\nAfeta apenas o sexo feminino");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean acertou() {
        if (imgTur_01.getDrawable().equals(R.drawable.tur_01)
                && imgTur_02.getDrawable().equals(R.drawable.tur_02)
                && imgTur_03.getDrawable().equals(R.drawable.tur_03)
                && imgTur_04.getDrawable().equals(R.drawable.tur_04)
                && imgTur_05.getDrawable().equals(R.drawable.tur_05)
                && imgTur_06.getDrawable().equals(R.drawable.tur_06)
                && imgTur_07.getDrawable().equals(R.drawable.tur_07)
                && imgTur_08.getDrawable().equals(R.drawable.tur_08)
                && imgTur_09.getDrawable().equals(R.drawable.tur_09)
                && imgTur_10.getDrawable().equals(R.drawable.tur_10)
                && imgTur_11.getDrawable().equals(R.drawable.tur_11)
                && imgTur_12.getDrawable().equals(R.drawable.tur_12)
                && imgTur_13.getDrawable().equals(R.drawable.tur_13)
                && imgTur_14.getDrawable().equals(R.drawable.tur_14)
                && imgTur_15.getDrawable().equals(R.drawable.tur_15)
                && imgTur_16.getDrawable().equals(R.drawable.tur_16)
                && imgTur_17.getDrawable().equals(R.drawable.tur_17)
                && imgTur_18.getDrawable().equals(R.drawable.tur_18)
                && imgTur_19.getDrawable().equals(R.drawable.tur_19)
                && imgTur_20.getDrawable().equals(R.drawable.tur_20)
                && imgTur_21.getDrawable().equals(R.drawable.tur_21)
                && imgTur_22.getDrawable().equals(R.drawable.tur_22)
                && imgTur_23.getDrawable().equals(R.drawable.tur_23)) return true;
        else return false;
    }

    private boolean hasClickers() {
        if (imgTur_01.hasOnClickListeners()
                || imgTur_02.hasOnClickListeners()
                || imgTur_03.hasOnClickListeners()
                || imgTur_04.hasOnClickListeners()
                || imgTur_05.hasOnClickListeners()
                || imgTur_06.hasOnClickListeners()
                || imgTur_07.hasOnClickListeners()
                || imgTur_08.hasOnClickListeners()
                || imgTur_09.hasOnClickListeners()
                || imgTur_10.hasOnClickListeners()
                || imgTur_11.hasOnClickListeners()
                || imgTur_12.hasOnClickListeners()
                || imgTur_13.hasOnClickListeners()
                || imgTur_14.hasOnClickListeners()
                || imgTur_15.hasOnClickListeners()
                || imgTur_16.hasOnClickListeners()
                || imgTur_17.hasOnClickListeners()
                || imgTur_18.hasOnClickListeners()
                || imgTur_19.hasOnClickListeners()
                || imgTur_20.hasOnClickListeners()
                || imgTur_21.hasOnClickListeners()
                || imgTur_22.hasOnClickListeners()
                || imgTur_23.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        tur_01 = view.findViewById(R.id.tur_01);
        tur_02 = view.findViewById(R.id.tur_02);
        tur_03 = view.findViewById(R.id.tur_03);
        tur_04 = view.findViewById(R.id.tur_04);
        tur_05 = view.findViewById(R.id.tur_05);
        tur_06 = view.findViewById(R.id.tur_06);
        tur_07 = view.findViewById(R.id.tur_07);
        tur_08 = view.findViewById(R.id.tur_08);
        tur_09 = view.findViewById(R.id.tur_09);
        tur_10 = view.findViewById(R.id.tur_10);
        tur_11 = view.findViewById(R.id.tur_11);
        tur_12 = view.findViewById(R.id.tur_12);
        tur_13 = view.findViewById(R.id.tur_13);
        tur_14 = view.findViewById(R.id.tur_14);
        tur_15 = view.findViewById(R.id.tur_15);
        tur_16 = view.findViewById(R.id.tur_16);
        tur_17 = view.findViewById(R.id.tur_17);
        tur_18 = view.findViewById(R.id.tur_18);
        tur_19 = view.findViewById(R.id.tur_19);
        tur_20 = view.findViewById(R.id.tur_20);
        tur_21 = view.findViewById(R.id.tur_21);
        tur_22 = view.findViewById(R.id.tur_22);
        tur_23 = view.findViewById(R.id.tur_23);

        tur_01.setOnClickListener(clickListenerScrollView);
        tur_02.setOnClickListener(clickListenerScrollView);
        tur_03.setOnClickListener(clickListenerScrollView);
        tur_04.setOnClickListener(clickListenerScrollView);
        tur_05.setOnClickListener(clickListenerScrollView);
        tur_06.setOnClickListener(clickListenerScrollView);
        tur_07.setOnClickListener(clickListenerScrollView);
        tur_08.setOnClickListener(clickListenerScrollView);
        tur_09.setOnClickListener(clickListenerScrollView);
        tur_10.setOnClickListener(clickListenerScrollView);
        tur_11.setOnClickListener(clickListenerScrollView);
        tur_12.setOnClickListener(clickListenerScrollView);
        tur_13.setOnClickListener(clickListenerScrollView);
        tur_14.setOnClickListener(clickListenerScrollView);
        tur_15.setOnClickListener(clickListenerScrollView);
        tur_16.setOnClickListener(clickListenerScrollView);
        tur_17.setOnClickListener(clickListenerScrollView);
        tur_18.setOnClickListener(clickListenerScrollView);
        tur_19.setOnClickListener(clickListenerScrollView);
        tur_20.setOnClickListener(clickListenerScrollView);
        tur_21.setOnClickListener(clickListenerScrollView);
        tur_22.setOnClickListener(clickListenerScrollView);
        tur_23.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgTur_01 = view.findViewById(R.id.imgTur_01);
        imgTur_02 = view.findViewById(R.id.imgTur_02);
        imgTur_03 = view.findViewById(R.id.imgTur_03);
        imgTur_04 = view.findViewById(R.id.imgTur_04);
        imgTur_05 = view.findViewById(R.id.imgTur_05);
        imgTur_06 = view.findViewById(R.id.imgTur_06);
        imgTur_07 = view.findViewById(R.id.imgTur_07);
        imgTur_08 = view.findViewById(R.id.imgTur_08);
        imgTur_09 = view.findViewById(R.id.imgTur_09);
        imgTur_10 = view.findViewById(R.id.imgTur_10);
        imgTur_11 = view.findViewById(R.id.imgTur_11);
        imgTur_12 = view.findViewById(R.id.imgTur_12);
        imgTur_13 = view.findViewById(R.id.imgTur_13);
        imgTur_14 = view.findViewById(R.id.imgTur_14);
        imgTur_15 = view.findViewById(R.id.imgTur_15);
        imgTur_16 = view.findViewById(R.id.imgTur_16);
        imgTur_17 = view.findViewById(R.id.imgTur_17);
        imgTur_18 = view.findViewById(R.id.imgTur_18);
        imgTur_19 = view.findViewById(R.id.imgTur_19);
        imgTur_20 = view.findViewById(R.id.imgTur_20);
        imgTur_21 = view.findViewById(R.id.imgTur_21);
        imgTur_22 = view.findViewById(R.id.imgTur_22);
        imgTur_23 = view.findViewById(R.id.imgTur_23);
        imgTur_24 = view.findViewById(R.id.imgTur_24);

        imgTur_01.setOnClickListener(clickListenerResposta);
        imgTur_02.setOnClickListener(clickListenerResposta);
        imgTur_03.setOnClickListener(clickListenerResposta);
        imgTur_04.setOnClickListener(clickListenerResposta);
        imgTur_05.setOnClickListener(clickListenerResposta);
        imgTur_06.setOnClickListener(clickListenerResposta);
        imgTur_07.setOnClickListener(clickListenerResposta);
        imgTur_08.setOnClickListener(clickListenerResposta);
        imgTur_09.setOnClickListener(clickListenerResposta);
        imgTur_10.setOnClickListener(clickListenerResposta);
        imgTur_11.setOnClickListener(clickListenerResposta);
        imgTur_12.setOnClickListener(clickListenerResposta);
        imgTur_13.setOnClickListener(clickListenerResposta);
        imgTur_14.setOnClickListener(clickListenerResposta);
        imgTur_15.setOnClickListener(clickListenerResposta);
        imgTur_16.setOnClickListener(clickListenerResposta);
        imgTur_17.setOnClickListener(clickListenerResposta);
        imgTur_18.setOnClickListener(clickListenerResposta);
        imgTur_19.setOnClickListener(clickListenerResposta);
        imgTur_20.setOnClickListener(clickListenerResposta);
        imgTur_21.setOnClickListener(clickListenerResposta);
        imgTur_22.setOnClickListener(clickListenerResposta);
        imgTur_23.setOnClickListener(clickListenerResposta);
        imgTur_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tur_01.setBackgroundResource(0);
            tur_02.setBackgroundResource(0);
            tur_03.setBackgroundResource(0);
            tur_04.setBackgroundResource(0);
            tur_05.setBackgroundResource(0);
            tur_06.setBackgroundResource(0);
            tur_07.setBackgroundResource(0);
            tur_08.setBackgroundResource(0);
            tur_09.setBackgroundResource(0);
            tur_10.setBackgroundResource(0);
            tur_11.setBackgroundResource(0);
            tur_12.setBackgroundResource(0);
            tur_13.setBackgroundResource(0);
            tur_14.setBackgroundResource(0);
            tur_15.setBackgroundResource(0);
            tur_16.setBackgroundResource(0);
            tur_17.setBackgroundResource(0);
            tur_18.setBackgroundResource(0);
            tur_19.setBackgroundResource(0);
            tur_20.setBackgroundResource(0);
            tur_21.setBackgroundResource(0);
            tur_22.setBackgroundResource(0);
            tur_23.setBackgroundResource(0);

            tur_01.setSelected(false);
            tur_02.setSelected(false);
            tur_03.setSelected(false);
            tur_04.setSelected(false);
            tur_05.setSelected(false);
            tur_06.setSelected(false);
            tur_07.setSelected(false);
            tur_08.setSelected(false);
            tur_09.setSelected(false);
            tur_10.setSelected(false);
            tur_11.setSelected(false);
            tur_12.setSelected(false);
            tur_13.setSelected(false);
            tur_14.setSelected(false);
            tur_15.setSelected(false);
            tur_16.setSelected(false);
            tur_17.setSelected(false);
            tur_18.setSelected(false);
            tur_19.setSelected(false);
            tur_20.setSelected(false);
            tur_21.setSelected(false);
            tur_22.setSelected(false);
            tur_23.setSelected(false);

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
                case R.id.tur_01:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_01);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_02:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_02);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_03:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_03);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_04:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_04);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_05:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_05);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_06:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_06);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_07:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_07);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_08:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_08);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_09:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_09);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_10:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_10);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_11:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_11);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_12:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_12);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_13:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_13);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_14:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_14);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_15:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_15);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_16:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_16);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_17:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_17);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_18:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_18);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_19:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_19);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_20:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_20);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_21:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_21);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_22:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_22);
                    iv.setOnClickListener(null);
                    break;
                case R.id.tur_23:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tur_23);
                    iv.setOnClickListener(null);
                    break;
            }
            selected = 0;
        }
    };
}
