package com.example.e_okul.restapi.headmaster.concretes;


import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.example.e_okul.model.HeadMaster;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.response.abstracts.RestApiResponse;
import com.example.e_okul.restapi.base.BaseManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerAllHeadMaster extends BaseManager {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static final ManagerAllHeadMaster managerAllHeadMaster = new ManagerAllHeadMaster();

    public static synchronized ManagerAllHeadMaster getInstance(Context newContext) {
        context = newContext;

        return managerAllHeadMaster;
    }

    public void getHeadmasterByUsername(String username, LoginCredentials loginCredentials, final OnGetHeadmasterByUsernameListener listener) {
        Call<RestApiResponse<HeadMaster>> call = getHeadMasterRestApiClient().getHeadmasterByUsername(username);

        call.enqueue(new Callback<RestApiResponse<HeadMaster>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<HeadMaster>> call, @NonNull Response<RestApiResponse<HeadMaster>> response) {
                if (response.body() != null) {
                    if (response.body().isSuccess()) {
                        listener.success();
                    } else {
                        listener.failed();
                    }
                } else {
                    listener.failed();
                }
            }
            @Override
            public void onFailure(@NonNull Call<RestApiResponse<HeadMaster>> call, @NonNull Throwable t) {
            }});}

    public void login(final OnHeadmasterLoginListener listener, LoginCredentials credentials) {
        Call<RestApiResponse<HeadMaster>> call = getHeadMasterRestApiClient().login(credentials);

        call.enqueue(new Callback<RestApiResponse<HeadMaster>>() {
            @Override
            public void onResponse(@NonNull Call<RestApiResponse<HeadMaster>> call, @NonNull Response<RestApiResponse<HeadMaster>> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        HeadMaster headMaster = response.body().getData();
                        showToastMsg(response.body().getMessage());
                        listener.loginSuccess(headMaster);
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
            public void onFailure(@NonNull Call<RestApiResponse<HeadMaster>> call, @NonNull Throwable t) {
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
    private void showToastMsg(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }



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
