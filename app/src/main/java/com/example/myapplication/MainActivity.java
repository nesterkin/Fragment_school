package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

/**
 * @author Ronnie Raymond on 22.07.2021
 */
public class MainActivity extends AppCompatActivity implements SecondFragment.Callback, FirstFragment.Callback1 {

    private String mText;

    private ViewGroup mThirdContainer;
    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.first_fragment, FirstFragment.newInstance())
                .add(R.id.second_fragment, SecondFragment.newInstance())
                .commit();
    }

    @Override
    public void createThirdFragment() {
        createFragment();
        Fragment f3 = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (f3 == null) {
            f3 = ThirdFragment.newInstance(mText);
        } else {
            ((ThirdFragment) f3).setText(mText);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(mThirdContainer.getId(), f3, FRAGMENT_TAG)
                .commit();
    }

    private void createFragment() {
        ViewGroup root = findViewById(R.id.root);
        if (mThirdContainer == null) {
            mThirdContainer = new FragmentContainerView(this);
            mThirdContainer.setId(View.generateViewId());
            mThirdContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            root.addView(mThirdContainer);
        }
    }

    @Override
    public void setText(String text) {
        mText = text;
    }
}
