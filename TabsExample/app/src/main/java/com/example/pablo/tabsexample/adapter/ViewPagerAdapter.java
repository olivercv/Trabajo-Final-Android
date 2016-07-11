package com.example.pablo.tabsexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.pablo.tabsexample.PostFragment;

/**
 * Created by Pablo on 6/15/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PostFragment();
            case 1:
                return new Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
