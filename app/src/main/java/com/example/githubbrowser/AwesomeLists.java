package com.example.githubbrowser;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.Objects;


public class AwesomeLists extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_awesome_lists, container, false);
        Toolbar list_toolbar = view.findViewById(R.id.xml_toolbar_list);
        list_toolbar.setTitle("Awesome Lists");
        list_toolbar.setTitleTextColor(Color.BLACK);

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(list_toolbar);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        final Drawable upArrow = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_arrow_back_24);
        upArrow.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.black), PorterDuff.Mode.SRC_ATOP);

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }

        list_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity()!=null){
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

        return view;
    }
}