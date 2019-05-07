package br.edu.ifam.cromograme.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifam.cromograme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DivCelNivel1Fragment extends Fragment {


    public DivCelNivel1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_div_cel_nivel1, container, false);
    }

}
