package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends User {
    private String branch;
    private String graduatedUniversity;

    @Override
    void setRoleId() {
        setRoleId(EnumUserRoleId.TEACHER.getId());
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                ", branch='" + branch +'\'' +
                ", graduatedUniversity='" + graduatedUniversity +'\'' +
                "}";
    }
}
