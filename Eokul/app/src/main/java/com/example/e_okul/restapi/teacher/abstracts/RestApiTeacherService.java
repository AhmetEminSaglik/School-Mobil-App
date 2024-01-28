package com.example.e_okul.restapi.teacher.abstracts;


import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApiTeacherService {
    @POST(".")
    Call<RestApiResponse<Teacher>> save(@Body Teacher teacher);

    @POST("login/")
    Call<RestApiResponse<Teacher>> login(@Body LoginCredentials credentials);

    @GET(".")
    Call<RestApiResponse<List<Teacher>>> getAll();


    @PUT(".")
    Call<RestApiResponse<Teacher>> update(@Body Teacher teacher);

    @DELETE("{id}/")
    Call<RestApiResponse<Teacher>> delete(@Path("id") int id);

}
