package com.example.githubbrowser;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar searchButton = view.findViewById(R.id.toolbar_view_home_fragment);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(searchButton);

        View customView1 = view.findViewById(R.id.Issues);
        customView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(requireContext(), IssueActivity.class);
                startActivity(intent1);
            }
        });
        View customView2 = view.findViewById(R.id.Pull_Request);
        customView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(requireContext(), PullRequestsActivity.class);
                startActivity(intent2);
            }
        });
        View customView3 = view.findViewById(R.id.Discussion);
        customView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(requireContext(), DiscussionsActivity.class);
                startActivity(intent3);
            }
        });
        View customView4 = view.findViewById(R.id.Projects);
        customView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(requireContext(), ProjectActivity.class);
                startActivity(intent4);
            }
        });
        View customView5 = view.findViewById(R.id.repositories);
        customView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(requireContext(), RepositoriesActivity.class);
                startActivity(intent5);
            }
        });
        View customView6 = view.findViewById(R.id.Organizations);
        customView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(requireContext(), OrganizationsActivity.class);
                startActivity(intent6);
            }
        });
        View customView7 = view.findViewById(R.id.Starrted);
        customView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(requireContext(), StarredActivity.class);
                startActivity(intent7);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu_home_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Searching_button)
        {
            Intent intent = new Intent(requireContext(), SearchingActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId()== R.id.AddmoreButton)
        {
            Intent intent = new Intent(requireContext(), CreateIssueActivity.class );
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}