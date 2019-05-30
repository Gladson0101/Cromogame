package br.edu.ifam.cromograme.fragment;


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
import android.widget.RadioButton;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DivCelNivel3Fragment extends Fragment {


    public DivCelNivel3Fragment() {
        // Required empty public constructor
    }

    private RadioButton radioButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_div_cel_nivel3, container, false);

        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDivisaoCelular);
        textView.setText("Questão: 3/10");

        radioButton = view.findViewById(R.id.rbDivCerto3);

        Button buttonDesistir = getActivity().findViewById(R.id.buttonJogoDivisaoCelularDesistir);
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

        Button button = getActivity().findViewById(R.id.buttonJogoDivisaoCelularConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutJogoDivisaoCelular, new DivCelNivel4Fragment());
                transaction.commit();
            }
        });

        return view;    }

    public void resposta() {
        if (radioButton.isChecked()) {
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
    }

}
