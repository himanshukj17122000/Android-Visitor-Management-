package com.example.mockups;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int ntabs;

        public PagerAdapter(FragmentManager fm, int ntabs) {
            super(fm);
            this.ntabs = ntabs;
        }

        @Override
        public Fragment getItem(int i) {
            switch(i)
            {
                case 0:
                    phoone tab1= new phoone();
                    return tab1;
                case 1:
                   email tab2= new email();
                    return tab2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return ntabs;
        }
    }

