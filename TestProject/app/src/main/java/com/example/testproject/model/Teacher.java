package com.example.testproject.model;

public class Teacher extends User {
    private String branch;
    private String graduatedUniversity;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGraduatedUniversity() {
        return graduatedUniversity;
    }

    public void setGraduatedUniversity(String graduatedUniversity) {
        this.graduatedUniversity = graduatedUniversity;
    }

    @Override
    public String toString() {
        return "Teacher{" + "User : " + super.toString() +
                "branch='" + branch + '\'' +
                ", graduatedUniversity='" + graduatedUniversity + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
