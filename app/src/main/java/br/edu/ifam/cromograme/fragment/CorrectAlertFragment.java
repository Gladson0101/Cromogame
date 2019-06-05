package br.edu.ifam.cromograme.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import br.edu.ifam.cromograme.R;

public class CorrectAlertFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View viewRoot = inflater.inflate(R.layout.fragment_certo, null);

        builder.setView(viewRoot);
        builder.setPositiveButton("Próximo", null);

        return builder.create();
    }
}
