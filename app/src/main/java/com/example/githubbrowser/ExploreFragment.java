package com.example.githubbrowser;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class ExploreFragment extends Fragment {
    ImageButton button_to_activity_view;
    FrameLayout fragmentContainerView3;
    boolean isFragmentOpen = false;


    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_explore, container, false);
        Toolbar titleBar = view.findViewById(R.id.xml_title_bar);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(titleBar);
        titleBar.setTitle("Explore");
        titleBar.setTitleTextColor(Color.BLACK);

        button_to_activity_view=view.findViewById(R.id.imageButton2);
        fragmentContainerView3 = view.findViewById(R.id.Frag_container_2);

        button_to_activity_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentOpen) {
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.setCustomAnimations(R.anim.slide_in_vertical,R.anim.slide_out_vertical);
                    transaction.add(R.id.Frag_container_2, new Activity_view());
                    transaction.commit();
                    isFragmentOpen = true;
                } else {
                    Fragment fragment = requireActivity().getSupportFragmentManager().findFragmentById(R.id.Frag_container_2);
                    if (fragmentContainerView3 != null) {
                        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.setCustomAnimations(R.anim.slide_in_vertical, R.anim.slide_out_vertical);
                        assert fragment != null;
                        transaction.remove(fragment);
                        transaction.commit();
                    }
                    isFragmentOpen = false;
                }
            }
        });


        Button button1 = view.findViewById(R.id.trending);
        Button button2 = view.findViewById(R.id.Lists);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out);
                transaction.replace(R.id.fragment_container, new Trending());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out);
                transaction.replace(R.id.fragment_container, new AwesomeLists());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }


}