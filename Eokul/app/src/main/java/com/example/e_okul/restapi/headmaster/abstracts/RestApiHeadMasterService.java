package com.example.e_okul.restapi.headmaster.abstracts;


import com.example.e_okul.model.HeadMaster;
import com.example.e_okul.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiHeadMasterService {
    @GET(".")
    Call<RestApiResponse<List<HeadMaster>>> getAll();
}
