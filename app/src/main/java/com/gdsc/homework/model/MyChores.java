package com.gdsc.homework.model;

public class MyChores {
    String role;
    String memo;
    String time;

    public MyChores(String role, String memo, String time) {
        this.role = role;
        this.memo = memo;
        this.time = time;
    }

    public String getRole() {
        return role;
    }

    public String getMemo() {
        return memo;
    }

    public String getTime() {
        return time;
    }
}
