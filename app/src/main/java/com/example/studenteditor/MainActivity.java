package com.example.studenteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addStudentButton);
        studentListView = findViewById(R.id.studentListView);

        ArrayList<String> tableData = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tableData);
        studentListView.setAdapter(arrayAdapter);

        AppController.getInstance().setAdapter(arrayAdapter);


        Intent addStudentActivity = new Intent(this,addActivity.class);
        addButton.setOnClickListener(evt->{
            startActivity(addStudentActivity);
        });

        Intent editActivity = new Intent(this,EditActivity.class);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppController.getInstance().setSelectedStudent(position);
                startActivity(editActivity);
            }
        });


    }
}