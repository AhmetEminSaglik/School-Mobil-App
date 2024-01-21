package com.example.testproject.restapi.student.abstracts;


import com.example.testproject.model.LoginCredentials;
import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApiStudentService {
    @GET(".")
    Call<RestApiResponse<List<Student>>> getAll();

    @POST("login/")
    Call<RestApiResponse<Student>> login(@Body LoginCredentials credentials);
}
