package br.edu.ifam.cromograme.fragment.jogo.cromossomo;


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
import br.edu.ifam.cromograme.fragment.CorrectLastAlertFragment;
import br.edu.ifam.cromograme.fragment.WrongLastAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas3Fragment extends Fragment {


    public JogoDoencas3Fragment() {
        // Required empty public constructor
    }

    private RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas3, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoCromossomo);
        textView.setText("Questão: 8/8");

        radioButton = view.findViewById(R.id.rbDoencasCerto3);

        Button buttonDesistir = getActivity().findViewById(R.id.buttonJogoCromossomoDesistir);
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

        Button button = getActivity().findViewById(R.id.buttonJogoCromossomoConfirmar);
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
