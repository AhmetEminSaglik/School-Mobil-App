package com.example.e_okul.restapi.student.concretes;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;
import com.example.e_okul.model.response.abstracts.RestApiErrorResponse;
import com.example.e_okul.model.response.abstracts.RestApiResponse;
import com.example.e_okul.restapi.base.BaseManager;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ManagerAllStudent extends BaseManager {
    private static WeakReference<Context> contextRef;
    private static final ManagerAllStudent managerAll = new ManagerAllStudent();

    public static synchronized ManagerAllStudent getInstance(Context newContext) {
        contextRef = new WeakReference<>(newContext);
        return managerAll;
    }

    public void login(final OnStudentLoginListener listener, LoginCredentials credentials) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().login(credentials);

        call.enqueue(new Callback<RestApiResponse<Student>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Student>> call, @NonNull Response<RestApiResponse<Student>> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        Student student = response.body().getData();
                        showToastMsg(response.body().getMessage());
                        listener.onLoginSuccess(student);
                    } else {
                        assert response.errorBody() != null;
                        String errorMessage =response.errorBody().string();
                        showToastMsg(errorMessage);
                        listener.onLoginFailed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onLoginFailed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Student>> call, @NonNull Throwable t) {
                try {
                    t.printStackTrace();
                    showToastMsg("Bağlantı hatası: " + t.getMessage());
                    listener.onLoginFailed();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void getAllStudents(final OnGetStudentsListener listener) {
      Call<RestApiResponse<List<Student>>> call = getStudentRestApiClient().getAll();

      call.enqueue(new Callback<RestApiResponse<List<Student>>>() {
          @Override
          public void onResponse(@NonNull Call<RestApiResponse<List<Student>>> call, @NonNull Response<RestApiResponse<List<Student>>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  List<Student> studentList = response.body().getData();
                  showToastMsg(response.body().getMessage());
                  listener.onGetStudentsSuccess(studentList);
              } else {
                  handleErrorResponse(response);
                  listener.onGetStudentsFailed();}}

          @Override
          public void onFailure(@NonNull Call<RestApiResponse<List<Student>>> call, @NonNull Throwable t) {
              t.printStackTrace();
              listener.onGetStudentsFailed();
          }});}
    public void getStudentByNo(int studentId, final OnGetStudentsListener listener) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().getByNo(studentId);

        call.enqueue(new Callback<RestApiResponse<Student>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Student>> call, @NonNull Response<RestApiResponse<Student>> response) {
                assert response.body() != null;
                if (response.body().isSuccess()) {
                    Student student = response.body().getData();
                    showToastMsg(response.body().getMessage());
                    listener.onGetStudentByIdSucces(student);
                } else {
                    listener.onGetStudentsFailed();
                }}
            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Student>> call, @NonNull Throwable t) {
            }});}

    public void getStudentByUsername(String username, LoginCredentials loginCredentials, final OnGetStudentByUserNameListener listener) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().getStudentByUsername(username);

        call.enqueue(new Callback<RestApiResponse<Student>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Student>> call, @NonNull Response<RestApiResponse<Student>> response) {
                assert response.body() != null;
                if (response.body().isSuccess()) {
                    Student student = response.body().getData();
                   // showToastMsg(response.body().getMessage());
                    listener.success();
                } else {
                    listener.failed();
                }}
            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Student>> call, @NonNull Throwable t) {
            }});}
    private void handleErrorResponse(Response<RestApiResponse<List<Student>>> response) {
        Gson gson = new Gson();
        if (response.errorBody() != null) {
            RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
            String errMsg = errorResponse.getMessage();
            if (errMsg != null) {
                Log.e("Error", errMsg);
                showToastMsg(errMsg);
            }
        } else {
            Log.e("Error", "Unknown error occurred.");
            showToastMsg("Unknown error occurred.");
        }}

    public void updateStudent(Student student, final OnUpdateStudentListener listener){
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().update(student);

        call.enqueue(new Callback<RestApiResponse<Student>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Student>> call, @NonNull Response<RestApiResponse<Student>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RestApiResponse<Student> apiResponse = response.body();

                    if (apiResponse.isSuccess()) {

                        listener.onUpdateSucccess();
                    } else {
                        Log.e("updateStudent", "Sunucu tarafında bir hata oluştu: " + apiResponse.getMessage());
                        listener.onUpdateFailed();
                    }
                } else {
                    Log.e("updateStudent", "HTTP hatası: " + response.code());
                    listener.onUpdateFailed();
                }}


            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Student>> call, @NonNull Throwable t) {
                listener.onUpdateFailed();
            }});}

    public void deleteStudent(String no, final OnDeleteStudentListener listener) {
        Call<RestApiResponse<Void>> call = getStudentRestApiClient().delete(no);

        call.enqueue(new Callback<RestApiResponse<Void>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Void>> call, @NonNull Response<RestApiResponse<Void>> response) {
                if (response.isSuccessful()) {
                    listener.onDeleteSuccess();
                } else {
                    listener.onDeleteFailed();
                }}

            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Void>> call, @NonNull Throwable t) {
                t.printStackTrace();

                listener.onDeleteFailed();
            }});}

    public void saveStudent(Student student, final OnSaveStudentListener listener) {
      Call<RestApiResponse<Student>> call = getStudentRestApiClient().save(student);

      call.enqueue(new Callback<RestApiResponse<Student>>() {
          @Override
          public void onResponse(@NonNull Call<RestApiResponse<Student>> call, @NonNull Response<RestApiResponse<Student>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  Student savedStudent = response.body().getData();
                  showToastMsg(response.body().getMessage());
                  listener.onSaveSuccess(savedStudent);
              } else {
                  handleErrorResponse(response);
                  listener.onSaveFailed();
              }}
          public void handleErrorResponse(Response<RestApiResponse<Student>> response) {
              Gson gson = new Gson();
              if (response.errorBody() != null) {
                  RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                  String errMsg = errorResponse.getMessage();
                  if (errMsg != null) {
                      Log.e("Error", errMsg);
                      showToastMsg(errMsg);
                  }
              } else {
                  Log.e("Error", "Unknown error occurred.");
                  showToastMsg("Unknown error occurred.");
              }}

          @Override
          public void onFailure(@NonNull Call<RestApiResponse<Student>> call, @NonNull Throwable t) {
              t.printStackTrace();
              listener.onSaveFailed();
          }});}
    private void showToastMsg(String msg) {
        Toast.makeText(contextRef.get(), msg, Toast.LENGTH_LONG).show();}

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
