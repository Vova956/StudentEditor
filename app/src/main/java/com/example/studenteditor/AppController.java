package com.example.studenteditor;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AppController {
    private ArrayList<Student> students;
    ArrayAdapter<String> arrayAdapter = null;
    private Student selectedStudent = null;

    private static AppController appController = new AppController();

    private AppController(){
        students = new ArrayList<>();
    }

    public static AppController getInstance(){
        return appController;
    }

    public int getStudentSize(){
        return students.size();
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public void appendStudent(Student student){
        students.add(student);
        updateAdapter();
    }

    public void setAdapter(ArrayAdapter<String> adapter){
        this.arrayAdapter = adapter;
    }

    private void updateAdapter(){
        if(arrayAdapter != null){
            arrayAdapter.clear();

            for (int i = 0; i < students.size(); i++) {
                arrayAdapter.add(students.get(i).toString());
            }

            arrayAdapter.notifyDataSetChanged();
        }
    }

    public void setSelectedStudent(int index){
        this.selectedStudent = students.get(index);
    }


    public Student getSelectedStudent(){
        return selectedStudent;
    }

    public void addMark(int mark){
        selectedStudent.addMark(mark);
        updateAdapter();
    }

    public void replaceMark(int index,int mark){
        selectedStudent.replace(index, mark);
    }




}
