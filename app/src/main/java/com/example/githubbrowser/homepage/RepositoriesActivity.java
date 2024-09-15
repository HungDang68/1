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

public class RepositoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repositories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.backButton_repositories);
        backButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),R.string.back,Toast.LENGTH_SHORT).show();
            onBackPressed();
        });
        Spinner spinner1 = findViewById(R.id.open_menu_repositories);

        String[] items1 = {"All", "Archived", "Fork","Mirror", "Private", "Public", "Source", "Template"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner1.setAdapter(adapter1);
        setupSpinnerListener(spinner1,items1);
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