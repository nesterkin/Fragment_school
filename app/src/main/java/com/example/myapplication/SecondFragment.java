package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Ronnie Raymond on 22.07.2021
 */
public class SecondFragment extends Fragment {

    public static Fragment newInstance() {
        return new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> ((Callback) getActivity()).createThirdFragment());
    }

    interface Callback {
        void createThirdFragment();
    }
}
