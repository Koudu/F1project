package com.example.f1project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }
    private OnFragmentSendDataListener fragmentSendDataListener;
    String[] racingSeries = { "Формула-1", "Формула-2", "Формула-3", "IndyCar", "WEC"};
    String[] descriptions = {
            "Формула-1 (Formula 1, F1) — это самая высокая категория автогонок на открытых дорогах, организованная Международной автомобильной федерацией (FIA). Она считается вершиной автоспорта и привлекает большое количество зрителей и поклонников по всему миру. Самая престижная гонка - Гран-при Монако",
            "Формула-2 (Formula 2, F2) — это одна из самых значимых и популярных серий автогонок на открытых колесах, которая служит важной вехой на пути к Формуле-1. Она считается вторым уровнем в иерархии гонок после Формулы-1.",
            "Формула-3 (Formula-3, F3) — это одна из серий автогонок, представляющая собой младшую категорию по сравнению с Формулой-1 и Формулой-2. Она служит важной вехой для молодых гонщиков, стремящихся развивать свои карьеры в профессиональном автоспорте.",
            "IndyCar — это американская серия автогонок, которая считается одной из самых высоких категорий гонок в Соединенных Штатах. Самая престижная гонка INDY-500",
            "WEC — WEC (World Endurance Championship) — это чемпионат мира по гонкам на выносливость, организованный Международной автомобильной федерацией (FIA). Этот чемпионат включает в себя гонки на длинные дистанции, где команды и гонщики соревнуются в различных классах автомобилей. Самая престижная гонка 24 Часа Ле-Мана"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Button btnF1 = view.findViewById(R.id.button1);
        Button btnF2 = view.findViewById(R.id.button2);
        Button btnF3 = view.findViewById(R.id.button3);
        Button btnIndy = view.findViewById(R.id.button4);
        Button btnWec = view.findViewById(R.id.button5);

        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Formula1.class);
                startActivity(intent);
            }
        });
        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Formula2.class);
                startActivity(intent);
            }
        });
        btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Formula3.class);
                startActivity(intent);
            }
        });

        btnIndy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IndyCar.class);
                startActivity(intent);
        }
    });
        btnWec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WEC.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void sendDescription(int position) {
        if (fragmentSendDataListener != null) {
            String selectedDescription = descriptions[position];
            fragmentSendDataListener.onSendData(selectedDescription);
        }
    }
}