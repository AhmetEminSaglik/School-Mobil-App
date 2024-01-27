package com.example.e_okul.restapi.base;

import com.example.e_okul.restapi.headmaster.abstracts.RestApiHeadMasterService;
import com.example.e_okul.restapi.student.abstracts.RestApiStudentService;
import com.example.e_okul.restapi.teacher.abstracts.RestApiTeacherService;
import com.example.e_okul.restapi.user.abstracts.RestApiUserService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private static Retrofit getRetrofit(String url) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS);
        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    private static Object getService(String url, Class<?> clazz) {
        Retrofit retrofit = getRetrofit(url);
        return retrofit.create(clazz);
    }

    public static RestApiUserService getUserRestApi(String url) {
        return (RestApiUserService) getService(url, RestApiUserService.class);
    }

    public static RestApiHeadMasterService getHeadMasterRestApi(String url) {
        return (RestApiHeadMasterService) getService(url, RestApiHeadMasterService.class);
    }

    public static RestApiStudentService getStudentRestApi(String url) {
        return (RestApiStudentService) getService(url, RestApiStudentService.class);
    }


    public static RestApiTeacherService getTeacherRestApi(String url) {
        return (RestApiTeacherService) getService(url, RestApiTeacherService.class);
    }

}
