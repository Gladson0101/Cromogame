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
public class JogoEstrutura5Fragment extends Fragment {


    public JogoEstrutura5Fragment() {
        // Required empty public constructor
    }


    private ImageView imgMill_01, imgMill_02, imgMill_03, imgMill_04, imgMill_05;
    private ImageView imgMill_06, imgMill_07, imgMill_08, imgMill_09, imgMill_10;
    private ImageView imgMill_11, imgMill_12, imgMill_13, imgMill_14, imgMill_15;
    private ImageView imgMill_16, imgMill_17, imgMill_18, imgMill_19, imgMill_20;
    private ImageView imgMill_21, imgMill_22, imgMill_23, imgMill_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura5, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 5/9");

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
                    View viewRoot = inflater.inflate(R.layout.fragment_certo_doenca, null);
                    TextView tv = viewRoot.findViewById(R.id.textViewNomeDoenca);
                    tv.setText("Miller Dieker");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.mill_17);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura6Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura6Fragment());
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

        if (!imgMill_01.isSelected()
                && !imgMill_02.isSelected()
                && !imgMill_03.isSelected()
                && !imgMill_04.isSelected()
                && !imgMill_05.isSelected()
                && !imgMill_06.isSelected()
                && !imgMill_07.isSelected()
                && !imgMill_08.isSelected()
                && !imgMill_09.isSelected()
                && !imgMill_10.isSelected()
                && !imgMill_11.isSelected()
                && !imgMill_12.isSelected()
                && !imgMill_13.isSelected()
                && !imgMill_14.isSelected()
                && !imgMill_15.isSelected()
                && !imgMill_16.isSelected()
                && imgMill_17.isSelected()
                && !imgMill_18.isSelected()
                && !imgMill_19.isSelected()
                && !imgMill_20.isSelected()
                && !imgMill_21.isSelected()
                && !imgMill_22.isSelected()
                && !imgMill_23.isSelected()
                && !imgMill_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgMill_01 = view.findViewById(R.id.imgMill_01);
        imgMill_02 = view.findViewById(R.id.imgMill_02);
        imgMill_03 = view.findViewById(R.id.imgMill_03);
        imgMill_04 = view.findViewById(R.id.imgMill_04);
        imgMill_05 = view.findViewById(R.id.imgMill_05);
        imgMill_06 = view.findViewById(R.id.imgMill_06);
        imgMill_07 = view.findViewById(R.id.imgMill_07);
        imgMill_08 = view.findViewById(R.id.imgMill_08);
        imgMill_09 = view.findViewById(R.id.imgMill_09);
        imgMill_10 = view.findViewById(R.id.imgMill_10);
        imgMill_11 = view.findViewById(R.id.imgMill_11);
        imgMill_12 = view.findViewById(R.id.imgMill_12);
        imgMill_13 = view.findViewById(R.id.imgMill_13);
        imgMill_14 = view.findViewById(R.id.imgMill_14);
        imgMill_15 = view.findViewById(R.id.imgMill_15);
        imgMill_16 = view.findViewById(R.id.imgMill_16);
        imgMill_17 = view.findViewById(R.id.imgMill_17);
        imgMill_18 = view.findViewById(R.id.imgMill_18);
        imgMill_19 = view.findViewById(R.id.imgMill_19);
        imgMill_20 = view.findViewById(R.id.imgMill_20);
        imgMill_21 = view.findViewById(R.id.imgMill_21);
        imgMill_22 = view.findViewById(R.id.imgMill_22);
        imgMill_23 = view.findViewById(R.id.imgMill_23);
        imgMill_24 = view.findViewById(R.id.imgMill_24);

        imgMill_01.setOnClickListener(clickListener);
        imgMill_02.setOnClickListener(clickListener);
        imgMill_03.setOnClickListener(clickListener);
        imgMill_04.setOnClickListener(clickListener);
        imgMill_05.setOnClickListener(clickListener);
        imgMill_06.setOnClickListener(clickListener);
        imgMill_07.setOnClickListener(clickListener);
        imgMill_08.setOnClickListener(clickListener);
        imgMill_09.setOnClickListener(clickListener);
        imgMill_10.setOnClickListener(clickListener);
        imgMill_11.setOnClickListener(clickListener);
        imgMill_12.setOnClickListener(clickListener);
        imgMill_13.setOnClickListener(clickListener);
        imgMill_14.setOnClickListener(clickListener);
        imgMill_15.setOnClickListener(clickListener);
        imgMill_16.setOnClickListener(clickListener);
        imgMill_17.setOnClickListener(clickListener);
        imgMill_18.setOnClickListener(clickListener);
        imgMill_19.setOnClickListener(clickListener);
        imgMill_20.setOnClickListener(clickListener);
        imgMill_21.setOnClickListener(clickListener);
        imgMill_22.setOnClickListener(clickListener);
        imgMill_23.setOnClickListener(clickListener);
        imgMill_24.setOnClickListener(clickListener);
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
