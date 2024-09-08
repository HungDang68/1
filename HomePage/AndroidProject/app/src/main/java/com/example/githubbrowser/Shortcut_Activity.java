package com.example.githubbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Shortcut_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_shortcut);
        ImageButton saveButton = findViewById(R.id.imageButton_shortcut_create);
        saveButton.setOnClickListener(v -> {
            Intent intent01 = new Intent(Shortcut_Activity.this, Create_Shortcuts_Activity.class);
            startActivity(intent01);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        ImageButton backButton = findViewById(R.id.backButton_Shortcuts_activity);
        backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

    }
}