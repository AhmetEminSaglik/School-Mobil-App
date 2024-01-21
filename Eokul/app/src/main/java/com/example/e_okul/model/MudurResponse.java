package com.example.e_okul.model;

public class MudurResponse {
    private final String name;
    private final String surname;
    private final int password;

    public MudurResponse(String name, String surname, int password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public int getPassword(){return password;}

}
