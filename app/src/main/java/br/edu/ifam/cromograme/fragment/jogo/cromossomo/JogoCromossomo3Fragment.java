package br.edu.ifam.cromograme.fragment.jogo.cromossomo;


import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.CorrectAlertFragment;
import br.edu.ifam.cromograme.fragment.WrongAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoCromossomo3Fragment extends Fragment {


    public JogoCromossomo3Fragment() {
        // Required empty public constructor
    }

    private TextView textViewAcrocentrico, textViewTelocentrico, textViewMetacentrico, textViewSubmetacentrico;
    private TextView textViewAcrocentricoResposta, textViewTelocentricoResposta, textViewMetacentricoResposta, textViewSubmetacentricoResposta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_cromossomo3, container, false);
        final TextView textView = getActivity().findViewById(R.id.textViewQuestaoCromossomo);
        textView.setText("Questão: 3/8");

        // Config dos text views.
        textViewAcrocentrico = view.findViewById(R.id.textViewAcrocentrico);
        textViewAcrocentrico.setOnLongClickListener(longClickListener);
        textViewAcrocentrico.setOnClickListener(clickListener);
        textViewAcrocentricoResposta = view.findViewById(R.id.textViewAcrocentricoResposta);
        textViewAcrocentricoResposta.setOnDragListener(dragListener);

        textViewTelocentrico = view.findViewById(R.id.textViewTelocentrico);
        textViewTelocentrico.setOnLongClickListener(longClickListener);
        textViewTelocentrico.setOnClickListener(clickListener);
        textViewTelocentricoResposta = view.findViewById(R.id.textViewTelocentricoResposta);
        textViewTelocentricoResposta.setOnDragListener(dragListener);

        textViewMetacentrico = view.findViewById(R.id.textViewMetacentrico);
        textViewMetacentrico.setOnLongClickListener(longClickListener);
        textViewMetacentrico.setOnClickListener(clickListener);
        textViewMetacentricoResposta = view.findViewById(R.id.textViewMetacentricoResposta);
        textViewMetacentricoResposta.setOnDragListener(dragListener);

        textViewSubmetacentrico = view.findViewById(R.id.textViewSubmetacentrico);
        textViewSubmetacentrico.setOnLongClickListener(longClickListener);
        textViewSubmetacentrico.setOnClickListener(clickListener);
        textViewSubmetacentricoResposta = view.findViewById(R.id.textViewSubmetacrentricoResposta);
        textViewSubmetacentricoResposta.setOnDragListener(dragListener);

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

                if (textViewAcrocentrico.getText().equals(textViewAcrocentricoResposta.getText()) &&
                        textViewMetacentrico.getText().equals(textViewMetacentricoResposta.getText()) &&
                        textViewTelocentrico.getText().equals(textViewTelocentricoResposta.getText()) &&
                        textViewSubmetacentrico.getText().equals(textViewSubmetacentricoResposta.getText())) {
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
                transaction.replace(R.id.frameLayoutJogoCromossomo, new JogoCromossomo4Fragment());
                transaction.commit();
            }
        });

        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
        }
    };

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    View view = (View) event.getLocalState();
                    TextView textView = (TextView) view;

                    TextView tv = (TextView) v;

                    if (tv.getText().equals("Arraste Aqui!")) {
                        tv.setText(textView.getText());
                        view.setVisibility(View.GONE);
                    }

                    break;
            }

            return true;
        }
    };

}
