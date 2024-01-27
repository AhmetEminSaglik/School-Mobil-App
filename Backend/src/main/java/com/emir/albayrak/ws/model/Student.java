package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Student", uniqueConstraints = @UniqueConstraint(columnNames = "no"))
public class Student extends User {
    @Column
    private String no;
    @Column
    private int parentId;


    @Override
    public void setRoleIdToUser() {
        roleId = EnumUserRoleId.STUDENT.getId();
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", no='" + no + '\'' +
                ", parentId='" + parentId + '\'' +
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
