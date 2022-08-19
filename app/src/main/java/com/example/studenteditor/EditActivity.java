package com.example.studenteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    Button add;
    Button edit;
    EditText text;
    ListView marks;
    int selected = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        add = findViewById(R.id.button_add);
        text = findViewById(R.id.MarkPlainText);
        edit = findViewById(R.id.button_edit);
        marks = findViewById(R.id.MarkList);

        ArrayList<String> tableData = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tableData);
        marks.setAdapter(arrayAdapter);

        add.setOnClickListener(evt->{
            AppController.getInstance().addMark(Integer.parseInt(text.getText().toString()));


            arrayAdapter.add(text.getText().toString());
            arrayAdapter.notifyDataSetChanged();
        });
        
        marks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
            }
        });
        
        edit.setOnClickListener(evt2 ->{
            if(selected != -1){
                AppController.getInstance().replaceMark(selected,Integer.parseInt(text.getText().toString()));
            }
        });

        

    }
}