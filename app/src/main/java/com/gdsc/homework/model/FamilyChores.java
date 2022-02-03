package com.gdsc.homework.model;

public class FamilyChores {
    int imageResource;
    String role;
    String memo;
    String time;

    public FamilyChores(int imageResource, String role, String memo, String time) {
        this.imageResource = imageResource;
        this.role = role;
        this.memo = memo;
        this.time = time;
    }

    public int getImageResource() {
        return imageResource;
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
