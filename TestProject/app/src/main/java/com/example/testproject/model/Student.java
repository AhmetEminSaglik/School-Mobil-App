package com.example.testproject.model;

public class Student extends User {
    private String no;
    private int parentId;

    @Override
    void setRoleId() {
        roleId = EnumUserRoleId.STUDENT.getId();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "no='" + no + '\'' +
                ", parentId=" + parentId +
                ", roleId=" + roleId +
                '}';
    }
}
