package com.example.studenteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.NamePlainText);
        surname = findViewById(R.id.SurnamePlainTet);
        add = findViewById(R.id.AddButton);

        add.setOnClickListener(evt->{
            AppController.getInstance().appendStudent(new Student(name.getText().toString(),surname.getText().toString()));
            finish();
        });



    }
}