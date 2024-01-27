package com.example.e_okul.restapi.teacher.abstracts;


import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.model.response.abstracts.RestApiResponse;

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
