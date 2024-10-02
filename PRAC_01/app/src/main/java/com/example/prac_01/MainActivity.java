    package com.example.prac_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity {

        private static final int REQUEST_CODE = 1;
        private TextView textViewResult;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button buttonStart = findViewById(R.id.button);
            textViewResult = findViewById(R.id.text_view_result);

            buttonStart.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            });
        }


        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
                String name = data.getStringExtra("name");
                String gpa = data.getStringExtra("gpa");
                textViewResult.setText("Họ và tên: " + name + "\nĐiểm GPA: " + gpa);
            }
        }
    }
