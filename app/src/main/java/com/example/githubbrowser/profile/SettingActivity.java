package com.example.githubbrowser.profile;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubbrowser.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        // Apply window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.setting_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setting up the back button
        Button backButton = findViewById(R.id.backToProfile);
        backButton.setOnClickListener(v -> finish());

        // 1st listing view
        String[] leadingText1 = {"Appearance", "App Icon", "App Language", "Notifications", "Code Option", "External Links"};
        String[] trailingText1 = {"Light", "Default", "English", "Setup Needed", "", ""};
        Integer[] imgid1 = {R.drawable.next, R.drawable.next, R.drawable.next, R.drawable.next, R.drawable.next, R.drawable.next};
        SettingListAdapter adapter1 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText1, trailingText1, imgid1);
        ListView settingListView1 = findViewById(R.id.settingListView1);
        settingListView1.setAdapter(adapter1);
        setListViewHeightBasedOnItems(settingListView1);


        // 2nd listing view
        String[] leadingText2 = {"Copilot", "GitHub Pro"};
        String[] trailingText2 = {"", ""};
        Integer[] imgid2 = {R.drawable.next, R.drawable.next};
        SettingListAdapter adapter2 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText2, trailingText2, imgid2);
        ListView settingListView2 = findViewById(R.id.settingListView2);
        settingListView2.setAdapter(adapter2);
        setListViewHeightBasedOnItems(settingListView2);

        // 3rd listing view
        String[] leadingText3 = {"Share FeedBack"};
        String[] trailingText3 = {""};
        Integer[] imgid3 = {R.drawable.share_feedbacks};
        SettingListAdapter adapter3 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText3, trailingText3, imgid3);
        ListView settingListView3 = findViewById(R.id.settingListView3);
        settingListView3.setAdapter(adapter3);
        setListViewHeightBasedOnItems(settingListView3);

        // 4th listing view
        String[] leadingText4 = {"Terms of Service", "Privacy Policy & Analytics"};
        String[] trailingText4 = {"",""};
        Integer[] imgid4 = {R.drawable.next, R.drawable.next};
        SettingListAdapter adapter4 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText4, trailingText4, imgid4);
        ListView settingListView4 = findViewById(R.id.settingListView4);
        settingListView4.setAdapter(adapter4);
        setListViewHeightBasedOnItems(settingListView4);

        // 5th listing view
        String[] leadingText5 = {"Feature Preview"};
        String[] trailingText5 = {""};
        Integer[] imgid5 = {R.drawable.next};
        SettingListAdapter adapter5 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText5, trailingText5, imgid5);
        ListView settingListView5 = findViewById(R.id.settingListView5);
        settingListView5.setAdapter(adapter5);
        setListViewHeightBasedOnItems(settingListView5);

        // 6th listing view
        String[] leadingText6 = {"Manage Accounts", "App Lock"};
        String[] trailingText6 = {"", ""};
        Integer[] imgid6 = {R.drawable.next,R.drawable.next};
        SettingListAdapter adapter6 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText6, trailingText6, imgid6);
        ListView settingListView6 = findViewById(R.id.settingListView6);
        settingListView6.setAdapter(adapter6);
        setListViewHeightBasedOnItems(settingListView6);

        // 7th listing view
        String[] leadingText7 = {"Clear cache"};
        String[] trailingText7 = {"2.5 MB"};
        Integer[] imgid7 = {};
        SettingListAdapter adapter7 = new SettingListAdapter(R.layout.listview_setting_item, this, leadingText7, trailingText7, imgid7);
        ListView settingListView7 = findViewById(R.id.settingListView7);
        settingListView7.setAdapter(adapter7);
        setListViewHeightBasedOnItems(settingListView7);
    }

    public static void setListViewHeightBasedOnItems(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}