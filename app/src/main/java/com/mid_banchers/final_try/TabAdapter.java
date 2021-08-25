package com.mid_banchers.final_try;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStateAdapter {
//    Tab2 ad= new Tab2();

    GeneralTab  generalTab ;

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0) {
            generalTab = new GeneralTab();
            generalTab.setTabName("Light");

            return generalTab;
        }
         if (position==1) {
//             ad.setSet("yes");
             generalTab = new GeneralTab();
             generalTab.setTabName("Dark");

             return generalTab;
        }
         if (position==2) {

             generalTab = new GeneralTab();
             generalTab.setTabName("Event");

             return generalTab;
        }
        else
             generalTab = new GeneralTab();
        generalTab.setTabName("Bridal");

        return generalTab;

    }

    @Override
    public int getItemCount() {
        return 4 ;
    }
}
