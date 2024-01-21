package com.example.testproject.restapi.user.abstracts;


import com.example.testproject.model.LoginCredentials;
import com.example.testproject.model.User;
import com.example.testproject.model.response.concrete.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApiUserService {
    @POST("login/")
    Call<LoginResponse> loginUser(@Body LoginCredentials credentials);
//    Call<RestApiResponse<List<Student>>> getAll();
}
