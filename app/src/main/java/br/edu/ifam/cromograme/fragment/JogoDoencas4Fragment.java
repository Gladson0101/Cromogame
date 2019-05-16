package br.edu.ifam.cromograme.fragment;


import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.DragEvent;
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
public class JogoDoencas4Fragment extends Fragment {


    public JogoDoencas4Fragment() {
        // Required empty public constructor
    }

    private TextView txtTurner01, txtTurner02, txtTurner03, txtTurner04, txtTurner05, txtTurner06, txtTurner07, txtTurner08;
    private ImageView imgTurner01, imgTurner02, imgTurner03, imgTurner04, imgTurner05, imgTurner06, imgTurner07, imgTurner08;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas4, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 4/6");

        initTxt(view);
        initImg(view);

        Button button = getActivity().findViewById(R.id.buttonJogoDoencasConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas5Fragment());
                transaction.commit();
            }
        });

        return view;
    }

    private void initTxt(View view) {
        txtTurner01 = view.findViewById(R.id.txtTurner01);
        txtTurner02 = view.findViewById(R.id.txtTurner02);
        txtTurner03 = view.findViewById(R.id.txtTurner03);
        txtTurner04 = view.findViewById(R.id.txtTurner04);
        txtTurner05 = view.findViewById(R.id.txtTurner05);
        txtTurner06 = view.findViewById(R.id.txtTurner06);
        txtTurner07 = view.findViewById(R.id.txtTurner07);
        txtTurner08 = view.findViewById(R.id.txtTurner08);

        txtTurner01.setOnDragListener(dragListener);
        txtTurner02.setOnDragListener(dragListener);
        txtTurner03.setOnDragListener(dragListener);
        txtTurner04.setOnDragListener(dragListener);
        txtTurner05.setOnDragListener(dragListener);
        txtTurner06.setOnDragListener(dragListener);
        txtTurner07.setOnDragListener(dragListener);
        txtTurner08.setOnDragListener(dragListener);

    }

    private void initImg(View view) {
        imgTurner01 = view.findViewById(R.id.imgTurner01);
        imgTurner02 = view.findViewById(R.id.imgTurner02);
        imgTurner03 = view.findViewById(R.id.imgTurner03);
        imgTurner04 = view.findViewById(R.id.imgTurner04);
        imgTurner05 = view.findViewById(R.id.imgTurner05);
        imgTurner06 = view.findViewById(R.id.imgTurner06);
        imgTurner07 = view.findViewById(R.id.imgTurner07);
        imgTurner08 = view.findViewById(R.id.imgTurner08);

        imgTurner01.setOnLongClickListener(longClickListener);
        imgTurner02.setOnLongClickListener(longClickListener);
        imgTurner03.setOnLongClickListener(longClickListener);
        imgTurner04.setOnLongClickListener(longClickListener);
        imgTurner05.setOnLongClickListener(longClickListener);
        imgTurner06.setOnLongClickListener(longClickListener);
        imgTurner07.setOnLongClickListener(longClickListener);
        imgTurner08.setOnLongClickListener(longClickListener);
    }

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

                    switch (view.getId()) {
                        case R.id.imgTurner01: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome01);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.imgTurner02: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome02);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.imgTurner03: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome03);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.txtTurner04: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome04);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.txtTurner05: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome05);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.txtTurner06: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome06);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.txtTurner07: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome07);
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.txtTurner08: {
                            TextView tv = (TextView) v;
                            tv.setText("");
                            tv.setBackgroundResource(R.drawable.turner_sindrome08);
                            view.setVisibility(View.GONE);
                        }
                        break;
                    }

                    break;
            }

            return true;
        }
    };

}
