package com.example.e_okul.restapi.teacher.concretes;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.model.response.abstracts.RestApiResponse;
import com.example.e_okul.restapi.base.BaseManager;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerAllTeacher extends BaseManager {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static ManagerAllTeacher managerAllTeacher = new ManagerAllTeacher();

    public static synchronized ManagerAllTeacher getInstance(Context newContext) {
        context = newContext;
        return managerAllTeacher;
    }

    public void login(final OnTeacherLoginListener listener, LoginCredentials credentials) {
        Call<RestApiResponse<Teacher>> call = getTeacherRestApiClient().login(credentials);

        call.enqueue(new Callback<RestApiResponse<Teacher>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Response<RestApiResponse<Teacher>> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        Teacher teacher = response.body().getData();
                        showToastMsg(response.body().getMessage());
                        listener.loginSuccess(teacher);
                    } else {
                        assert response.errorBody() != null;
                        String errorMessage =response.errorBody().string();
                        showToastMsg(errorMessage);
                        listener.loginFailed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.loginFailed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Throwable t) {
                try {
                    t.printStackTrace();
                    showToastMsg("Bağlantı hatası: " + t.getMessage());
                    listener.loginFailed();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void getTeacherByUsername(String username, LoginCredentials loginCredentials, final OnGetTeacherByUsernameListener listener) {
        Call<RestApiResponse<Teacher>> call = getTeacherRestApiClient().getByUsername(username);

        call.enqueue(new Callback<RestApiResponse<Teacher>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Response<RestApiResponse<Teacher>> response) {
                if (response.body() != null) {
                    if (response.body().isSuccess()) {
                        listener.success();
                    } else {
                        listener.failed();
                    }
                } else {
                    // response.body() null ise ilgili işlemleri yapın
                    listener.failed();
                }}
            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Throwable t) {
            }});}

    public void getAllTeacher(final OnGetTeachersListener listener){
        Call<RestApiResponse<List<Teacher>>> call=getTeacherRestApiClient().getAll();

        call.enqueue(new Callback<RestApiResponse<List<Teacher>>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<List<Teacher>>> call, @NonNull Response<RestApiResponse<List<Teacher>>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    List<Teacher> teacherList = response.body().getData();
                    showToastMsg(response.body().getMessage());
                    listener.onGetTeachersSuccess(teacherList);
                }
                else {
                    listener.onGetTeachersFailed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RestApiResponse<List<Teacher>>> call, @NonNull Throwable t) {
                t.printStackTrace();
                listener.onGetTeachersFailed();
            }
        });

    }

    public void saveTeacher(Teacher teacher, final  OnSaveTeacherListener listener){
        Call<RestApiResponse<Teacher>> call = getTeacherRestApiClient().save(teacher);
        call.enqueue(new Callback<RestApiResponse<Teacher>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Response<RestApiResponse<Teacher>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    showToastMsg(response.body().getMessage());
                    listener.onSaveSuccess();
                }
                else {
                    listener.onSaveFailed();
                }
            }
            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Throwable t) {
                t.printStackTrace();
                listener.onSaveFailed();

            }
        });
    }

    public void deleteTeacher(Integer id, final OnDeleteTeacherListener listener){
        Call<RestApiResponse<Teacher>> call = getTeacherRestApiClient().delete(id);
        call.enqueue(new Callback<RestApiResponse<Teacher>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Response<RestApiResponse<Teacher>> response) {
                if (response.isSuccessful()) {


                    listener.onDeleteSuccess();
                } else {
                    //handleErrorResponse(response);
                    listener.onDeleteFailed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Throwable t) {
                t.printStackTrace();
                // Handle failure, show error message, etc.
                listener.onDeleteFailed();

            }
        });
    }

    public void updateTeacher(Teacher teacher, final OnUpdateTeacherListener listener){
        Call<RestApiResponse<Teacher>> call = getTeacherRestApiClient().update(teacher);

        call.enqueue(new Callback<RestApiResponse<Teacher>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Response<RestApiResponse<Teacher>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RestApiResponse<Teacher> apiResponse = response.body();

                    // Kontrol etmek istediğiniz durumları burada işleyin
                    if (apiResponse.isSuccess()) {
                        // Güncelleme başarılı ise burada işlemleri gerçekleştirin

                        listener.onUpdateSuccess();
                    } else {
                        // Güncelleme başarısız ise burada işlemleri gerçekleştirin
                        Log.e("updateStudent", "Sunucu tarafında bir hata oluştu: " + apiResponse.getMessage());
                        listener.onUpdateFailed();
                    }
                } else {
                    // Response başarısız ise burada işlemleri gerçekleştirin
                    Log.e("updateStudent", "HTTP hatası: " + response.code());
                    listener.onUpdateFailed();
                }
            }


            @Override
            public void onFailure(@NonNull Call<RestApiResponse<Teacher>> call, @NonNull Throwable t) {
                // Network hatası veya diğer hatalar burada işlenir
                listener.onUpdateFailed();
            }
        });

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
