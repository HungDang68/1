package com.example.githubbrowser.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.githubbrowser.R;
import com.example.githubbrowser.homepage.PullRequestsActivity;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View currentView = inflater.inflate(R.layout.fragment_profile, container, false);
        CardView Card1 = currentView.findViewById(R.id.Card1);
        CardView Card3 = currentView.findViewById(R.id.Card3);
        CardView Card2 = currentView.findViewById(R.id.Card2);

        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_card1 = new Intent(requireContext(), Card1_.class);
                startActivity(intent_card1);
            }
        });
        Card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_card2 = new Intent(requireContext(), Card2_.class);
                startActivity(intent_card2);
            }
        });
        Card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_card3 = new Intent(requireContext(), Card3_.class);
                startActivity(intent_card3);
            }
        });
        // setting up setting button
        ImageButton settingButton = currentView.findViewById(R.id.settingButton);
        if(settingButton != null){
            settingButton.setOnClickListener(v -> {
                Intent intent = new Intent(
                        requireContext(), SettingActivity.class
                );
                startActivity(intent);
            });
        }

        // Setting up follower button
        Button followerButton = currentView.findViewById(R.id.followerButton);
        if(followerButton != null){
            followerButton.setOnClickListener(v -> {
                Intent intent = new Intent(
                        requireContext(), FollowersActivity.class
                );
                startActivity(intent);
            });
        }

        // Setting up trophy button
        Button trophyButton = currentView.findViewById(R.id.trophyButton);
        if(trophyButton != null){
            trophyButton.setOnClickListener(v -> {
                Intent intent = new Intent(
                        requireContext(), TrophyActivity.class
                );
                startActivity(intent);
            });
        }

        // CREATE LIST VIEW
        // 1st listing view
        String[] leadingText = {"Repositories", "Started", "Organizations", "Projects"};
        String[] trailingText = {"0", "0", "0", "0"};
        Integer[] imgid = {R.drawable.repository, R.drawable.star, R.drawable.orgisation,R.drawable.project_icon};
        SettingListAdapter adapter = new SettingListAdapter(R.layout.listview_function_item, getActivity(), leadingText, trailingText, imgid);
        ListView listView = currentView.findViewById(R.id.functionListView);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnItems(listView);

        // set click on items
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent;
            switch (position){
                case 0:
                    intent = new Intent(
                            requireContext(), RepositoryActivity.class
                    );
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(
                            requireContext(), StarredRepoActivity.class
                    );
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(
                            requireContext(), OrganizationActivity.class
                    );
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(
                            requireContext(), ProjectsActivity.class
                    );
                    startActivity(intent);
                    break;
            }
        });

        // Inflate the layout for this fragment
        return currentView;
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