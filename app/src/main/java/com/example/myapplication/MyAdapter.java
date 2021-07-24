package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * @author Ronnie Raymond on 24.07.2021
 */
public class MyAdapter extends FragmentStateAdapter {

    private final int mCount;

    public MyAdapter(@NonNull FragmentActivity fragmentActivity, int count) {
        super(fragmentActivity);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ViewPagerFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return mCount;
    }
}
