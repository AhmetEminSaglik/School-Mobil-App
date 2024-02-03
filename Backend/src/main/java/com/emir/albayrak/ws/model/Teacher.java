package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id",
//        scope = Long.class)
public class Teacher extends User {
    @Column
    private String branch;
    @Column
    private String graduatedUniversity;
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Announcement> announcementList;

    public Teacher() {
        setRoleIdToUser();
    }

    @Override
    public void setRoleIdToUser() {
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
