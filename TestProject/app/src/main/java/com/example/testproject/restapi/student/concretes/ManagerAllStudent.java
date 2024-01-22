package com.example.testproject.restapi.student.concretes;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.testproject.model.LoginCredentials;
import com.example.testproject.model.Student;
import com.example.testproject.model.response.abstracts.RestApiErrorResponse;
import com.example.testproject.model.response.abstracts.RestApiResponse;
import com.example.testproject.restapi.base.BaseManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ManagerAllStudent extends BaseManager {
    private static Context context;
    private static ManagerAllStudent managerAll = new ManagerAllStudent();

    public static synchronized ManagerAllStudent getInstance(Context newContext) {
        context = newContext;
        return managerAll;
    }

    public Student login(LoginCredentials credentials) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().login(credentials);
        Student student = null;
        try {
            Response<RestApiResponse<Student>> response = call.execute();

            if (response.code() == 200) {
                student = response.body().getData();
                showToastMsg(response.body().getMessage());
            } else {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                    showToastMsg(errMsg);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student getStudentById(int studentId) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().getById(studentId);
        Student student = null;
        try {
            Response<RestApiResponse<Student>> response = call.execute();

            if (response.code() == 200) {
                student = response.body().getData();
                showToastMsg(response.body().getMessage());

            } else {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                    showToastMsg(errMsg);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> getAllStudents() {
        Call<RestApiResponse<List<Student>>> call = getStudentRestApiClient().getAll();
        List<Student> list = null;
        try {
            Response<RestApiResponse<List<Student>>> response = call.execute();
            Log.e("response : ", response.toString());
            if (response.code() == 200) {
                list = response.body().getData();
                showToastMsg(response.body().getMessage());

            } else {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                    showToastMsg(errMsg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student saveStudent(Student student) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().save(student);
        try {
            Response<RestApiResponse<Student>> response = call.execute();
            student = null;
            if (response.code() == 200) {
                student = response.body().getData();
                showToastMsg(response.body().getMessage());

            } else {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                    showToastMsg(errMsg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    private void showToastMsg(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
//    public Call<List<User>> getAllUser() {
    //      return getUserRestApiClient().getAllUsers();
    //}


/*
    public Call<RestApiResponse<Object>> removeUserReadBookConection(long userId, long bookId) {
        return getUserRestApiClient().removeUserReadBookConnection(userId, bookId);
    }

    public Call<RestApiResponse<List<User>>> getUserRelationshipFollowedListRequest(long id) {
        return getUserRestApiClient().getFollowedList(id);
    }

    public Call<RestApiResponse<List<User>>> getUserRelationshipFollowerListRequest(long id) {
        return getUserRestApiClient().getFollowerList(id);
    }

    public Call<RestApiResponse<List<User>>> removeFollowedUserRelationShipRequest(long userId, long followedUserId) {
        return getUserRestApiClient().removeFollowedUserRelationship(userId, followedUserId);
    }

    public Call<RestApiResponse<List<User>>> removeFollowerUserRelationShipRequest(long userId, long followerUserId) {
        return getUserRestApiClient().removeFollowerUserRelationship(userId, followerUserId);
    }

    public Call<RestApiResponse<List<User>>> getRecommendedUserByFriendRead(long userId) {
        return getUserRestApiClient().getRecommendedUserList(userId);
    }

    public Call<RestApiResponse> createConnectionFollowFriend(long userId, long friendUserId){
        return getUserRestApiClient().createConnectionFollowFriend(userId,friendUserId);
    }

    public Call<LoginResponse> getUserByLoginRequest(User user) {
        return getUserRestApiClient().loginUser(user);
    }

    public Call<SignUpResponse> signUpUser(User user) {
        return getUserRestApiClient().signUpUser(user);
    }

    public Call<RestApiResponse<List<Book>>> getReadBookList(Long id) {
        return getBookRestApiClient().getReadBooks(id);
    }

    public Call<RestApiResponse<List<Book>>> getRecommendedBookListByPoint() {
        return getBookRestApiClient().getRecommendedBookListByPoint();
    }

    public Call<RestApiResponse<List<Book>>> getRecommendedBookListByTotalRead() {
        return getBookRestApiClient().getRecommendedBookListByTotalRead();
    }

    public Call<RestApiResponse<List<Book>>> getRecommendedBookListByFriendRead(Long userId) {
        return getBookRestApiClient().getRecommendedBookListByFriendRead(userId);
    }

    public Call<RestApiResponse> createConnectionUserReadBook(long userId, long bookId){
        return getBookRestApiClient().createConnectionUserReadBook(userId,bookId);
    }*/


}
