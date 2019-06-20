package br.edu.ifam.cromograme.fragment.jogo.numerico;


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
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ifam.cromograme.R;
import br.edu.ifam.cromograme.fragment.CorrectAlertFragment;
import br.edu.ifam.cromograme.fragment.WrongAlertFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogoDoencas6Fragment extends Fragment {


    public JogoDoencas6Fragment() {
        // Required empty public constructor
    }

    // Imagens do ScrollView
    private ImageView pa_01, pa_02, pa_03, pa_04, pa_05;
    private ImageView pa_06, pa_07, pa_08, pa_09, pa_10;
    private ImageView pa_11, pa_12, pa_13, pa_14, pa_15;
    private ImageView pa_16, pa_17, pa_18, pa_19, pa_20;
    private ImageView pa_21, pa_22, pa_23, pa_24;

    // Imagens de Respostas
    private ImageView imgPa_01, imgPa_02, imgPa_03, imgPa_04, imgPa_05;
    private ImageView imgPa_06, imgPa_07, imgPa_08, imgPa_09, imgPa_10;
    private ImageView imgPa_11, imgPa_12, imgPa_13, imgPa_14, imgPa_15;
    private ImageView imgPa_16, imgPa_17, imgPa_18, imgPa_19, imgPa_20;
    private ImageView imgPa_21, imgPa_22, imgPa_23, imgPa_24;

    // Variável de controle
    private int selected = 0;
    private View viewSelected = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogo_doencas6, container, false);
        TextView textView = getActivity().findViewById(R.id.textViewQuestaoDoencas);
        textView.setText("Questão: 3/10");

        initImgScrollView(view);
        initImgResposta(view);

        Button buttonDesistir = getActivity().findViewById(R.id.buttonJogoDoencasDesistir);
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

        Button button = getActivity().findViewById(R.id.buttonJogoDoencasConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (acertou() && !hasClickers()) {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View viewRoot = inflater.inflate(R.layout.fragment_certo_doenca, null);
                    TextView tv = viewRoot.findViewById(R.id.textViewNomeDoenca);
                    tv.setText("Patau");
                    ImageView imgResposta = viewRoot.findViewById(R.id.imageViewAcertou);
                    imgResposta.setImageResource(R.drawable.patau);
                    builder.setView(viewRoot);
                    builder.setTitle("");
                    builder.setIcon(R.drawable.resposta_certa);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas7Fragment());
                            transaction.commit();
                        }
                    });
                    builder.create().show();
                } else {
                    DialogFragment dialogFragment = new WrongAlertFragment();
                    dialogFragment.setCancelable(false);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayoutJogoDoencas, new JogoDoencas7Fragment());
                    dialogFragment.show(transaction, "");
                }
            }
        });

        ImageView img = getActivity().findViewById(R.id.imageViewDica);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.dica_glow);
                builder.setTitle("Dica");
                builder.setMessage("Acomete principalmente o sexo feminino\nÉ uma trissomia");
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        return view;
    }

    private boolean acertou() {
        if (imgPa_01.getDrawable().equals(R.drawable.pa_01)
                && imgPa_02.getDrawable().equals(R.drawable.pa_02)
                && imgPa_03.getDrawable().equals(R.drawable.pa_03)
                && imgPa_04.getDrawable().equals(R.drawable.pa_04)
                && imgPa_05.getDrawable().equals(R.drawable.pa_05)
                && imgPa_06.getDrawable().equals(R.drawable.pa_06)
                && imgPa_07.getDrawable().equals(R.drawable.pa_07)
                && imgPa_08.getDrawable().equals(R.drawable.pa_08)
                && imgPa_09.getDrawable().equals(R.drawable.pa_09)
                && imgPa_10.getDrawable().equals(R.drawable.pa_10)
                && imgPa_11.getDrawable().equals(R.drawable.pa_11)
                && imgPa_12.getDrawable().equals(R.drawable.pa_12)
                && imgPa_13.getDrawable().equals(R.drawable.pa_13)
                && imgPa_14.getDrawable().equals(R.drawable.pa_14)
                && imgPa_15.getDrawable().equals(R.drawable.pa_15)
                && imgPa_16.getDrawable().equals(R.drawable.pa_16)
                && imgPa_17.getDrawable().equals(R.drawable.pa_17)
                && imgPa_18.getDrawable().equals(R.drawable.pa_18)
                && imgPa_19.getDrawable().equals(R.drawable.pa_19)
                && imgPa_20.getDrawable().equals(R.drawable.pa_20)
                && imgPa_21.getDrawable().equals(R.drawable.pa_21)
                && imgPa_22.getDrawable().equals(R.drawable.pa_22)
                && imgPa_23.getDrawable().equals(R.drawable.pa_23)
                && imgPa_24.getDrawable().equals(R.drawable.pa_24)) return true;
        else return false;
    }

    private boolean hasClickers() {
        if (imgPa_01.hasOnClickListeners()
                || imgPa_02.hasOnClickListeners()
                || imgPa_03.hasOnClickListeners()
                || imgPa_04.hasOnClickListeners()
                || imgPa_05.hasOnClickListeners()
                || imgPa_06.hasOnClickListeners()
                || imgPa_07.hasOnClickListeners()
                || imgPa_08.hasOnClickListeners()
                || imgPa_09.hasOnClickListeners()
                || imgPa_10.hasOnClickListeners()
                || imgPa_11.hasOnClickListeners()
                || imgPa_12.hasOnClickListeners()
                || imgPa_13.hasOnClickListeners()
                || imgPa_14.hasOnClickListeners()
                || imgPa_15.hasOnClickListeners()
                || imgPa_16.hasOnClickListeners()
                || imgPa_17.hasOnClickListeners()
                || imgPa_18.hasOnClickListeners()
                || imgPa_19.hasOnClickListeners()
                || imgPa_20.hasOnClickListeners()
                || imgPa_21.hasOnClickListeners()
                || imgPa_22.hasOnClickListeners()
                || imgPa_23.hasOnClickListeners()
                || imgPa_24.hasOnClickListeners()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void initImgScrollView(View view) {
        pa_01 = view.findViewById(R.id.pa_01);
        pa_02 = view.findViewById(R.id.pa_02);
        pa_03 = view.findViewById(R.id.pa_03);
        pa_04 = view.findViewById(R.id.pa_04);
        pa_05 = view.findViewById(R.id.pa_05);
        pa_06 = view.findViewById(R.id.pa_06);
        pa_07 = view.findViewById(R.id.pa_07);
        pa_08 = view.findViewById(R.id.pa_08);
        pa_09 = view.findViewById(R.id.pa_09);
        pa_10 = view.findViewById(R.id.pa_10);
        pa_11 = view.findViewById(R.id.pa_11);
        pa_12 = view.findViewById(R.id.pa_12);
        pa_13 = view.findViewById(R.id.pa_13);
        pa_14 = view.findViewById(R.id.pa_14);
        pa_15 = view.findViewById(R.id.pa_15);
        pa_16 = view.findViewById(R.id.pa_16);
        pa_17 = view.findViewById(R.id.pa_17);
        pa_18 = view.findViewById(R.id.pa_18);
        pa_19 = view.findViewById(R.id.pa_19);
        pa_20 = view.findViewById(R.id.pa_20);
        pa_21 = view.findViewById(R.id.pa_21);
        pa_22 = view.findViewById(R.id.pa_22);
        pa_23 = view.findViewById(R.id.pa_23);
        pa_24 = view.findViewById(R.id.pa_24);

        pa_01.setOnClickListener(clickListenerScrollView);
        pa_02.setOnClickListener(clickListenerScrollView);
        pa_03.setOnClickListener(clickListenerScrollView);
        pa_04.setOnClickListener(clickListenerScrollView);
        pa_05.setOnClickListener(clickListenerScrollView);
        pa_06.setOnClickListener(clickListenerScrollView);
        pa_07.setOnClickListener(clickListenerScrollView);
        pa_08.setOnClickListener(clickListenerScrollView);
        pa_09.setOnClickListener(clickListenerScrollView);
        pa_10.setOnClickListener(clickListenerScrollView);
        pa_11.setOnClickListener(clickListenerScrollView);
        pa_12.setOnClickListener(clickListenerScrollView);
        pa_13.setOnClickListener(clickListenerScrollView);
        pa_14.setOnClickListener(clickListenerScrollView);
        pa_15.setOnClickListener(clickListenerScrollView);
        pa_16.setOnClickListener(clickListenerScrollView);
        pa_17.setOnClickListener(clickListenerScrollView);
        pa_18.setOnClickListener(clickListenerScrollView);
        pa_19.setOnClickListener(clickListenerScrollView);
        pa_20.setOnClickListener(clickListenerScrollView);
        pa_21.setOnClickListener(clickListenerScrollView);
        pa_22.setOnClickListener(clickListenerScrollView);
        pa_23.setOnClickListener(clickListenerScrollView);
        pa_24.setOnClickListener(clickListenerScrollView);
    }

    private void initImgResposta(View view) {
        imgPa_01 = view.findViewById(R.id.imgPa_01);
        imgPa_02 = view.findViewById(R.id.imgPa_02);
        imgPa_03 = view.findViewById(R.id.imgPa_03);
        imgPa_04 = view.findViewById(R.id.imgPa_04);
        imgPa_05 = view.findViewById(R.id.imgPa_05);
        imgPa_06 = view.findViewById(R.id.imgPa_06);
        imgPa_07 = view.findViewById(R.id.imgPa_07);
        imgPa_08 = view.findViewById(R.id.imgPa_08);
        imgPa_09 = view.findViewById(R.id.imgPa_09);
        imgPa_10 = view.findViewById(R.id.imgPa_10);
        imgPa_11 = view.findViewById(R.id.imgPa_11);
        imgPa_12 = view.findViewById(R.id.imgPa_12);
        imgPa_13 = view.findViewById(R.id.imgPa_13);
        imgPa_14 = view.findViewById(R.id.imgPa_14);
        imgPa_15 = view.findViewById(R.id.imgPa_15);
        imgPa_16 = view.findViewById(R.id.imgPa_16);
        imgPa_17 = view.findViewById(R.id.imgPa_17);
        imgPa_18 = view.findViewById(R.id.imgPa_18);
        imgPa_19 = view.findViewById(R.id.imgPa_19);
        imgPa_20 = view.findViewById(R.id.imgPa_20);
        imgPa_21 = view.findViewById(R.id.imgPa_21);
        imgPa_22 = view.findViewById(R.id.imgPa_22);
        imgPa_23 = view.findViewById(R.id.imgPa_23);
        imgPa_24 = view.findViewById(R.id.imgPa_24);

        imgPa_01.setOnClickListener(clickListenerResposta);
        imgPa_02.setOnClickListener(clickListenerResposta);
        imgPa_03.setOnClickListener(clickListenerResposta);
        imgPa_04.setOnClickListener(clickListenerResposta);
        imgPa_05.setOnClickListener(clickListenerResposta);
        imgPa_06.setOnClickListener(clickListenerResposta);
        imgPa_07.setOnClickListener(clickListenerResposta);
        imgPa_08.setOnClickListener(clickListenerResposta);
        imgPa_09.setOnClickListener(clickListenerResposta);
        imgPa_10.setOnClickListener(clickListenerResposta);
        imgPa_11.setOnClickListener(clickListenerResposta);
        imgPa_12.setOnClickListener(clickListenerResposta);
        imgPa_13.setOnClickListener(clickListenerResposta);
        imgPa_14.setOnClickListener(clickListenerResposta);
        imgPa_15.setOnClickListener(clickListenerResposta);
        imgPa_16.setOnClickListener(clickListenerResposta);
        imgPa_17.setOnClickListener(clickListenerResposta);
        imgPa_18.setOnClickListener(clickListenerResposta);
        imgPa_19.setOnClickListener(clickListenerResposta);
        imgPa_20.setOnClickListener(clickListenerResposta);
        imgPa_21.setOnClickListener(clickListenerResposta);
        imgPa_22.setOnClickListener(clickListenerResposta);
        imgPa_23.setOnClickListener(clickListenerResposta);
        imgPa_24.setOnClickListener(clickListenerResposta);
    }

    View.OnClickListener clickListenerScrollView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pa_01.setBackgroundResource(0);
            pa_02.setBackgroundResource(0);
            pa_03.setBackgroundResource(0);
            pa_04.setBackgroundResource(0);
            pa_05.setBackgroundResource(0);
            pa_06.setBackgroundResource(0);
            pa_07.setBackgroundResource(0);
            pa_08.setBackgroundResource(0);
            pa_09.setBackgroundResource(0);
            pa_10.setBackgroundResource(0);
            pa_11.setBackgroundResource(0);
            pa_12.setBackgroundResource(0);
            pa_13.setBackgroundResource(0);
            pa_14.setBackgroundResource(0);
            pa_15.setBackgroundResource(0);
            pa_16.setBackgroundResource(0);
            pa_17.setBackgroundResource(0);
            pa_18.setBackgroundResource(0);
            pa_19.setBackgroundResource(0);
            pa_20.setBackgroundResource(0);
            pa_21.setBackgroundResource(0);
            pa_22.setBackgroundResource(0);
            pa_23.setBackgroundResource(0);
            pa_24.setBackgroundResource(0);

            pa_01.setSelected(false);
            pa_02.setSelected(false);
            pa_03.setSelected(false);
            pa_04.setSelected(false);
            pa_05.setSelected(false);
            pa_06.setSelected(false);
            pa_07.setSelected(false);
            pa_08.setSelected(false);
            pa_09.setSelected(false);
            pa_10.setSelected(false);
            pa_11.setSelected(false);
            pa_12.setSelected(false);
            pa_13.setSelected(false);
            pa_14.setSelected(false);
            pa_15.setSelected(false);
            pa_16.setSelected(false);
            pa_17.setSelected(false);
            pa_18.setSelected(false);
            pa_19.setSelected(false);
            pa_20.setSelected(false);
            pa_21.setSelected(false);
            pa_22.setSelected(false);
            pa_23.setSelected(false);
            pa_24.setSelected(false);

            v.setBackgroundResource(R.color.colorPrimary);
            v.setSelected(true);

            viewSelected = v;
            selected = v.getId();
        }
    };

    View.OnClickListener clickListenerResposta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ImageView iv = (ImageView) v;

            switch (selected) {
                case R.id.pa_01:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_01);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_02:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_02);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_03:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_03);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_04:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_04);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_05:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_05);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_06:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_06);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_07:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_07);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_08:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_08);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_09:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_09);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_10:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_10);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_11:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_11);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_12:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_12);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_13:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_13);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_14:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_14);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_15:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_15);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_16:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_16);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_17:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_17);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_18:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_18);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_19:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_19);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_20:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_20);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_21:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_21);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_22:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_22);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_23:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_23);
                    iv.setOnClickListener(null);
                    break;
                case R.id.pa_24:
                    viewSelected.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.pa_24);
                    iv.setOnClickListener(null);
                    break;
            }
            selected = 0;
        }
    };
}