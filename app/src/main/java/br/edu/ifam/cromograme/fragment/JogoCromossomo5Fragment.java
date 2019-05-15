package br.edu.ifam.cromograme.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoCromossomo5Fragment extends Fragment {


    public JogoCromossomo5Fragment() {
        // Required empty public constructor
    }

    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_cromossomo5, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoCromossomo);
        textView.setText("Questão: 5/5");

        editText = view.findViewById(R.id.editTextCondensacao);

        Button button = getActivity().findViewById(R.id.buttonJogoCromossomoConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().toUpperCase().equals("CONDENSACÃO")) {
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

                getActivity().finish();
            }
        });
        return view;
    }

}
