package com.gdsc.homework.model;

import java.util.ArrayList;

public class MyChores {
    String roles;
    String date;

    public MyChores(String roles, String date) {
        this.roles = roles;
        this.date = date;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
