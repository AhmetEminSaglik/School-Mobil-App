package com.example.e_okul.database;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgrenciGirisBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.retrofit.Api;
import com.example.e_okul.retrofit.RetrofitClient;
import com.example.e_okul.viewmodel.OgrenciViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OgrenciGiris {

    private final FragmentOgrenciGirisBinding binding;
    public OgrenciGiris(FragmentOgrenciGirisBinding binding){
        this.binding=binding;}
    public void getData() {
        String noStr=binding.editTextNo.getText().toString();
        String password = binding.editTextPassword.getText().toString();
        int no=Integer.parseInt(noStr);

        Api apiService = RetrofitClient.getClient().create(Api.class);
        Call<Student> call = apiService.getStudents(no);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(@NonNull Call<Student> call, @NonNull Response<Student> response) {
                if(response.isSuccessful()){
                    Student student = response.body();
                    if(student!=null){
                        if (noStr.equals(String.valueOf(student.getNo())) && password.equals(String.valueOf(student.getPassword()))) {
                            Toast.makeText(binding.getRoot().getContext(), "Giriş başarılı", Toast.LENGTH_LONG).show();
                            navigateToSuccessFragment();
                            initSharedViewModel(student);
                        }
                        else {
                            Toast.makeText(binding.getRoot().getContext(), "Hatalı Giriş", Toast.LENGTH_LONG).show();
                        }
                    }}}

            @Override
            public void onFailure(@NonNull Call<Student> call, @NonNull Throwable t) {
                Log.e("Retrofit Error", "Connection Error: " + t.getMessage());
            }});

    }
    private void navigateToSuccessFragment() {
        NavController navController = Navigation.findNavController(binding.getRoot());
        navController.navigate(R.id.action_ogrenciGirisFragment_to_ogrenciAnaSayfaFragment);}


   private void initSharedViewModel(Student student) {
       OgrenciViewModel ogrenciViewModel = new ViewModelProvider(
               (ViewModelStoreOwner) binding.getRoot().getContext(),
               new ViewModelProvider.AndroidViewModelFactory((Application) binding.getRoot().getContext().getApplicationContext())
       ).get(OgrenciViewModel.class);
       ogrenciViewModel.setStudentName(student.getName());
       ogrenciViewModel.setStudentSurname(student.getSurname());
   }
}

