package com.example.testproject.restapi.headmaster.abstracts;


import com.example.testproject.model.HeadMaster;
import com.example.testproject.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiHeadMasterService {
    @GET(".")
    Call<RestApiResponse<List<HeadMaster>>> getAll();
}
