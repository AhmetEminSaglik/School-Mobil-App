package com.example.e_okul.model;


public enum EnumBranch {
    SCIENCE(1, "Science"),
    MATHEMATIC(2, "Mathematic"),
    LITERATURE(3, "Literature");
    private final int id;
    private final String name;

    EnumBranch(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
