package com.example.githubbrowser.homepage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.githubbrowser.R;

public class IssueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_issue);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton searchButton = findViewById(R.id.search_button_issue);
        ImageButton backButton = findViewById(R.id.backButton_issue);
        TextView textView = findViewById(R.id.text_issue);
        EditText editText = findViewById(R.id.edit_text_issue);

        searchButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),R.string.search,Toast.LENGTH_SHORT).show();
            editText.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            editText.getText();
        });
        backButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), R.string.back, Toast.LENGTH_SHORT).show();
            onBackPressed();
        });

        Spinner spinner1 = findViewById(R.id.open_menu);
        Spinner spinner2 = findViewById(R.id.Created_menu);
        Spinner spinner3 = findViewById(R.id.visibility_menu);
        Spinner spinner4 = findViewById(R.id.organization_menu);
        Spinner spinner5 = findViewById(R.id.Repository_menu);
        Spinner spinner6 = findViewById(R.id.Sort_menu);

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

        setupSpinnerListener(spinner1, items1);
        setupSpinnerListener(spinner2, items2);
        setupSpinnerListener(spinner3, items3);
        setupSpinnerListener(spinner4, items4);
        setupSpinnerListener(spinner5, items5);
        setupSpinnerListener(spinner6, items6);

    }
    public void setupSpinnerListener(Spinner spinner, String[] items) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = items[i];
                Toast.makeText(getApplicationContext(), "Spinner: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}