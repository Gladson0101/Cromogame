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
import br.edu.ifam.cromograme.fragment.WrongAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoEstrutura8Fragment extends Fragment {


    public JogoEstrutura8Fragment() {
        // Required empty public constructor
    }


    private ImageView imgWill_01, imgWill_02, imgWill_03, imgWill_04, imgWill_05;
    private ImageView imgWill_06, imgWill_07, imgWill_08, imgWill_09, imgWill_10;
    private ImageView imgWill_11, imgWill_12, imgWill_13, imgWill_14, imgWill_15;
    private ImageView imgWill_16, imgWill_17, imgWill_18, imgWill_19, imgWill_20;
    private ImageView imgWill_21, imgWill_22, imgWill_23, imgWill_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura8, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 9/10");

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
                    imgResposta.setImageResource(R.drawable.will_07);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura9Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura9Fragment());
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
                builder.setMessage("Encontre a deleção no cromossomo");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgWill_01.isSelected()
                && !imgWill_02.isSelected()
                && !imgWill_03.isSelected()
                && !imgWill_04.isSelected()
                && !imgWill_05.isSelected()
                && !imgWill_06.isSelected()
                && imgWill_07.isSelected()
                && !imgWill_08.isSelected()
                && !imgWill_09.isSelected()
                && !imgWill_10.isSelected()
                && !imgWill_11.isSelected()
                && !imgWill_12.isSelected()
                && !imgWill_13.isSelected()
                && !imgWill_14.isSelected()
                && !imgWill_15.isSelected()
                && !imgWill_16.isSelected()
                && !imgWill_17.isSelected()
                && !imgWill_18.isSelected()
                && !imgWill_19.isSelected()
                && !imgWill_20.isSelected()
                && !imgWill_21.isSelected()
                && !imgWill_22.isSelected()
                && !imgWill_23.isSelected()
                && !imgWill_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgWill_01 = view.findViewById(R.id.imgWill_01);
        imgWill_02 = view.findViewById(R.id.imgWill_02);
        imgWill_03 = view.findViewById(R.id.imgWill_03);
        imgWill_04 = view.findViewById(R.id.imgWill_04);
        imgWill_05 = view.findViewById(R.id.imgWill_05);
        imgWill_06 = view.findViewById(R.id.imgWill_06);
        imgWill_07 = view.findViewById(R.id.imgWill_07);
        imgWill_08 = view.findViewById(R.id.imgWill_08);
        imgWill_09 = view.findViewById(R.id.imgWill_09);
        imgWill_10 = view.findViewById(R.id.imgWill_10);
        imgWill_11 = view.findViewById(R.id.imgWill_11);
        imgWill_12 = view.findViewById(R.id.imgWill_12);
        imgWill_13 = view.findViewById(R.id.imgWill_13);
        imgWill_14 = view.findViewById(R.id.imgWill_14);
        imgWill_15 = view.findViewById(R.id.imgWill_15);
        imgWill_16 = view.findViewById(R.id.imgWill_16);
        imgWill_17 = view.findViewById(R.id.imgWill_17);
        imgWill_18 = view.findViewById(R.id.imgWill_18);
        imgWill_19 = view.findViewById(R.id.imgWill_19);
        imgWill_20 = view.findViewById(R.id.imgWill_20);
        imgWill_21 = view.findViewById(R.id.imgWill_21);
        imgWill_22 = view.findViewById(R.id.imgWill_22);
        imgWill_23 = view.findViewById(R.id.imgWill_23);
        imgWill_24 = view.findViewById(R.id.imgWill_24);

        imgWill_01.setOnClickListener(clickListener);
        imgWill_02.setOnClickListener(clickListener);
        imgWill_03.setOnClickListener(clickListener);
        imgWill_04.setOnClickListener(clickListener);
        imgWill_05.setOnClickListener(clickListener);
        imgWill_06.setOnClickListener(clickListener);
        imgWill_07.setOnClickListener(clickListener);
        imgWill_08.setOnClickListener(clickListener);
        imgWill_09.setOnClickListener(clickListener);
        imgWill_10.setOnClickListener(clickListener);
        imgWill_11.setOnClickListener(clickListener);
        imgWill_12.setOnClickListener(clickListener);
        imgWill_13.setOnClickListener(clickListener);
        imgWill_14.setOnClickListener(clickListener);
        imgWill_15.setOnClickListener(clickListener);
        imgWill_16.setOnClickListener(clickListener);
        imgWill_17.setOnClickListener(clickListener);
        imgWill_18.setOnClickListener(clickListener);
        imgWill_19.setOnClickListener(clickListener);
        imgWill_20.setOnClickListener(clickListener);
        imgWill_21.setOnClickListener(clickListener);
        imgWill_22.setOnClickListener(clickListener);
        imgWill_23.setOnClickListener(clickListener);
        imgWill_24.setOnClickListener(clickListener);
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
