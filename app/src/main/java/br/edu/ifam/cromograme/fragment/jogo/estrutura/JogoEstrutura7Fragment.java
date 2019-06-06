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
 *
 */
public class JogoEstrutura7Fragment extends Fragment {

    public JogoEstrutura7Fragment() {
        // Required empty public constructor
    }


    private ImageView imgPra_01, imgPra_02, imgPra_03, imgPra_04, imgPra_05;
    private ImageView imgPra_06, imgPra_07, imgPra_08, imgPra_09, imgPra_10;
    private ImageView imgPra_11, imgPra_12, imgPra_13, imgPra_14, imgPra_15;
    private ImageView imgPra_16, imgPra_17, imgPra_18, imgPra_19, imgPra_20;
    private ImageView imgPra_21, imgPra_22, imgPra_23, imgPra_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura7, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 7/9");

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
                    tv.setText("Prader Willi");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.pra_15);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura8Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura8Fragment());
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
                builder.setMessage("Encontre a deleção no cromossomo\nTrata-se de uma deleção paterna");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgPra_01.isSelected()
                && !imgPra_02.isSelected()
                && !imgPra_03.isSelected()
                && !imgPra_04.isSelected()
                && !imgPra_05.isSelected()
                && !imgPra_06.isSelected()
                && !imgPra_07.isSelected()
                && !imgPra_08.isSelected()
                && !imgPra_09.isSelected()
                && !imgPra_10.isSelected()
                && !imgPra_11.isSelected()
                && !imgPra_12.isSelected()
                && !imgPra_13.isSelected()
                && !imgPra_14.isSelected()
                && imgPra_15.isSelected()
                && !imgPra_16.isSelected()
                && !imgPra_17.isSelected()
                && !imgPra_18.isSelected()
                && !imgPra_19.isSelected()
                && !imgPra_20.isSelected()
                && !imgPra_21.isSelected()
                && !imgPra_22.isSelected()
                && !imgPra_23.isSelected()
                && !imgPra_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgPra_01 = view.findViewById(R.id.imgPra_01);
        imgPra_02 = view.findViewById(R.id.imgPra_02);
        imgPra_03 = view.findViewById(R.id.imgPra_03);
        imgPra_04 = view.findViewById(R.id.imgPra_04);
        imgPra_05 = view.findViewById(R.id.imgPra_05);
        imgPra_06 = view.findViewById(R.id.imgPra_06);
        imgPra_07 = view.findViewById(R.id.imgPra_07);
        imgPra_08 = view.findViewById(R.id.imgPra_08);
        imgPra_09 = view.findViewById(R.id.imgPra_09);
        imgPra_10 = view.findViewById(R.id.imgPra_10);
        imgPra_11 = view.findViewById(R.id.imgPra_11);
        imgPra_12 = view.findViewById(R.id.imgPra_12);
        imgPra_13 = view.findViewById(R.id.imgPra_13);
        imgPra_14 = view.findViewById(R.id.imgPra_14);
        imgPra_15 = view.findViewById(R.id.imgPra_15);
        imgPra_16 = view.findViewById(R.id.imgPra_16);
        imgPra_17 = view.findViewById(R.id.imgPra_17);
        imgPra_18 = view.findViewById(R.id.imgPra_18);
        imgPra_19 = view.findViewById(R.id.imgPra_19);
        imgPra_20 = view.findViewById(R.id.imgPra_20);
        imgPra_21 = view.findViewById(R.id.imgPra_21);
        imgPra_22 = view.findViewById(R.id.imgPra_22);
        imgPra_23 = view.findViewById(R.id.imgPra_23);
        imgPra_24 = view.findViewById(R.id.imgPra_24);

        imgPra_01.setOnClickListener(clickListener);
        imgPra_02.setOnClickListener(clickListener);
        imgPra_03.setOnClickListener(clickListener);
        imgPra_04.setOnClickListener(clickListener);
        imgPra_05.setOnClickListener(clickListener);
        imgPra_06.setOnClickListener(clickListener);
        imgPra_07.setOnClickListener(clickListener);
        imgPra_08.setOnClickListener(clickListener);
        imgPra_09.setOnClickListener(clickListener);
        imgPra_10.setOnClickListener(clickListener);
        imgPra_11.setOnClickListener(clickListener);
        imgPra_12.setOnClickListener(clickListener);
        imgPra_13.setOnClickListener(clickListener);
        imgPra_14.setOnClickListener(clickListener);
        imgPra_15.setOnClickListener(clickListener);
        imgPra_16.setOnClickListener(clickListener);
        imgPra_17.setOnClickListener(clickListener);
        imgPra_18.setOnClickListener(clickListener);
        imgPra_19.setOnClickListener(clickListener);
        imgPra_20.setOnClickListener(clickListener);
        imgPra_21.setOnClickListener(clickListener);
        imgPra_22.setOnClickListener(clickListener);
        imgPra_23.setOnClickListener(clickListener);
        imgPra_24.setOnClickListener(clickListener);
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
