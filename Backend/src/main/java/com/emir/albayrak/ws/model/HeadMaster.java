package com.emir.albayrak.ws.model;

import com.emir.albayrak.ws.model.enums.EnumUserRoleId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "headmasters")
public class HeadMaster extends User {
    @Override
    public void setRoleIdToUser() {
        roleId = EnumUserRoleId.HEADMASTER.getId();
    }

    @Override
    public String toString() {
        return "Headmaster{" + super.toString() + '\'' +
                "}";
    }
}
