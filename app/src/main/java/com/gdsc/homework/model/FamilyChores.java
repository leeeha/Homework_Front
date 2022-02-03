package com.gdsc.homework.model;

public class FamilyChores {
    int imageResource;
    String roles;
    String date;

    public FamilyChores(int imageSource, String roles, String date) {
        this.imageResource = imageSource;
        this.roles = roles;
        this.date = date;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
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
