package com.zxj.jhentai.adapter;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NormalFragmentAdapter extends FragmentStateAdapter {

    private SparseArray<Fragment> fragments;

    public NormalFragmentAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public NormalFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void setFragment(SparseArray<Fragment> fragments){
        this.fragments = fragments;
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
