package com.example.testproject.restapi.student.abstracts;


import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiStudentService {
    @GET(".")
    Call<RestApiResponse<List<Student>>> getAll();
}
