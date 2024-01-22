package com.example.testproject.restapi.teacher.abstracts;


import com.example.testproject.model.LoginCredentials;
import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApiTeacherService {
    @POST(".")
    Call<RestApiResponse<Teacher>> save(@Body Teacher teacher);

    @POST("login/")
    Call<RestApiResponse<Teacher>> login(@Body LoginCredentials credentials);

    @GET(".")
    Call<RestApiResponse<List<Teacher>>> getAll();

}
