package com.gdsc.homework.model;

import java.util.ArrayList;

public class Person {
    String name;
    String nickName;
    ArrayList<String> workList;

    public Person(String name, String nickName, ArrayList<String> workList) {
        this.name = name;
        this.nickName = nickName;
        this.workList = workList;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public ArrayList<String> getWorkList() {
        return workList;
    }
}
