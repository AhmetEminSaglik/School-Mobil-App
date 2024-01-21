package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class Teacher extends User {
    private String branch;
    private String graduatedUniversity;

    public Teacher() {
        setRoleIdToUser();
    }

    @Override
    public  void setRoleIdToUser() {
        roleId = EnumUserRoleId.TEACHER.getId();
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                ", branch='" + branch + '\'' +
                ", graduatedUniversity='" + graduatedUniversity + '\'' +
                "}";
    }

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
}
