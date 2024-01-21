package com.example.e_okul.database;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentMudurGirisBinding;
import com.example.e_okul.model.MudurResponse;
import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mudur {

private String name;
    private final FragmentMudurGirisBinding binding;
    public Mudur(FragmentMudurGirisBinding binding) {
        this.binding = binding;
    }

    public void getData() {
        String name=binding.editTextUsername.getText().toString();
        String password=binding.editTextPassword.getText().toString();

        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<MudurResponse> call = apiService.getMudur(name);
        call.enqueue(new Callback<MudurResponse>() {
            @Override
            public void onResponse(@NonNull Call<MudurResponse> call, @NonNull Response<MudurResponse> response) {
                if (response.isSuccessful()) {
                    MudurResponse mudurResponse = response.body();
                    if (mudurResponse != null) {
                       if(name.equals(mudurResponse.getName())&&password.equals(String.valueOf(mudurResponse.getPassword()))){
                            navigateToSuccessFragment();
                        }
                        else {
                            showToast();
                        }
                    }
                } else {
                    showToast();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MudurResponse> call1, @NonNull Throwable t){}

        });
    }
    private void navigateToSuccessFragment() {
        NavController navController = Navigation.findNavController(binding.getRoot());
        navController.navigate(R.id.action_mudurGirisFragment_to_mudurAnaSayfaFragment);
    }

    private void showToast() {
        Toast.makeText(binding.getRoot().getContext(), "Kullanıcı adı ya da Şifre hatalı", Toast.LENGTH_LONG).show();
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }


}
