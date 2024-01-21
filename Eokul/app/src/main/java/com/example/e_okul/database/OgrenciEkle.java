package com.example.e_okul.database;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OgrenciEkle {
    private final EditText nameEditText;
    private final EditText surnameEditText;
    private final EditText tcknEditText;
    private final EditText parentNameEditText;
    private final EditText noEditText;

    public OgrenciEkle(EditText nameEditText, EditText surnameEditText, EditText tcknEditText, EditText parentNameEditText, EditText noEditText) {
        this.nameEditText = nameEditText;
        this.surnameEditText = surnameEditText;
        this.tcknEditText = tcknEditText;
        this.parentNameEditText = parentNameEditText;
        this.noEditText = noEditText;
    }
    public void postData() {
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        long tc_kn = Long.parseLong(tcknEditText.getText().toString());
        String parentName = parentNameEditText.getText().toString();
        int no = Integer.parseInt(noEditText.getText().toString());

        // Retrofit ile API'ye isteği gönderme
        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<String> call = apiService.addStudent(name, surname, tc_kn, parentName, no);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if(response.isSuccessful() && response.body() != null) {
                    if(response.body().equals("Success")) {
                        Toast.makeText(nameEditText.getContext(), "Data added", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(nameEditText.getContext(), "Failed to add data: " + response.body(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(nameEditText.getContext(), "Failed to add data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("Error", Objects.requireNonNull(t.getLocalizedMessage()));
                Toast.makeText(nameEditText.getContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
            }
        });

    }



}
