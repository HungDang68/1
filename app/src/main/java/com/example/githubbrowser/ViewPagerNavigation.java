package com.example.githubbrowser;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.githubbrowser.homepage.HomeFragment;
import com.example.githubbrowser.notification.NotificationFragment;
import com.example.githubbrowser.profile.ProfileFragment;

public class ViewPagerNavigation extends FragmentStateAdapter {

    public ViewPagerNavigation(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position)
       {
           case 1:
               return new NotificationFragment();
           case 2:
               return new ExploreFragment();
           case 3:
                return new ProfileFragment();
           case 0:
           default:
               return new HomeFragment();
       }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
