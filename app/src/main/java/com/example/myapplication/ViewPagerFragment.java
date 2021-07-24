package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Ronnie Raymond on 24.07.2021
 */
public class ViewPagerFragment extends Fragment {

    private static final String STRING_KEY = "STRING_KEY";
    public static final String LOG_TAG = "ViewPagerFragment";
    private TextView mTextView;
    private int mPos;

    public static ViewPagerFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(STRING_KEY, position);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView " + mPos);
        return inflater.inflate(R.layout.third_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onViewCreated " + mPos);
        mTextView = view.findViewById(R.id.text_view);
        mTextView.setText(String.valueOf(mPos));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mPos = getArguments().getInt(STRING_KEY);
        Log.d(LOG_TAG, "onAttach " + mPos);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate " + mPos);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart " + mPos);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume " + mPos);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause " + mPos);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop " + mPos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "onDestroyView " + mPos);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy " + mPos);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "onDetach " + mPos);
    }
}
