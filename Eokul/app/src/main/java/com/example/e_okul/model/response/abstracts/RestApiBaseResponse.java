package com.example.e_okul.model.response.abstracts;

public abstract class RestApiBaseResponse {
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
