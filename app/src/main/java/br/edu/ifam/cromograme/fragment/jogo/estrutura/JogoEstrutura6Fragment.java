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
public class JogoEstrutura6Fragment extends Fragment {


    public JogoEstrutura6Fragment() {
        // Required empty public constructor
    }


    private ImageView imgPhi_01, imgPhi_02, imgPhi_03, imgPhi_04, imgPhi_05;
    private ImageView imgPhi_06, imgPhi_07, imgPhi_08, imgPhi_09, imgPhi_10;
    private ImageView imgPhi_11, imgPhi_12, imgPhi_13, imgPhi_14, imgPhi_15;
    private ImageView imgPhi_16, imgPhi_17, imgPhi_18, imgPhi_19, imgPhi_20;
    private ImageView imgPhi_21, imgPhi_22, imgPhi_23, imgPhi_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura6, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 6/9");

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
                    tv.setText("Philadelphia");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.phi_resp);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura7Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura7Fragment());
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
                builder.setMessage("Encontre a translocação no cromossomo\nSão dois cromossomos translocados");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgPhi_01.isSelected()
                && !imgPhi_02.isSelected()
                && !imgPhi_03.isSelected()
                && !imgPhi_04.isSelected()
                && !imgPhi_05.isSelected()
                && !imgPhi_06.isSelected()
                && !imgPhi_07.isSelected()
                && !imgPhi_08.isSelected()
                && imgPhi_09.isSelected()
                && !imgPhi_10.isSelected()
                && !imgPhi_11.isSelected()
                && !imgPhi_12.isSelected()
                && !imgPhi_13.isSelected()
                && !imgPhi_14.isSelected()
                && !imgPhi_15.isSelected()
                && !imgPhi_16.isSelected()
                && !imgPhi_17.isSelected()
                && !imgPhi_18.isSelected()
                && !imgPhi_19.isSelected()
                && !imgPhi_20.isSelected()
                && !imgPhi_21.isSelected()
                && imgPhi_22.isSelected()
                && !imgPhi_23.isSelected()
                && !imgPhi_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgPhi_01 = view.findViewById(R.id.imgPhi_01);
        imgPhi_02 = view.findViewById(R.id.imgPhi_02);
        imgPhi_03 = view.findViewById(R.id.imgPhi_03);
        imgPhi_04 = view.findViewById(R.id.imgPhi_04);
        imgPhi_05 = view.findViewById(R.id.imgPhi_05);
        imgPhi_06 = view.findViewById(R.id.imgPhi_06);
        imgPhi_07 = view.findViewById(R.id.imgPhi_07);
        imgPhi_08 = view.findViewById(R.id.imgPhi_08);
        imgPhi_09 = view.findViewById(R.id.imgPhi_09);
        imgPhi_10 = view.findViewById(R.id.imgPhi_10);
        imgPhi_11 = view.findViewById(R.id.imgPhi_11);
        imgPhi_12 = view.findViewById(R.id.imgPhi_12);
        imgPhi_13 = view.findViewById(R.id.imgPhi_13);
        imgPhi_14 = view.findViewById(R.id.imgPhi_14);
        imgPhi_15 = view.findViewById(R.id.imgPhi_15);
        imgPhi_16 = view.findViewById(R.id.imgPhi_16);
        imgPhi_17 = view.findViewById(R.id.imgPhi_17);
        imgPhi_18 = view.findViewById(R.id.imgPhi_18);
        imgPhi_19 = view.findViewById(R.id.imgPhi_19);
        imgPhi_20 = view.findViewById(R.id.imgPhi_20);
        imgPhi_21 = view.findViewById(R.id.imgPhi_21);
        imgPhi_22 = view.findViewById(R.id.imgPhi_22);
        imgPhi_23 = view.findViewById(R.id.imgPhi_23);
        imgPhi_24 = view.findViewById(R.id.imgPhi_24);

        imgPhi_01.setOnClickListener(clickListener);
        imgPhi_02.setOnClickListener(clickListener);
        imgPhi_03.setOnClickListener(clickListener);
        imgPhi_04.setOnClickListener(clickListener);
        imgPhi_05.setOnClickListener(clickListener);
        imgPhi_06.setOnClickListener(clickListener);
        imgPhi_07.setOnClickListener(clickListener);
        imgPhi_08.setOnClickListener(clickListener);
        imgPhi_09.setOnClickListener(clickListener);
        imgPhi_10.setOnClickListener(clickListener);
        imgPhi_11.setOnClickListener(clickListener);
        imgPhi_12.setOnClickListener(clickListener);
        imgPhi_13.setOnClickListener(clickListener);
        imgPhi_14.setOnClickListener(clickListener);
        imgPhi_15.setOnClickListener(clickListener);
        imgPhi_16.setOnClickListener(clickListener);
        imgPhi_17.setOnClickListener(clickListener);
        imgPhi_18.setOnClickListener(clickListener);
        imgPhi_19.setOnClickListener(clickListener);
        imgPhi_20.setOnClickListener(clickListener);
        imgPhi_21.setOnClickListener(clickListener);
        imgPhi_22.setOnClickListener(clickListener);
        imgPhi_23.setOnClickListener(clickListener);
        imgPhi_24.setOnClickListener(clickListener);
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
