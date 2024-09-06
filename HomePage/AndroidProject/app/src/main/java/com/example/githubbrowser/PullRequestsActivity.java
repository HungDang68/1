package com.example.githubbrowser;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PullRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pull_requests);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton searchButton = findViewById(R.id.search_button_pull_requests);
        ImageButton backButton = findViewById(R.id.backButton_pull_requests);
        TextView textView = findViewById(R.id.text_pull_requests);
        EditText editText = findViewById(R.id.edit_text_pull_requests);
        searchButton.setOnClickListener(view -> {
            editText.setVisibility(View.VISIBLE); // Show the EditText
            textView.setVisibility(View.GONE); // Hide the Search button
            editText.getText();
        });
        backButton.setOnClickListener(view -> onBackPressed());
        Spinner spinner1 = findViewById(R.id.open_menu_pull_quests);
        Spinner spinner2 = findViewById(R.id.Created_menu_pull_requests);
        Spinner spinner3 = findViewById(R.id.visibility_menu_pull_request);
        Spinner spinner4 = findViewById(R.id.organization_menu_pull_requests);
        Spinner spinner5 = findViewById(R.id.Repository_menu_pull_requests);
        Spinner spinner6 = findViewById(R.id.Sort_menu_pull_requests);

        String[] items1 = {"Open", "Closed", "All"};
        String[] items2 = {"Created by me", "Assigned to me", "Mentions me", "Involved"};
        String[] items3 = {"Show all", "Private repositories", "Public repositories only"};
        String[] items4 = {"Organization"};
        String[] items5 = {"Repository"};
        String[] items6 = {"Sort: Newest"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items6);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);
        spinner6.setAdapter(adapter6);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
