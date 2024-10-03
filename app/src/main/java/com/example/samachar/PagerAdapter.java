package com.example.samachar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    tabcount=behavior;
    }

    public PagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
     switch (position)
     {
         case 0: return new Homefragment();
         case 1: return new Sportsfragment();
         case 2: return new Healthfragment();
         case 3: return new Technologyfragment();
         case 4: return new Sciencefragment();
         case 5: return new entertainmentfragment();
         default: return null;
     }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
//public class PagerAdapter extends FragmentStateAdapter{
//    int tabcount;
//
//    public PagerAdapter(@NonNull FragmentManager fragmentActivity) {
//        super(fragmentActivity.getPrimaryNavigationFragment());
//        // super(fragmentActivity);
//    }
//
//
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position)
//     {
//         case 0: return new Homefragment();
//         case 1: return new Sportsfragment();
//         case 2: return new Healthfragment();
//         case 3: return new Technologyfragment();
//         case 4: return new Sciencefragment();
//         case 5: return new entertainmentfragment();
//         default: return null;
//     }
//    }
//
//    @Override
//    public int getItemCount() {
//        return tabcount;
//    }
//}