package br.edu.ifam.cromograme.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DivCelNivel10Fragment extends Fragment {


    public DivCelNivel10Fragment() {
        // Required empty public constructor
    }

    private RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_div_cel_nivel10, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDivisaoCelular);
        textView.setText("Questão: 10/10");
        radioButton = view.findViewById(R.id.rbDivCerto10);
        Button button = getActivity().findViewById(R.id.buttonJogoDivisaoCelularConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta();
            }
        });

        return view;
    }

    public void resposta() {
        if (radioButton.isChecked()) {
            DialogFragment dialogFragment = new CorrectLastAlertFragment();
            dialogFragment.setCancelable(false);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            dialogFragment.show(transaction, "");
        } else {
            DialogFragment dialogFragment = new WrongLastAlertFragment();
            dialogFragment.setCancelable(false);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            dialogFragment.show(transaction, "");
        }
    }
}
