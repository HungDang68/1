package vn.edu.usth.projectapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerNavigation extends FragmentStateAdapter {


    public ViewPagerNavigation(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position)
       {
           case 0:
               return new HomeFragment();
           default:
               return new HomeFragment();
       }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
