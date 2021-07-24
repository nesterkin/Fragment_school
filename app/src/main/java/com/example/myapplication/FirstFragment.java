package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

/**
 * @author Ronnie Raymond on 22.07.2021
 */
public class FirstFragment extends Fragment {

    private EditText mEditText;
    private Button mButton;
    private Button mAdapterButton;

    public static Fragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mEditText = view.findViewById(R.id.edit_text);
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(v -> startActivity(ViewPagerActivity.newIntent(v.getContext())));
        mAdapterButton = view.findViewById(R.id.adapter_button);
        mAdapterButton.setOnClickListener(v -> new AlertDialog.Builder(v.getContext())
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Positive", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Negative", (dialog, which) -> dialog.dismiss())
                .setNeutralButton("Neutral", (dialog, which) -> dialog.dismiss())
                .setCancelable(false)
                .show());
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ((Callback1) getActivity()).setText(s.toString());
            }
        });
    }

    // public void setTextWatcher(TextWatcher textWatcher)

    interface Callback1 {
        void setText(String text);
    }
}
