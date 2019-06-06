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
public class JogoEstrutura4Fragment extends Fragment {


    public JogoEstrutura4Fragment() {
        // Required empty public constructor
    }


    private ImageView imgMi_01, imgMi_02, imgMi_03, imgMi_04, imgMi_05;
    private ImageView imgMi_06, imgMi_07, imgMi_08, imgMi_09, imgMi_10;
    private ImageView imgMi_11, imgMi_12, imgMi_13, imgMi_14, imgMi_15;
    private ImageView imgMi_16, imgMi_17, imgMi_18, imgMi_19, imgMi_20;
    private ImageView imgMi_21, imgMi_22, imgMi_23, imgMi_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura4, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 4/9");

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
                    tv.setText("Miado de Gato");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.mi_05);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura5Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura5Fragment());
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

        if (!imgMi_01.isSelected()
                && !imgMi_02.isSelected()
                && !imgMi_03.isSelected()
                && !imgMi_04.isSelected()
                && imgMi_05.isSelected()
                && !imgMi_06.isSelected()
                && !imgMi_07.isSelected()
                && !imgMi_08.isSelected()
                && !imgMi_09.isSelected()
                && !imgMi_10.isSelected()
                && !imgMi_11.isSelected()
                && !imgMi_12.isSelected()
                && !imgMi_13.isSelected()
                && !imgMi_14.isSelected()
                && !imgMi_15.isSelected()
                && !imgMi_16.isSelected()
                && !imgMi_17.isSelected()
                && !imgMi_18.isSelected()
                && !imgMi_19.isSelected()
                && !imgMi_20.isSelected()
                && !imgMi_21.isSelected()
                && !imgMi_22.isSelected()
                && !imgMi_23.isSelected()
                && !imgMi_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgMi_01 = view.findViewById(R.id.imgMi_01);
        imgMi_02 = view.findViewById(R.id.imgMi_02);
        imgMi_03 = view.findViewById(R.id.imgMi_03);
        imgMi_04 = view.findViewById(R.id.imgMi_04);
        imgMi_05 = view.findViewById(R.id.imgMi_05);
        imgMi_06 = view.findViewById(R.id.imgMi_06);
        imgMi_07 = view.findViewById(R.id.imgMi_07);
        imgMi_08 = view.findViewById(R.id.imgMi_08);
        imgMi_09 = view.findViewById(R.id.imgMi_09);
        imgMi_10 = view.findViewById(R.id.imgMi_10);
        imgMi_11 = view.findViewById(R.id.imgMi_11);
        imgMi_12 = view.findViewById(R.id.imgMi_12);
        imgMi_13 = view.findViewById(R.id.imgMi_13);
        imgMi_14 = view.findViewById(R.id.imgMi_14);
        imgMi_15 = view.findViewById(R.id.imgMi_15);
        imgMi_16 = view.findViewById(R.id.imgMi_16);
        imgMi_17 = view.findViewById(R.id.imgMi_17);
        imgMi_18 = view.findViewById(R.id.imgMi_18);
        imgMi_19 = view.findViewById(R.id.imgMi_19);
        imgMi_20 = view.findViewById(R.id.imgMi_20);
        imgMi_21 = view.findViewById(R.id.imgMi_21);
        imgMi_22 = view.findViewById(R.id.imgMi_22);
        imgMi_23 = view.findViewById(R.id.imgMi_23);
        imgMi_24 = view.findViewById(R.id.imgMi_24);

        imgMi_01.setOnClickListener(clickListener);
        imgMi_02.setOnClickListener(clickListener);
        imgMi_03.setOnClickListener(clickListener);
        imgMi_04.setOnClickListener(clickListener);
        imgMi_05.setOnClickListener(clickListener);
        imgMi_06.setOnClickListener(clickListener);
        imgMi_07.setOnClickListener(clickListener);
        imgMi_08.setOnClickListener(clickListener);
        imgMi_09.setOnClickListener(clickListener);
        imgMi_10.setOnClickListener(clickListener);
        imgMi_11.setOnClickListener(clickListener);
        imgMi_12.setOnClickListener(clickListener);
        imgMi_13.setOnClickListener(clickListener);
        imgMi_14.setOnClickListener(clickListener);
        imgMi_15.setOnClickListener(clickListener);
        imgMi_16.setOnClickListener(clickListener);
        imgMi_17.setOnClickListener(clickListener);
        imgMi_18.setOnClickListener(clickListener);
        imgMi_19.setOnClickListener(clickListener);
        imgMi_20.setOnClickListener(clickListener);
        imgMi_21.setOnClickListener(clickListener);
        imgMi_22.setOnClickListener(clickListener);
        imgMi_23.setOnClickListener(clickListener);
        imgMi_24.setOnClickListener(clickListener);
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
