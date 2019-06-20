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
public class JogoDoencas9Fragment extends Fragment {


    public JogoDoencas9Fragment() {
        // Required empty public constructor
    }


    // Imagens do ScrollView
    private ImageView tri_01, tri_02, tri_03, tri_04, tri_05;
    private ImageView tri_06, tri_07, tri_08, tri_09, tri_10;
    private ImageView tri_11, tri_12, tri_13, tri_14, tri_15;
    private ImageView tri_16, tri_17, tri_18, tri_19, tri_20;
    private ImageView tri_21, tri_22, tri_23;

    // Imagens de Respostas
    private ImageView imgTri_01, imgTri_02, imgTri_03, imgTri_04, imgTri_05;
    private ImageView imgTri_06, imgTri_07, imgTri_08, imgTri_09, imgTri_10;
    private ImageView imgTri_11, imgTri_12, imgTri_13, imgTri_14, imgTri_15;
    private ImageView imgTri_16, imgTri_17, imgTri_18, imgTri_19, imgTri_20;
    private ImageView imgTri_21, imgTri_22, imgTri_23, imgTri_24;

    // Variável de controle
    private int selected = 0;
    private View viewSelected = null;

    private View viewTrocaOrigem = null;
    private View viewTrocaDestino = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas9, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 6/10");

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
                    tv.setText("Triplo X");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.triplo_x);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas10Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas10Fragment());
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
                builder.setMessage("Cromossomo extra\nAfeta apenas o sexo feminino");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    View.OnClickListener clickListenerTroca = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (viewTrocaOrigem == null) {
                viewTrocaOrigem = v;
                viewTrocaOrigem.setBackgroundResource(R.color.colorPrimary);
            } else if (viewTrocaOrigem == v) {
                viewTrocaOrigem.setBackgroundResource(0);
                viewTrocaOrigem = null;
            } else {

                viewTrocaDestino = v;

                ImageView imgOrigem = (ImageView) viewTrocaOrigem;
                ImageView imgDestino = (ImageView) viewTrocaDestino;

                ImageView imgAux = new ImageView(getActivity());
                imgAux.setImageDrawable(imgOrigem.getDrawable());

                imgOrigem.setImageDrawable(imgDestino.getDrawable());
                imgDestino.setImageDrawable(imgAux.getDrawable());

                viewTrocaOrigem.setBackgroundResource(0);
                viewTrocaDestino.setBackgroundResource(0);
                viewTrocaOrigem = null;
                viewTrocaDestino = null;
            }

        }
    };

    private boolean acertou() {
        if (imgTri_01.getDrawable().equals(R.drawable.tri_01)
                && imgTri_02.getDrawable().equals(R.drawable.tri_02)
                && imgTri_03.getDrawable().equals(R.drawable.tri_03)
                && imgTri_04.getDrawable().equals(R.drawable.tri_04)
                && imgTri_05.getDrawable().equals(R.drawable.tri_05)
                && imgTri_06.getDrawable().equals(R.drawable.tri_06)
                && imgTri_07.getDrawable().equals(R.drawable.tri_07)
                && imgTri_08.getDrawable().equals(R.drawable.tri_08)
                && imgTri_09.getDrawable().equals(R.drawable.tri_09)
                && imgTri_10.getDrawable().equals(R.drawable.tri_10)
                && imgTri_11.getDrawable().equals(R.drawable.tri_11)
                && imgTri_12.getDrawable().equals(R.drawable.tri_12)
                && imgTri_13.getDrawable().equals(R.drawable.tri_13)
                && imgTri_14.getDrawable().equals(R.drawable.tri_14)
                && imgTri_15.getDrawable().equals(R.drawable.tri_15)
                && imgTri_16.getDrawable().equals(R.drawable.tri_16)
                && imgTri_17.getDrawable().equals(R.drawable.tri_17)
                && imgTri_18.getDrawable().equals(R.drawable.tri_18)
                && imgTri_19.getDrawable().equals(R.drawable.tri_19)
                && imgTri_20.getDrawable().equals(R.drawable.tri_20)
                && imgTri_21.getDrawable().equals(R.drawable.tri_21)
                && imgTri_22.getDrawable().equals(R.drawable.tri_22)
                && imgTri_23.getDrawable().equals(R.drawable.tri_23)) return true;
        else return false;
    }

    private boolean hasClickers() {
        if (imgTri_01.hasOnClickListeners()
                || imgTri_02.hasOnClickListeners()
                || imgTri_03.hasOnClickListeners()
                || imgTri_04.hasOnClickListeners()
                || imgTri_05.hasOnClickListeners()
                || imgTri_06.hasOnClickListeners()
                || imgTri_07.hasOnClickListeners()
                || imgTri_08.hasOnClickListeners()
                || imgTri_09.hasOnClickListeners()
                || imgTri_10.hasOnClickListeners()
                || imgTri_11.hasOnClickListeners()
                || imgTri_12.hasOnClickListeners()
                || imgTri_13.hasOnClickListeners()
                || imgTri_14.hasOnClickListeners()
                || imgTri_15.hasOnClickListeners()
                || imgTri_16.hasOnClickListeners()
                || imgTri_17.hasOnClickListeners()
                || imgTri_18.hasOnClickListeners()
                || imgTri_19.hasOnClickListeners()
                || imgTri_20.hasOnClickListeners()
                || imgTri_21.hasOnClickListeners()
                || imgTri_22.hasOnClickListeners()
                || imgTri_23.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        tri_01 = view.findViewById(R.id.tri_01);
        tri_02 = view.findViewById(R.id.tri_02);
        tri_03 = view.findViewById(R.id.tri_03);
        tri_04 = view.findViewById(R.id.tri_04);
        tri_05 = view.findViewById(R.id.tri_05);
        tri_06 = view.findViewById(R.id.tri_06);
        tri_07 = view.findViewById(R.id.tri_07);
        tri_08 = view.findViewById(R.id.tri_08);
        tri_09 = view.findViewById(R.id.tri_09);
        tri_10 = view.findViewById(R.id.tri_10);
        tri_11 = view.findViewById(R.id.tri_11);
        tri_12 = view.findViewById(R.id.tri_12);
        tri_13 = view.findViewById(R.id.tri_13);
        tri_14 = view.findViewById(R.id.tri_14);
        tri_15 = view.findViewById(R.id.tri_15);
        tri_16 = view.findViewById(R.id.tri_16);
        tri_17 = view.findViewById(R.id.tri_17);
        tri_18 = view.findViewById(R.id.tri_18);
        tri_19 = view.findViewById(R.id.tri_19);
        tri_20 = view.findViewById(R.id.tri_20);
        tri_21 = view.findViewById(R.id.tri_21);
        tri_22 = view.findViewById(R.id.tri_22);
        tri_23 = view.findViewById(R.id.tri_23);

        tri_01.setOnClickListener(clickListenerScrollView);
        tri_02.setOnClickListener(clickListenerScrollView);
        tri_03.setOnClickListener(clickListenerScrollView);
        tri_04.setOnClickListener(clickListenerScrollView);
        tri_05.setOnClickListener(clickListenerScrollView);
        tri_06.setOnClickListener(clickListenerScrollView);
        tri_07.setOnClickListener(clickListenerScrollView);
        tri_08.setOnClickListener(clickListenerScrollView);
        tri_09.setOnClickListener(clickListenerScrollView);
        tri_10.setOnClickListener(clickListenerScrollView);
        tri_11.setOnClickListener(clickListenerScrollView);
        tri_12.setOnClickListener(clickListenerScrollView);
        tri_13.setOnClickListener(clickListenerScrollView);
        tri_14.setOnClickListener(clickListenerScrollView);
        tri_15.setOnClickListener(clickListenerScrollView);
        tri_16.setOnClickListener(clickListenerScrollView);
        tri_17.setOnClickListener(clickListenerScrollView);
        tri_18.setOnClickListener(clickListenerScrollView);
        tri_19.setOnClickListener(clickListenerScrollView);
        tri_20.setOnClickListener(clickListenerScrollView);
        tri_21.setOnClickListener(clickListenerScrollView);
        tri_22.setOnClickListener(clickListenerScrollView);
        tri_23.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgTri_01 = view.findViewById(R.id.imgTri_01);
        imgTri_02 = view.findViewById(R.id.imgTri_02);
        imgTri_03 = view.findViewById(R.id.imgTri_03);
        imgTri_04 = view.findViewById(R.id.imgTri_04);
        imgTri_05 = view.findViewById(R.id.imgTri_05);
        imgTri_06 = view.findViewById(R.id.imgTri_06);
        imgTri_07 = view.findViewById(R.id.imgTri_07);
        imgTri_08 = view.findViewById(R.id.imgTri_08);
        imgTri_09 = view.findViewById(R.id.imgTri_09);
        imgTri_10 = view.findViewById(R.id.imgTri_10);
        imgTri_11 = view.findViewById(R.id.imgTri_11);
        imgTri_12 = view.findViewById(R.id.imgTri_12);
        imgTri_13 = view.findViewById(R.id.imgTri_13);
        imgTri_14 = view.findViewById(R.id.imgTri_14);
        imgTri_15 = view.findViewById(R.id.imgTri_15);
        imgTri_16 = view.findViewById(R.id.imgTri_16);
        imgTri_17 = view.findViewById(R.id.imgTri_17);
        imgTri_18 = view.findViewById(R.id.imgTri_18);
        imgTri_19 = view.findViewById(R.id.imgTri_19);
        imgTri_20 = view.findViewById(R.id.imgTri_20);
        imgTri_21 = view.findViewById(R.id.imgTri_21);
        imgTri_22 = view.findViewById(R.id.imgTri_22);
        imgTri_23 = view.findViewById(R.id.imgTri_23);
        imgTri_24 = view.findViewById(R.id.imgTri_24);

        imgTri_01.setOnClickListener(clickListenerResposta);
        imgTri_02.setOnClickListener(clickListenerResposta);
        imgTri_03.setOnClickListener(clickListenerResposta);
        imgTri_04.setOnClickListener(clickListenerResposta);
        imgTri_05.setOnClickListener(clickListenerResposta);
        imgTri_06.setOnClickListener(clickListenerResposta);
        imgTri_07.setOnClickListener(clickListenerResposta);
        imgTri_08.setOnClickListener(clickListenerResposta);
        imgTri_09.setOnClickListener(clickListenerResposta);
        imgTri_10.setOnClickListener(clickListenerResposta);
        imgTri_11.setOnClickListener(clickListenerResposta);
        imgTri_12.setOnClickListener(clickListenerResposta);
        imgTri_13.setOnClickListener(clickListenerResposta);
        imgTri_14.setOnClickListener(clickListenerResposta);
        imgTri_15.setOnClickListener(clickListenerResposta);
        imgTri_16.setOnClickListener(clickListenerResposta);
        imgTri_17.setOnClickListener(clickListenerResposta);
        imgTri_18.setOnClickListener(clickListenerResposta);
        imgTri_19.setOnClickListener(clickListenerResposta);
        imgTri_20.setOnClickListener(clickListenerResposta);
        imgTri_21.setOnClickListener(clickListenerResposta);
        imgTri_22.setOnClickListener(clickListenerResposta);
        imgTri_23.setOnClickListener(clickListenerResposta);
        imgTri_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tri_01.setBackgroundResource(0);
            tri_02.setBackgroundResource(0);
            tri_03.setBackgroundResource(0);
            tri_04.setBackgroundResource(0);
            tri_05.setBackgroundResource(0);
            tri_06.setBackgroundResource(0);
            tri_07.setBackgroundResource(0);
            tri_08.setBackgroundResource(0);
            tri_09.setBackgroundResource(0);
            tri_10.setBackgroundResource(0);
            tri_11.setBackgroundResource(0);
            tri_12.setBackgroundResource(0);
            tri_13.setBackgroundResource(0);
            tri_14.setBackgroundResource(0);
            tri_15.setBackgroundResource(0);
            tri_16.setBackgroundResource(0);
            tri_17.setBackgroundResource(0);
            tri_18.setBackgroundResource(0);
            tri_19.setBackgroundResource(0);
            tri_20.setBackgroundResource(0);
            tri_21.setBackgroundResource(0);
            tri_22.setBackgroundResource(0);
            tri_23.setBackgroundResource(0);

            tri_01.setSelected(false);
            tri_02.setSelected(false);
            tri_03.setSelected(false);
            tri_04.setSelected(false);
            tri_05.setSelected(false);
            tri_06.setSelected(false);
            tri_07.setSelected(false);
            tri_08.setSelected(false);
            tri_09.setSelected(false);
            tri_10.setSelected(false);
            tri_11.setSelected(false);
            tri_12.setSelected(false);
            tri_13.setSelected(false);
            tri_14.setSelected(false);
            tri_15.setSelected(false);
            tri_16.setSelected(false);
            tri_17.setSelected(false);
            tri_18.setSelected(false);
            tri_19.setSelected(false);
            tri_20.setSelected(false);
            tri_21.setSelected(false);
            tri_22.setSelected(false);
            tri_23.setSelected(false);

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
                case R.id.tri_01:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_01);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_02:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_02);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_03:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_03);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_04:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_04);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_05:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_05);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_06:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_06);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_07:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_07);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_08:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_08);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_09:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_09);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_10:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_10);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_11:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_11);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_12:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_12);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_13:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_13);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_14:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_14);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_15:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_15);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_16:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_16);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_17:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_17);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_18:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_18);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_19:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_19);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_20:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_20);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_21:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_21);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_22:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_22);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
                case R.id.tri_23:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.tri_23);
                    iv.setOnClickListener(clickListenerTroca);
                    break;
            }
            selected = 0;
        }
    };
}