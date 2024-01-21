package com.example.e_okul.retrofit;

import com.example.e_okul.model.MudurResponse;
import com.example.e_okul.model.Student;
import com.example.e_okul.model.StudentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("deneme.php")
        // API'nizin gerçek yolunu eklemeniz gerekiyor
    Call<StudentResponse> getStudent(@Field("no") int no);


    @GET("ogrenci.php")
        // API'nizin gerçek adresini eklemeniz gerekiyor
    Call<List<Student>> getStudent();
    @FormUrlEncoded
    @POST("ogrenciGiris.php")
        // API'nizin gerçek adresini eklemeniz gerekiyor
    Call<Student> getStudents(@Field("no") int no);
    @FormUrlEncoded
    @POST("create.php")
        // API'nizin gerçek adresini eklemeniz gerekiyor
    Call<String> addStudent(
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("tc_kn") long tc_kn,
            @Field("parentName") String parentName,
            @Field("no") int no
    );

    @FormUrlEncoded
    @POST("update.php")
        // API'nizin gerçek adresini eklemeniz gerekiyor
    Call<String> updateStudent(
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("tc_kn") long tc_kn,
            @Field("parentName") String parentName,
            @Field("no") int no
    );
    @FormUrlEncoded
    @POST("delete.php")
        // API'nizin gerçek adresini eklemeniz gerekiyor
    Call<String> deleteStudent(
            @Field("no") int no
    );
    @FormUrlEncoded
    @POST("mudur.php")
        // API'nizin gerçek yolunu eklemeniz gerekiyor
    Call<MudurResponse> getMudur(@Field("name") String name);


}


