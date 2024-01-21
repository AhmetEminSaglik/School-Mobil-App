package com.example.e_okul.database;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_okul.adapters.StudentAdapter;
import com.example.e_okul.databinding.FragmentMudurOgrenciListesiBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OgrenciListesi {

    private final FragmentMudurOgrenciListesiBinding binding;

    public OgrenciListesi(FragmentMudurOgrenciListesiBinding binding) {
        this.binding = binding;
    }

    public void getData() {
        final RecyclerView recyclerView;
        final StudentAdapter[] studentAdapter = new StudentAdapter[1];

        recyclerView = binding.recyclerView;  // final olarak işaretlendi

        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<List<Student>> call = apiService.getStudent();
        call.enqueue(new Callback<List<Student>>() {

            @Override
            public void onResponse(@NonNull Call<List<Student>> call, @NonNull Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    List<Student> studentList = response.body();
                    if (studentList != null && !studentList.isEmpty()) {
                        // Verileri RecyclerView'e bağla
                        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

                        studentAdapter[0] = new StudentAdapter(studentList);
                        recyclerView.setAdapter(studentAdapter[0]);
                    } else {
                        // Eğer veri yoksa kullanıcıya bilgi ver
                        Toast.makeText(binding.getRoot().getContext(),"Veri Yok ",Toast.LENGTH_LONG).show();
                    }
                } else {
                    // API çağrısı başarısızsa kullanıcıya bilgi ver
                    Toast.makeText(binding.getRoot().getContext(),"API çağrısı başarısız. Hata: " ,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Student>> call, @NonNull Throwable t) {
                // API çağrısı hata aldığında kullanıcıya bilgi ver
                Toast.makeText(binding.getRoot().getContext(),"API çağrısı başarısız. Hata: " + t.getMessage(),Toast.LENGTH_LONG).show();
            }

        });
    }



}

