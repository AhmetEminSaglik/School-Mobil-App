package com.example.e_okul.restapi.headmaster.abstracts;


import com.example.e_okul.model.HeadMaster;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApiHeadMasterService {
    @GET(".")
    Call<RestApiResponse<List<HeadMaster>>> getAll();

    @POST("login/")
    Call<RestApiResponse<HeadMaster>> login(@Body LoginCredentials credentials);

    @GET("username/{username}/")
    Call<RestApiResponse<HeadMaster>> getHeadmasterByUsername(@Path("username") String username);
}
