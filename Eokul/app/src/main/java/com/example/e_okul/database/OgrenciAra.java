package com.example.e_okul.database;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.e_okul.databinding.FragmentMudurOgrenciAraBinding;
import com.example.e_okul.model.StudentResponse;
import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OgrenciAra {

    private final FragmentMudurOgrenciAraBinding binding;
    public OgrenciAra(FragmentMudurOgrenciAraBinding binding) {
        this.binding = binding;
    }
    public void getData() {
        EditText noEditText = binding.noEditText;
        int no = Integer.parseInt(noEditText.getText().toString());

        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<StudentResponse> call = apiService.getStudent(no);

        call.enqueue(new Callback<StudentResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<StudentResponse> call, @NonNull Response<StudentResponse> response) {
                if (response.isSuccessful()) {
                    StudentResponse studentResponse = response.body();
                    if (studentResponse != null) {
                        // Başarılı cevap, studentResponse içinde istediğiniz verilere ulaşabilirsiniz
                        String name = studentResponse.getName();
                        String surname = studentResponse.getSurname();

                        binding.editTextSearchResult.setText(name + " " + surname);
                    }
                } else {
                    response.errorBody();
                }
            }

            @Override
            public void onFailure(@NonNull Call<StudentResponse> call, @NonNull Throwable t) {
                // Hata durumu
                Log.e("Retrofit Error", "Connection Error: " + t.getMessage());
            }
        });
    }
}
