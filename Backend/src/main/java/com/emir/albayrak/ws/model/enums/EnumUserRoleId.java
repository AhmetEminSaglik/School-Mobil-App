package com.emir.albayrak.ws.model.enums;

import lombok.Getter;

public enum EnumUserRoleId {
    HEADMASTER(1, "Headmaster"),
    TEACHER(2, "Student"),
    STUDENT(3, "Student");
    @Getter
    private final int id;
    private final String name;

    EnumUserRoleId(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
