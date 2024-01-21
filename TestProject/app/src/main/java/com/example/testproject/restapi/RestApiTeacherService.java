package com.example.testproject.restapi;


import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiTeacherService {
    @GET(".")
    Call<RestApiResponse<List<Teacher>>> getAll();
}
