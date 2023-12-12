package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student extends User {

    @Override
    void setRoleId() {
        setRoleId(EnumUserRoleId.STUDENT.getId());
    }
}
