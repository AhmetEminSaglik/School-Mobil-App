package com.example.testproject.model.response.abstracts;

public class RestApiErrorResponse extends RestApiBaseResponse{
    private  final  String httpStatus;

    public RestApiErrorResponse(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
