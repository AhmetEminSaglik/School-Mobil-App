package com.example.e_okul.restapi.user.abstracts;


import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.response.concrete.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApiUserService {
    @POST("login/")
    Call<LoginResponse> loginUser(@Body LoginCredentials credentials);
//    Call<RestApiResponse<List<Student>>> getAll();
}
