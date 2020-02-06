package com.zxj.jhentai;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zxj.jhentai.Entitys.RecommendIndicatorEntity;
import com.zxj.jhentai.adapter.NormalFragmentAdapter;



public class HomeCartoonFragment extends Fragment {

    private TabLayout tablayout;
    private ViewPager2 pager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tablayout = view.findViewById(R.id.tablayout);
        pager = view.findViewById(R.id.pager);
        NormalFragmentAdapter normalFragmentAdapter = new NormalFragmentAdapter(this);
        SparseArray<Fragment> fragments = new SparseArray<>();
        for (int i = 0; i < 6; i++) {
            RecommendChildFragment recommendChildFragment = new RecommendChildFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key", new RecommendIndicatorEntity("title" + i, ""));
            recommendChildFragment.setArguments(bundle);
            fragments.put(i, recommendChildFragment);
        }
        normalFragmentAdapter.setFragment(fragments);
        pager.setAdapter(normalFragmentAdapter);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView text = (TextView) tab.getCustomView();
                ValueAnimator animation = ValueAnimator.ofFloat(16f, 28f);
                animation.setDuration(300);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        text.setTextSize(animatedValue);
                    }
                });
                animation.start();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView text = (TextView) tab.getCustomView();
                ValueAnimator animation = ValueAnimator.ofFloat(28f, 16f);
                animation.setDuration(300);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        text.setTextSize(animatedValue);
                    }
                });
                animation.start();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        new TabLayoutMediator(tablayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setCustomView(R.layout.recommend_child_title);
                TextView text = (TextView) tab.getCustomView();
                RecommendIndicatorEntity key = (RecommendIndicatorEntity) (fragments
                        .get(position).getArguments()
                        .getParcelable("key"));
                text.setText(key.title);
            }
        }).attach();
    }
}
