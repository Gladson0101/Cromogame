package br.edu.ifam.cromograme.fragment.jogo.estrutura;


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
public class JogoEstrutura2Fragment extends Fragment {


    public JogoEstrutura2Fragment() {
        // Required empty public constructor
    }


    private ImageView imgBur_01, imgBur_02, imgBur_03, imgBur_04, imgBur_05;
    private ImageView imgBur_06, imgBur_07, imgBur_08, imgBur_09, imgBur_10;
    private ImageView imgBur_11, imgBur_12, imgBur_13, imgBur_14, imgBur_15;
    private ImageView imgBur_16, imgBur_17, imgBur_18, imgBur_19, imgBur_20;
    private ImageView imgBur_21, imgBur_22, imgBur_23, imgBur_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura2, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 3/10");

        Button buttonDesistir = getActivity().findViewById(R.id.buttonJogoEstruturasDesistir);
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

        Button button = getActivity().findViewById(R.id.buttonJogoEstruturasProximo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resposta()) {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View viewRoot = inflater.inflate(R.layout.fragment_certo, null);
                    ImageView imgResposta = viewRoot.findViewById(R.id.imgCerto);
                    imgResposta.setImageResource(R.drawable.bur_resp);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura3Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura3Fragment());
                    dialogFragment.show(transaction, "");
                }
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDicaEstruturas);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.dica_glow);
                builder.setTitle("Dica");
                builder.setMessage("Encontre a translocação no cromossomo\nHá dois cromossomos translocados");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgBur_01.isSelected()
                && !imgBur_02.isSelected()
                && !imgBur_03.isSelected()
                && !imgBur_04.isSelected()
                && !imgBur_05.isSelected()
                && !imgBur_06.isSelected()
                && !imgBur_07.isSelected()
                && imgBur_08.isSelected()
                && !imgBur_09.isSelected()
                && !imgBur_10.isSelected()
                && !imgBur_11.isSelected()
                && !imgBur_12.isSelected()
                && !imgBur_13.isSelected()
                && imgBur_14.isSelected()
                && !imgBur_15.isSelected()
                && !imgBur_16.isSelected()
                && !imgBur_17.isSelected()
                && !imgBur_18.isSelected()
                && !imgBur_19.isSelected()
                && !imgBur_20.isSelected()
                && !imgBur_21.isSelected()
                && !imgBur_22.isSelected()
                && !imgBur_23.isSelected()
                && !imgBur_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgBur_01 = view.findViewById(R.id.imgBur_01);
        imgBur_02 = view.findViewById(R.id.imgBur_02);
        imgBur_03 = view.findViewById(R.id.imgBur_03);
        imgBur_04 = view.findViewById(R.id.imgBur_04);
        imgBur_05 = view.findViewById(R.id.imgBur_05);
        imgBur_06 = view.findViewById(R.id.imgBur_06);
        imgBur_07 = view.findViewById(R.id.imgBur_07);
        imgBur_08 = view.findViewById(R.id.imgBur_08);
        imgBur_09 = view.findViewById(R.id.imgBur_09);
        imgBur_10 = view.findViewById(R.id.imgBur_10);
        imgBur_11 = view.findViewById(R.id.imgBur_11);
        imgBur_12 = view.findViewById(R.id.imgBur_12);
        imgBur_13 = view.findViewById(R.id.imgBur_13);
        imgBur_14 = view.findViewById(R.id.imgBur_14);
        imgBur_15 = view.findViewById(R.id.imgBur_15);
        imgBur_16 = view.findViewById(R.id.imgBur_16);
        imgBur_17 = view.findViewById(R.id.imgBur_17);
        imgBur_18 = view.findViewById(R.id.imgBur_18);
        imgBur_19 = view.findViewById(R.id.imgBur_19);
        imgBur_20 = view.findViewById(R.id.imgBur_20);
        imgBur_21 = view.findViewById(R.id.imgBur_21);
        imgBur_22 = view.findViewById(R.id.imgBur_22);
        imgBur_23 = view.findViewById(R.id.imgBur_23);
        imgBur_24 = view.findViewById(R.id.imgBur_24);

        imgBur_01.setOnClickListener(clickListener);
        imgBur_02.setOnClickListener(clickListener);
        imgBur_03.setOnClickListener(clickListener);
        imgBur_04.setOnClickListener(clickListener);
        imgBur_05.setOnClickListener(clickListener);
        imgBur_06.setOnClickListener(clickListener);
        imgBur_07.setOnClickListener(clickListener);
        imgBur_08.setOnClickListener(clickListener);
        imgBur_09.setOnClickListener(clickListener);
        imgBur_10.setOnClickListener(clickListener);
        imgBur_11.setOnClickListener(clickListener);
        imgBur_12.setOnClickListener(clickListener);
        imgBur_13.setOnClickListener(clickListener);
        imgBur_14.setOnClickListener(clickListener);
        imgBur_15.setOnClickListener(clickListener);
        imgBur_16.setOnClickListener(clickListener);
        imgBur_17.setOnClickListener(clickListener);
        imgBur_18.setOnClickListener(clickListener);
        imgBur_19.setOnClickListener(clickListener);
        imgBur_20.setOnClickListener(clickListener);
        imgBur_21.setOnClickListener(clickListener);
        imgBur_22.setOnClickListener(clickListener);
        imgBur_23.setOnClickListener(clickListener);
        imgBur_24.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.isSelected()) {
                v.setSelected(false);
                v.setBackgroundResource(0);
            } else {
                v.setBackgroundResource(R.color.colorPrimary);
                v.setSelected(true);
            }

        }
    };

}
