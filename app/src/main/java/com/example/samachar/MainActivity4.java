package com.example.samachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity4 extends AppCompatActivity {
TabLayout tabLayout;
TabItem mhome,mscience,mhealth,mtec,mentertainment,msports;
    PagerAdapter pagerAdapter;
Toolbar mtoolbar;
String api="6c052c42ae834af0a4edc5ca35d50bef";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mhome =findViewById(R.id.home);
        mhealth =findViewById(R.id.health);
        mscience =findViewById(R.id.science);
         mtec =findViewById(R.id.technology);
        mentertainment =findViewById(R.id.entertainment);
        msports=findViewById(R.id.sports);
        ViewPager viewPager=findViewById(R.id.fragmentContainer);

        tabLayout=findViewById(R.id.tablayout);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

     viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}