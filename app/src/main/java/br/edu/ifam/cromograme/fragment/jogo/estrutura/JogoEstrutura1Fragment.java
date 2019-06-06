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
import br.edu.ifam.cromograme.fragment.jogo.numerico.JogoDoencas10Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoEstrutura1Fragment extends Fragment {


    public JogoEstrutura1Fragment() {
        // Required empty public constructor
    }

    private ImageView imgAng_01, imgAng_02, imgAng_03, imgAng_04, imgAng_05;
    private ImageView imgAng_06, imgAng_07, imgAng_08, imgAng_09, imgAng_10;
    private ImageView imgAng_11, imgAng_12, imgAng_13, imgAng_14, imgAng_15;
    private ImageView imgAng_16, imgAng_17, imgAng_18, imgAng_19, imgAng_20;
    private ImageView imgAng_21, imgAng_22, imgAng_23, imgAng_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura1, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 1/9");

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
                    tv.setText("Angelman");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.ang_15);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura2Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura2Fragment());
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
                builder.setMessage("Encontre a deleção no cromossomo\nTrata-se de uma deleção materna");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgAng_01.isSelected()
                && !imgAng_02.isSelected()
                && !imgAng_03.isSelected()
                && !imgAng_04.isSelected()
                && !imgAng_05.isSelected()
                && !imgAng_06.isSelected()
                && !imgAng_07.isSelected()
                && !imgAng_08.isSelected()
                && !imgAng_09.isSelected()
                && !imgAng_10.isSelected()
                && !imgAng_11.isSelected()
                && !imgAng_12.isSelected()
                && !imgAng_13.isSelected()
                && !imgAng_14.isSelected()
                && imgAng_15.isSelected()
                && !imgAng_16.isSelected()
                && !imgAng_17.isSelected()
                && !imgAng_18.isSelected()
                && !imgAng_19.isSelected()
                && !imgAng_20.isSelected()
                && !imgAng_21.isSelected()
                && !imgAng_22.isSelected()
                && !imgAng_23.isSelected()
                && !imgAng_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgAng_01 = view.findViewById(R.id.imgAng_01);
        imgAng_02 = view.findViewById(R.id.imgAng_02);
        imgAng_03 = view.findViewById(R.id.imgAng_03);
        imgAng_04 = view.findViewById(R.id.imgAng_04);
        imgAng_05 = view.findViewById(R.id.imgAng_05);
        imgAng_06 = view.findViewById(R.id.imgAng_06);
        imgAng_07 = view.findViewById(R.id.imgAng_07);
        imgAng_08 = view.findViewById(R.id.imgAng_08);
        imgAng_09 = view.findViewById(R.id.imgAng_09);
        imgAng_10 = view.findViewById(R.id.imgAng_10);
        imgAng_11 = view.findViewById(R.id.imgAng_11);
        imgAng_12 = view.findViewById(R.id.imgAng_12);
        imgAng_13 = view.findViewById(R.id.imgAng_13);
        imgAng_14 = view.findViewById(R.id.imgAng_14);
        imgAng_15 = view.findViewById(R.id.imgAng_15);
        imgAng_16 = view.findViewById(R.id.imgAng_16);
        imgAng_17 = view.findViewById(R.id.imgAng_17);
        imgAng_18 = view.findViewById(R.id.imgAng_18);
        imgAng_19 = view.findViewById(R.id.imgAng_19);
        imgAng_20 = view.findViewById(R.id.imgAng_20);
        imgAng_21 = view.findViewById(R.id.imgAng_21);
        imgAng_22 = view.findViewById(R.id.imgAng_22);
        imgAng_23 = view.findViewById(R.id.imgAng_23);
        imgAng_24 = view.findViewById(R.id.imgAng_24);

        imgAng_01.setOnClickListener(clickListener);
        imgAng_02.setOnClickListener(clickListener);
        imgAng_03.setOnClickListener(clickListener);
        imgAng_04.setOnClickListener(clickListener);
        imgAng_05.setOnClickListener(clickListener);
        imgAng_06.setOnClickListener(clickListener);
        imgAng_07.setOnClickListener(clickListener);
        imgAng_08.setOnClickListener(clickListener);
        imgAng_09.setOnClickListener(clickListener);
        imgAng_10.setOnClickListener(clickListener);
        imgAng_11.setOnClickListener(clickListener);
        imgAng_12.setOnClickListener(clickListener);
        imgAng_13.setOnClickListener(clickListener);
        imgAng_14.setOnClickListener(clickListener);
        imgAng_15.setOnClickListener(clickListener);
        imgAng_16.setOnClickListener(clickListener);
        imgAng_17.setOnClickListener(clickListener);
        imgAng_18.setOnClickListener(clickListener);
        imgAng_19.setOnClickListener(clickListener);
        imgAng_20.setOnClickListener(clickListener);
        imgAng_21.setOnClickListener(clickListener);
        imgAng_22.setOnClickListener(clickListener);
        imgAng_23.setOnClickListener(clickListener);
        imgAng_24.setOnClickListener(clickListener);
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
