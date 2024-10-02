package com.example.prac_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputActivity extends AppCompatActivity {

    private EditText editTextName, editTextGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextName = findViewById(R.id.edit_text_name);
        editTextGPA = findViewById(R.id.edit_text_gpa);
        Button buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String gpa = editTextGPA.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("gpa", gpa);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
