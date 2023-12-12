package com.emir.albayrak.ws.model.enums;

import lombok.Getter;

public enum EnumBranch {
    SCIENCE(1, "Science"),
    MATHEMATIC(2, "Mathematic"),
    LITERATURE(3, "Literature");
    @Getter
    private final int id;
    private final String name;

    EnumBranch(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
