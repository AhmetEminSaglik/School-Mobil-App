package com.example.e_okul.model;

public class Student {
    private final String name;
    private final String surname;
    private final long tc_kn;
    private final String parentName;
    private final int no;
    private final int password;


    public Student(String name, String surname, int no,int
                   password,long tc_kn, String parentName) {
        this.name = name;
        this.no = no;
        this.surname=surname;
        this.password=password;
        this.tc_kn=tc_kn;
        this.parentName=parentName;
    }



    public String getName() {
        return name;
    }
    public int getNo() {return no;}
    public String getSurname(){return surname;}
    public int getPassword(){return password;}
    public long getTc_kn() {return tc_kn;}
    public String getParentName() {return parentName;}


}
