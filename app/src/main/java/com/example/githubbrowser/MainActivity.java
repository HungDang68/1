package com.example.githubbrowser;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mviewPager;
    private BottomNavigationView mbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mviewPager = findViewById(R.id.view_pager);
        mbottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerNavigation adapter = new ViewPagerNavigation(getSupportFragmentManager(), getLifecycle());
        mviewPager.setAdapter(adapter);

        mviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
             switch (position)
             {
                 case 0:
                     mbottomNavigationView.getMenu().findItem(R.id.menu_tab_1).setChecked(true);
                     break;
                 case 1:
                     mbottomNavigationView.getMenu().findItem(R.id.menu_tab_2).setChecked(true);
                     break;
                 case 2:
                     mbottomNavigationView.getMenu().findItem(R.id.menu_tab_3).setChecked(true);
                     break;
                 case 3:
                     mbottomNavigationView.getMenu().findItem(R.id.menu_tab_4).setChecked(true);
                     break;

             }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        mbottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_tab_1) {
                    mviewPager.setCurrentItem(0, true);
                    return true;
                }
                if (item.getItemId() == R.id.menu_tab_2) {
                    mviewPager.setCurrentItem(1, true);
                    return true;
                }
                if (item.getItemId() == R.id.menu_tab_3) {
                    mviewPager.setCurrentItem(2, true);
                    return true;
                }
                if (item.getItemId() == R.id.menu_tab_4) {
                    mviewPager.setCurrentItem(3, true);
                    return true;
                }
                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}