package vn.edu.usth.projectapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StarredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_starred);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton searchButton = findViewById(R.id.search_button_starred);
        ImageButton backButton = findViewById(R.id.backButton_starred);
        TextView textView = findViewById(R.id.text_starred);
        EditText editText = findViewById(R.id.edit_text_starred);
        searchButton.setOnClickListener(view -> {
            editText.setVisibility(View.VISIBLE); // Show the EditText
            textView.setVisibility(View.GONE); // Hide the Search button
            editText.getText();
        });
        backButton.setOnClickListener(view -> onBackPressed());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
