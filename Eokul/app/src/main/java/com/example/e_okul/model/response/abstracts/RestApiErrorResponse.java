package com.example.e_okul.model.response.abstracts;

public class RestApiErrorResponse extends RestApiBaseResponse{
    private  final  String httpStatus;

    public RestApiErrorResponse(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
