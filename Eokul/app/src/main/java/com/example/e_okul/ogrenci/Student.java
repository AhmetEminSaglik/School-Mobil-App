package com.example.e_okul.ogrenci;

public class Student {
    private String name;
    private String surname;
    private int schoolNumber;

    public Student(String name, String surname, int schoolNumber) {
        this.name = name;
        this.schoolNumber = schoolNumber;
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }
    public String getSurname(){
        return surname;
    }
}
