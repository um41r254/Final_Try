package com.mid_banchers.final_try;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {
    Tab2 ad= new Tab2();
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0) {

            return new Tab1();
        }
         if (position==1) {
//             ad.setSet("yes");
            return ad;
        }
         if (position==2) {

            return new Tab3();
        }
        else
            return new Tab4();

    }

    @Override
    public int getItemCount() {
        return 4 ;
    }
}
