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
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApiStudentService {
    @POST(".")
    Call<RestApiResponse<Student>> save(@Body Student student);

    @POST("login/")
    Call<RestApiResponse<Student>> login(@Body LoginCredentials credentials);

    @GET("username/{username}/")
    Call<RestApiResponse<Student>> getStudentByUsername(@Path("username") String username);

    @GET(".")
    Call<RestApiResponse<List<Student>>> getAll();

    @GET("no/{no}/")
    Call<RestApiResponse<Student>> getByNo(@Path("no") int no);

    @DELETE("{no}/")
    Call<RestApiResponse<Void>> delete(@Path("no") String no);

    @PUT(".")
    Call<RestApiResponse<Student>> update(@Body Student student);



}
