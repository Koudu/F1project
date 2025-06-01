package com.example.f1project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private TextView detailsText;
    private String currentText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailsText = view.findViewById(R.id.detailsText);

        // Восстановление состояния при пересоздании фрагмента
        if (savedInstanceState != null) {
            currentText = savedInstanceState.getString("currentText");
            detailsText.setText(currentText);
        }

        return view;
    }

    // Метод для обновления текста
    public void setSelectedItem(String selectedItem) {
        currentText = selectedItem; // Обновляем текущее значение
        detailsText.setText(currentText); // Устанавливаем текст в TextView
    }

    // Сохранение состояния
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentText", currentText);
    }
}