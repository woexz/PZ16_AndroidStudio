package com.example.pz_16;

public class User {
    private String name;
    private String status;
    private int age;

    public User(String name, String status, int age) {
        this.name = name;
        this.status = status;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getAge() {
        return age;
    }
}

