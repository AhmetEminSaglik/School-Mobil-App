package com.example.e_okul.model;

public class StudentResponse {

    private final String name;
    private final String surname;

    public StudentResponse(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
