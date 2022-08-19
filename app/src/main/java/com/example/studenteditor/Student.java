package com.example.studenteditor;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private ArrayList<Integer> marks;

    public Student(){
        name = "";
        surname = "";
        marks = new ArrayList<>();
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(name).append(" ").append(surname).append(" ");
        for (int i = 0; i < marks.size(); i++) {
            stringBuilder.append(marks.get(i));
            if(i < marks.size()-1)
                stringBuilder.append(",");
        }

        return stringBuilder.toString();
    }

    public void addMark(int mark){
        marks.add(mark);
    }

    public void replace(int index,int mark){
        marks.set(index,mark);
    }
}
