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
public class JogoEstrutura9Fragment extends Fragment {


    public JogoEstrutura9Fragment() {
        // Required empty public constructor
    }


    private ImageView imgWolf_01, imgWolf_02, imgWolf_03, imgWolf_04, imgWolf_05;
    private ImageView imgWolf_06, imgWolf_07, imgWolf_08, imgWolf_09, imgWolf_10;
    private ImageView imgWolf_11, imgWolf_12, imgWolf_13, imgWolf_14, imgWolf_15;
    private ImageView imgWolf_16, imgWolf_17, imgWolf_18, imgWolf_19, imgWolf_20;
    private ImageView imgWolf_21, imgWolf_22, imgWolf_23, imgWolf_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura9, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 9/9");

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
                    DialogFragment dialogFragment = new CorrectAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    dialogFragment.show(transaction, "");
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    dialogFragment.show(transaction, "");
                }

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura2Fragment());
                transaction.commit();
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDicaEstruturas);
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

    private boolean resposta() {

        if (!imgWolf_01.isSelected()
                && !imgWolf_02.isSelected()
                && !imgWolf_03.isSelected()
                && imgWolf_04.isSelected()
                && !imgWolf_05.isSelected()
                && !imgWolf_06.isSelected()
                && !imgWolf_07.isSelected()
                && !imgWolf_08.isSelected()
                && !imgWolf_09.isSelected()
                && !imgWolf_10.isSelected()
                && !imgWolf_11.isSelected()
                && !imgWolf_12.isSelected()
                && !imgWolf_13.isSelected()
                && !imgWolf_14.isSelected()
                && !imgWolf_15.isSelected()
                && !imgWolf_16.isSelected()
                && !imgWolf_17.isSelected()
                && !imgWolf_18.isSelected()
                && !imgWolf_19.isSelected()
                && !imgWolf_20.isSelected()
                && !imgWolf_21.isSelected()
                && !imgWolf_22.isSelected()
                && !imgWolf_23.isSelected()
                && !imgWolf_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgWolf_01 = view.findViewById(R.id.imgWolf_01);
        imgWolf_02 = view.findViewById(R.id.imgWolf_02);
        imgWolf_03 = view.findViewById(R.id.imgWolf_03);
        imgWolf_04 = view.findViewById(R.id.imgWolf_04);
        imgWolf_05 = view.findViewById(R.id.imgWolf_05);
        imgWolf_06 = view.findViewById(R.id.imgWolf_06);
        imgWolf_07 = view.findViewById(R.id.imgWolf_07);
        imgWolf_08 = view.findViewById(R.id.imgWolf_08);
        imgWolf_09 = view.findViewById(R.id.imgWolf_09);
        imgWolf_10 = view.findViewById(R.id.imgWolf_10);
        imgWolf_11 = view.findViewById(R.id.imgWolf_11);
        imgWolf_12 = view.findViewById(R.id.imgWolf_12);
        imgWolf_13 = view.findViewById(R.id.imgWolf_13);
        imgWolf_14 = view.findViewById(R.id.imgWolf_14);
        imgWolf_15 = view.findViewById(R.id.imgWolf_15);
        imgWolf_16 = view.findViewById(R.id.imgWolf_16);
        imgWolf_17 = view.findViewById(R.id.imgWolf_17);
        imgWolf_18 = view.findViewById(R.id.imgWolf_18);
        imgWolf_19 = view.findViewById(R.id.imgWolf_19);
        imgWolf_20 = view.findViewById(R.id.imgWolf_20);
        imgWolf_21 = view.findViewById(R.id.imgWolf_21);
        imgWolf_22 = view.findViewById(R.id.imgWolf_22);
        imgWolf_23 = view.findViewById(R.id.imgWolf_23);
        imgWolf_24 = view.findViewById(R.id.imgWolf_24);

        imgWolf_01.setOnClickListener(clickListener);
        imgWolf_02.setOnClickListener(clickListener);
        imgWolf_03.setOnClickListener(clickListener);
        imgWolf_04.setOnClickListener(clickListener);
        imgWolf_05.setOnClickListener(clickListener);
        imgWolf_06.setOnClickListener(clickListener);
        imgWolf_07.setOnClickListener(clickListener);
        imgWolf_08.setOnClickListener(clickListener);
        imgWolf_09.setOnClickListener(clickListener);
        imgWolf_10.setOnClickListener(clickListener);
        imgWolf_11.setOnClickListener(clickListener);
        imgWolf_12.setOnClickListener(clickListener);
        imgWolf_13.setOnClickListener(clickListener);
        imgWolf_14.setOnClickListener(clickListener);
        imgWolf_15.setOnClickListener(clickListener);
        imgWolf_16.setOnClickListener(clickListener);
        imgWolf_17.setOnClickListener(clickListener);
        imgWolf_18.setOnClickListener(clickListener);
        imgWolf_19.setOnClickListener(clickListener);
        imgWolf_20.setOnClickListener(clickListener);
        imgWolf_21.setOnClickListener(clickListener);
        imgWolf_22.setOnClickListener(clickListener);
        imgWolf_23.setOnClickListener(clickListener);
        imgWolf_24.setOnClickListener(clickListener);
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
