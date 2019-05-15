package br.edu.ifam.cromograme.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoCromossomo2Fragment extends Fragment {


    public JogoCromossomo2Fragment() {
        // Required empty public constructor
    }

    private ImageView imgCerto, imgErrado1, imgErrado2, imgErrado3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_jogo_cromossomo2, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoCromossomo);
        textView.setText("Questão: 2/5");

        imgCerto = view.findViewById(R.id.imageViewCerto);
        imgErrado1 = view.findViewById(R.id.imageViewErrado1);
        imgErrado2 = view.findViewById(R.id.imageViewErrado2);
        imgErrado3 = view.findViewById(R.id.imageViewErrado3);

        imgCerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCerto.setSelected(true);
                imgCerto.setBackgroundResource(R.color.colorAccent);

                imgErrado1.setSelected(false);
                imgErrado1.setBackgroundResource(0);

                imgErrado2.setSelected(false);
                imgErrado2.setBackgroundResource(0);

                imgErrado3.setSelected(false);
                imgErrado3.setBackgroundResource(0);
            }
        });

        imgErrado1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCerto.setSelected(false);
                imgCerto.setBackgroundResource(0);

                imgErrado1.setSelected(true);
                imgErrado1.setBackgroundResource(R.color.colorAccent);

                imgErrado2.setSelected(false);
                imgErrado2.setBackgroundResource(0);

                imgErrado3.setSelected(false);
                imgErrado3.setBackgroundResource(0);
            }
        });

        imgErrado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCerto.setSelected(false);
                imgCerto.setBackgroundResource(0);

                imgErrado1.setSelected(false);
                imgErrado1.setBackgroundResource(0);

                imgErrado2.setSelected(true);
                imgErrado2.setBackgroundResource(R.color.colorAccent);

                imgErrado3.setSelected(false);
                imgErrado3.setBackgroundResource(0);
            }
        });


        imgErrado3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCerto.setSelected(false);
                imgCerto.setBackgroundResource(0);

                imgErrado1.setSelected(false);
                imgErrado1.setBackgroundResource(0);

                imgErrado2.setSelected(false);
                imgErrado2.setBackgroundResource(0);

                imgErrado3.setSelected(true);
                imgErrado3.setBackgroundResource(R.color.colorAccent);
            }
        });


        Button button = getActivity().findViewById(R.id.buttonJogoCromossomoConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imgCerto.isSelected()) {
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
                transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo3Fragment());
                transaction.commit();
            }
        });

        return view;
    }

}
