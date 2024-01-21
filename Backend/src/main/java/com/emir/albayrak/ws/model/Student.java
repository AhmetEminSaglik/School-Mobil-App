package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends User {
    private String no;
    private int parentId;

    @Override
    void setRoleId() {
        roleId = EnumUserRoleId.TEACHER.getId();
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", no='" + no +'\'' +
                ", parentId='" + parentId +'\'' +
                "}";
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
}
