package com.example.githubbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button signInWithGithubButton = findViewById(R.id.signInWithGithubButton);
        signInWithGithubButton.setOnClickListener(v -> {
            Intent intent01 = new Intent(LoginActivity.this, SignInWithGithubActivity.class);
            startActivity(intent01);
        });
        Button button = findViewById(R.id.loginButtonEnterprise);
        button.setOnClickListener(v -> {
            Intent intent02 = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent02);
        });

    }
}