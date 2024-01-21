package com.example.e_okul.database;

import androidx.annotation.NonNull;

import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OgrenciSil {

    public interface OgrenciSilCallback {
        void onOgrenciSilSuccess();
        void onOgrenciSilFailure();
    }

    private int no;
    private OgrenciSilCallback callback;

    public OgrenciSil(int no, OgrenciSilCallback callback) {
        this.no = no;
        this.callback = callback;
    }

    public void deleteData() {
        // Retrofit ile API'ye isteği gönderme
        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<String> call = apiService.deleteStudent(no);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().equals("Success")) {
                        callback.onOgrenciSilSuccess();
                    } else {
                        callback.onOgrenciSilFailure();
                    }
                } else {
                    callback.onOgrenciSilFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                callback.onOgrenciSilFailure();
            }
        });
    }
}
