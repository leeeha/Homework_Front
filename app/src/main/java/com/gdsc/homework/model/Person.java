package com.gdsc.homework.model;

import java.util.ArrayList;

public class Person {
    String name;
    ArrayList<String> workList;

    public Person(String name, ArrayList<String> workList) {
        this.name = name;
        this.workList = workList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWorkList() {
        return workList;
    }
}
