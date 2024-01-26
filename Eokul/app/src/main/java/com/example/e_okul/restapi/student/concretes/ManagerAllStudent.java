package com.example.e_okul.restapi.student.concretes;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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

 /*   public Student getStudentById(int studentId) {
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
    }*/

  /*  public List<Student> getAllStudents() {
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
    }*/
  public void getAllStudents(final OnGetStudentsListener listener) {
      Call<RestApiResponse<List<Student>>> call = getStudentRestApiClient().getAll();

      call.enqueue(new Callback<RestApiResponse<List<Student>>>() {
          @Override
          public void onResponse(Call<RestApiResponse<List<Student>>> call, Response<RestApiResponse<List<Student>>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  List<Student> studentList = response.body().getData();
                  showToastMsg(response.body().getMessage());
                  listener.onGetStudentsSuccess(studentList);
              } else {
                  handleErrorResponse(response);  // Bu satırı ekledik.
                  listener.onGetStudentsFailed();
              }
          }

          @Override
          public void onFailure(Call<RestApiResponse<List<Student>>> call, Throwable t) {
              t.printStackTrace();
              // Handle failure, show error message, etc.
              listener.onGetStudentsFailed();
          }
      });
  }
    public void getStudentById(int studentId, final OnGetStudentsListener listener) {
        Call<RestApiResponse<Student>> call = getStudentRestApiClient().getById(studentId);

        call.enqueue(new Callback<RestApiResponse<Student>>() {
            @Override
            public void onResponse(Call<RestApiResponse<Student>> call, Response<RestApiResponse<Student>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Student student = (Student) response.body().getData();
                    showToastMsg(response.body().getMessage());
                    listener.onGetStudentByIdSucces(student);
                } else {

                    listener.onGetStudentsFailed();
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<RestApiResponse<Student>> call, Throwable t) {

            }


        });
    }

    // Bu metodun kullanıldığı yerde fonksiyonun sonunda ekledik.
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
        }
    }

    public interface OnGetStudentsListener {
        void onSaveSuccess(Student student);

        void onSaveFailed();

        void onGetStudentsSuccess(List<Student> studentList);
        void onGetStudentsFailed();

        void onDeleteSuccess();

        void onGetStudentByIdSucces(Student student);
    }

  /*  public Student saveStudent(Student student) {
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
    }*/

    public void deleteStudent(int studentId, final OnDeleteStudentListener listener) {
        Call<RestApiResponse<Void>> call = getStudentRestApiClient().delete(studentId);

        call.enqueue(new Callback<RestApiResponse<Void>>() {
            @Override
            public void onResponse(Call<RestApiResponse<Void>> call, Response<RestApiResponse<Void>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    showToastMsg(response.body().getMessage());
                    listener.onDeleteSuccess();
                } else {
                    //handleErrorResponse(response);
                    listener.onDeleteFailed();
                }
            }

            @Override
            public void onFailure(Call<RestApiResponse<Void>> call, Throwable t) {
                t.printStackTrace();
                // Handle failure, show error message, etc.
                listener.onDeleteFailed();
            }
        });
    }
    public interface OnDeleteStudentListener {
        void onDeleteSuccess();
        void onDeleteFailed();
    }

    public void saveStudent(Student student, final OnSaveStudentListener listener) {
      Call<RestApiResponse<Student>> call = getStudentRestApiClient().save(student);


      call.enqueue(new Callback<RestApiResponse<Student>>() {
          @Override
          public void onResponse(Call<RestApiResponse<Student>> call, Response<RestApiResponse<Student>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  Student savedStudent = response.body().getData();
                  showToastMsg(response.body().getMessage());
                  listener.onSaveSuccess(savedStudent);
              } else {
                  handleErrorResponse(response);
                  listener.onSaveFailed();
              }
          }
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
              }
          }


          @Override
          public void onFailure(Call<RestApiResponse<Student>> call, Throwable t) {
              t.printStackTrace();
              // Handle failure, show error message, etc.
              listener.onSaveFailed();
          }
      });
  }

    public interface OnSaveStudentListener {
        void onSaveSuccess(Student student);

        void onSaveSuccess(List<Student> studentList);

        void onSaveFailed();

        void onGetStudentByIdSucces(Student student);


    }


    private void showToastMsg(String msg) {
        Toast.makeText(contextRef.get(), msg, Toast.LENGTH_LONG).show();
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
