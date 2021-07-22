package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Ronnie Raymond on 22.07.2021
 */
public class ThirdFragment extends Fragment {

    private TextView mTextView;

    private static final String STRING_KEY = "STRING_KEY";

    public static Fragment newInstance(String input) {
        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, input);
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        return thirdFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.third_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mTextView = view.findViewById(R.id.text_view);
        Bundle bundle = requireArguments();
        mTextView.setText(bundle.getString(STRING_KEY));
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}
