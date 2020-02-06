package com.zxj.jhentai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.SparseArray;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zxj.jhentai.adapter.NormalFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 pager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tablayout);
        pager = findViewById(R.id.pager);
        NormalFragmentAdapter homeAdapter = new NormalFragmentAdapter(this);
        SparseArray<Fragment> fragments = new SparseArray<>();
        fragments.put(fragments.size(), new HomeCartoonFragment());
        fragments.put(fragments.size(), new HomeCartoonFragment());
        fragments.put(fragments.size(), new HomeCartoonFragment());
        fragments.put(fragments.size(), new HomeCartoonFragment());
        homeAdapter.setFragment(fragments);
        pager.setAdapter(homeAdapter);
        pager.setUserInputEnabled(false);
        new TabLayoutMediator(tablayout, pager,
                (tab, position) -> {
                    tab.setIcon(R.drawable.icon_recommend);
                    tab.setText(position + "");
                    tab.getOrCreateBadge().setNumber(position);

                }
        ).attach();
    }
}
