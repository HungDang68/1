package com.example.githubbrowser;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateIssueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_issue);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton searchButton = findViewById(R.id.search_button_create_issue);
        ImageButton backButton = findViewById(R.id.backButton_create_issue);
        LinearLayout linearLayout = findViewById(R.id.layout_text_create_issue);
        EditText editText = findViewById(R.id.edit_text_create_issue);

        searchButton.setOnClickListener(view -> {
            editText.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
            editText.getText();
        });
        backButton.setOnClickListener(view -> onBackPressed());

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}