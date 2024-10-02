package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        EditText editText_ID;
//        EditText editTextName;
//        EditText editTextDateBirth;
//        EditText editTextSalary;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        editText_ID = findViewById(R.id.staff_id);
//        editTextName = findViewById(R.id.fullname);
//        editTextDateBirth = findViewById(R.id.birthdate);
//        editTextSalary = findViewById(R.id.salary);
//        Button buttonAddNewStaff = findViewById(R.id.button);
}