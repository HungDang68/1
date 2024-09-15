package com.example.githubbrowser.notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.githubbrowser.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class NotificationFragment extends Fragment {
    private Button button1;
    private Button button2;
    private Button resetFiltersButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        button1 = view.findViewById(R.id.button_inbox_notification);
        button2 = view.findViewById(R.id.button_Repository_notification);
        resetFiltersButton = view.findViewById(R.id.btnResetFilters);

        // Reset Filters Button action
        resetFiltersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllFilters();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOpenBottomSheet();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOpenBottomSheet2();
            }
        });
        TextView textView1 = view.findViewById(R.id.text_notification_after_image);
        TextView textView2 = view.findViewById(R.id.text_long_notification);
        TextView textView3 = view.findViewById(R.id.text_unread_on);
        TextView textView4 = view.findViewById(R.id.text_unread_on_after_image);

        ToggleButton toggleButton = view.findViewById(R.id.button_Unread_notification);
        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked())
                {
                    textView1.setVisibility(View.GONE);
                    textView2.setVisibility(View.GONE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    resetFiltersButton.setVisibility(View.VISIBLE);
                }
                else {
                    textView4.setVisibility(View.GONE);
                    textView3.setVisibility(View.GONE);
                    textView2.setVisibility(View.VISIBLE);
                    textView1.setVisibility(View.VISIBLE);
                    resetFiltersButton.setVisibility(View.GONE);

                    resetAllFilters();
                }
            }
        });

        return view;
    }
    public void updateButtonText(String newText){
        button1.setText(newText);
    }
    private void clickOpenBottomSheet() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.layout_bottom_sheet, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        RadioGroup radioGroup = bottomSheetView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = bottomSheetView.findViewById(checkedId);
                String selectedText = radioButton.getText().toString();
                updateButtonText(selectedText);

                }
        });
        Button backButton = bottomSheetView.findViewById(R.id.backButton_bottom_sheet);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

    }
    private void clickOpenBottomSheet2()
    {
        View bottomSheetView2 = getLayoutInflater().inflate(R.layout.layout_bottom_sheet_2, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView2);
        bottomSheetDialog.show();
        Button backButton = bottomSheetView2.findViewById(R.id.backButton_bottom_sheet2);
        Button searchButton = bottomSheetView2.findViewById(R.id.button_search_notification);

        TextView textView1 = bottomSheetView2.findViewById(R.id.title_repoditory_notification);
        TextView textView2 = bottomSheetView2.findViewById(R.id.edit_text_repository_notification);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setVisibility(View.GONE);
                textView2.setVisibility(View.VISIBLE);

            }
        });
    }
    private void resetAllFilters() {
        TextView textViewAllCaughtUp = getView().findViewById(R.id.text_notification_after_image);
        TextView textViewTakeABreak = getView().findViewById(R.id.text_long_notification);
        TextView textViewNoNotifications = getView().findViewById(R.id.text_unread_on_after_image);
        TextView textViewUseFewerFilters = getView().findViewById(R.id.text_unread_on);

        // Reset all views to the original state
        textViewAllCaughtUp.setVisibility(View.VISIBLE);
        textViewTakeABreak.setVisibility(View.VISIBLE);
        textViewNoNotifications.setVisibility(View.GONE);
        textViewUseFewerFilters.setVisibility(View.GONE);

        // Hide the reset filters button again
        resetFiltersButton.setVisibility(View.GONE);

        // Reset the button text back to "Inbox"
        updateButtonText("Inbox");
    }
}