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
public class JogoEstrutura3Fragment extends Fragment {


    public JogoEstrutura3Fragment() {
        // Required empty public constructor
    }


    private ImageView imgDu_01, imgDu_02, imgDu_03, imgDu_04, imgDu_05;
    private ImageView imgDu_06, imgDu_07, imgDu_08, imgDu_09, imgDu_10;
    private ImageView imgDu_11, imgDu_12, imgDu_13, imgDu_14, imgDu_15;
    private ImageView imgDu_16, imgDu_17, imgDu_18, imgDu_19, imgDu_20;
    private ImageView imgDu_21, imgDu_22, imgDu_23, imgDu_24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_estrutura3, container, false);

        initImgResposta(view);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoEstruturas);
        textView.setText("Questão: 3/9");

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
                transaction.replace(R.id.frameLayoutJogoEstruturas, new JogoEstrutura4Fragment());
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
                builder.setMessage("Encontre a duplicação no cromossomo");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean resposta() {

        if (!imgDu_01.isSelected()
                && !imgDu_02.isSelected()
                && !imgDu_03.isSelected()
                && !imgDu_04.isSelected()
                && !imgDu_05.isSelected()
                && !imgDu_06.isSelected()
                && !imgDu_07.isSelected()
                && !imgDu_08.isSelected()
                && !imgDu_09.isSelected()
                && !imgDu_10.isSelected()
                && !imgDu_11.isSelected()
                && !imgDu_12.isSelected()
                && !imgDu_13.isSelected()
                && !imgDu_14.isSelected()
                && !imgDu_15.isSelected()
                && !imgDu_16.isSelected()
                && !imgDu_17.isSelected()
                && !imgDu_18.isSelected()
                && !imgDu_19.isSelected()
                && !imgDu_20.isSelected()
                && !imgDu_21.isSelected()
                && imgDu_22.isSelected()
                && !imgDu_23.isSelected()
                && !imgDu_24.isSelected()
        ) return true;
        else return false;
    }

    private void initImgResposta(View view) {
        imgDu_01 = view.findViewById(R.id.imgDu_01);
        imgDu_02 = view.findViewById(R.id.imgDu_02);
        imgDu_03 = view.findViewById(R.id.imgDu_03);
        imgDu_04 = view.findViewById(R.id.imgDu_04);
        imgDu_05 = view.findViewById(R.id.imgDu_05);
        imgDu_06 = view.findViewById(R.id.imgDu_06);
        imgDu_07 = view.findViewById(R.id.imgDu_07);
        imgDu_08 = view.findViewById(R.id.imgDu_08);
        imgDu_09 = view.findViewById(R.id.imgDu_09);
        imgDu_10 = view.findViewById(R.id.imgDu_10);
        imgDu_11 = view.findViewById(R.id.imgDu_11);
        imgDu_12 = view.findViewById(R.id.imgDu_12);
        imgDu_13 = view.findViewById(R.id.imgDu_13);
        imgDu_14 = view.findViewById(R.id.imgDu_14);
        imgDu_15 = view.findViewById(R.id.imgDu_15);
        imgDu_16 = view.findViewById(R.id.imgDu_16);
        imgDu_17 = view.findViewById(R.id.imgDu_17);
        imgDu_18 = view.findViewById(R.id.imgDu_18);
        imgDu_19 = view.findViewById(R.id.imgDu_19);
        imgDu_20 = view.findViewById(R.id.imgDu_20);
        imgDu_21 = view.findViewById(R.id.imgDu_21);
        imgDu_22 = view.findViewById(R.id.imgDu_22);
        imgDu_23 = view.findViewById(R.id.imgDu_23);
        imgDu_24 = view.findViewById(R.id.imgDu_24);

        imgDu_01.setOnClickListener(clickListener);
        imgDu_02.setOnClickListener(clickListener);
        imgDu_03.setOnClickListener(clickListener);
        imgDu_04.setOnClickListener(clickListener);
        imgDu_05.setOnClickListener(clickListener);
        imgDu_06.setOnClickListener(clickListener);
        imgDu_07.setOnClickListener(clickListener);
        imgDu_08.setOnClickListener(clickListener);
        imgDu_09.setOnClickListener(clickListener);
        imgDu_10.setOnClickListener(clickListener);
        imgDu_11.setOnClickListener(clickListener);
        imgDu_12.setOnClickListener(clickListener);
        imgDu_13.setOnClickListener(clickListener);
        imgDu_14.setOnClickListener(clickListener);
        imgDu_15.setOnClickListener(clickListener);
        imgDu_16.setOnClickListener(clickListener);
        imgDu_17.setOnClickListener(clickListener);
        imgDu_18.setOnClickListener(clickListener);
        imgDu_19.setOnClickListener(clickListener);
        imgDu_20.setOnClickListener(clickListener);
        imgDu_21.setOnClickListener(clickListener);
        imgDu_22.setOnClickListener(clickListener);
        imgDu_23.setOnClickListener(clickListener);
        imgDu_24.setOnClickListener(clickListener);
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
