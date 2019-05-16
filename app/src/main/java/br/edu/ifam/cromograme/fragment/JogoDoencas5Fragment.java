package br.edu.ifam.cromograme.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas5Fragment extends Fragment {


    public JogoDoencas5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas5, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 5/6");

        Button button = getActivity().findViewById(R.id.buttonJogoDoencasConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas6Fragment());
                transaction.commit();
            }
        });

        return view;
    }

}
