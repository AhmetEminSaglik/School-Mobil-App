package com.example.e_okul.restapi.student.abstracts;


import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;
import com.example.e_okul.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApiStudentService {
    @POST(".")
    Call<RestApiResponse<Student>> save(@Body Student student);

    @POST("login/")
    Call<RestApiResponse<Student>> login(@Body LoginCredentials credentials);

    @GET(".")
    Call<RestApiResponse<List<Student>>> getAll();

    @GET("{id}")
    Call<RestApiResponse<Student>> getById(@Path("id") int id);

    @DELETE("{id}")
    Call<RestApiResponse<Void>> delete(@Path("id") int id);



}
