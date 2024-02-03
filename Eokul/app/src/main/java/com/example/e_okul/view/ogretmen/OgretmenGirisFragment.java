package com.example.e_okul.view.ogretmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgretmenGirisBinding;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.e_okul.restapi.teacher.concretes.OnGetTeacherByUsernameListener;
import com.example.e_okul.restapi.teacher.concretes.OnTeacherLoginListener;
import com.example.e_okul.viewmodel.OgretmenViewModel;


public class OgretmenGirisFragment extends Fragment implements OnGetTeacherByUsernameListener, OnTeacherLoginListener {
    private FragmentOgretmenGirisBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOgretmenGirisBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoginCredentials loginCredentials = new LoginCredentials();
        binding.buttonLogin.setOnClickListener(view1 -> goToTeacherMain());
        ManagerAllTeacher managerAllTeacher= ManagerAllTeacher.getInstance(getContext());

        binding.buttonLogin.setOnClickListener(view1 -> {
            loginCredentials.setUsername(binding.editTextUsername.getText().toString());
            loginCredentials.setPassword(binding.editTextPassword.getText().toString());

            managerAllTeacher.getTeacherByUsername(loginCredentials.getUsername(), loginCredentials,this);
            managerAllTeacher.login(this,loginCredentials);
        });
    }

    private void goToTeacherMain(){
        NavController navController= Navigation.findNavController(requireView());
        navController.navigate(R.id.action_ogretmenGirisFragment_to_ogretmenAnaSayfaFragment);
    }


    @Override
    public void loginSuccess(Teacher teacher) {
        if(binding.editTextUsername.getText().toString().equals(teacher.getUsername())&&
                binding.editTextPassword.getText().toString().equals(teacher.getPassword())) {

            OgretmenViewModel ogretmenViewModel =new ViewModelProvider(requireActivity()).get(OgretmenViewModel.class);
            ogretmenViewModel.setTeacherName(teacher.getName());
            ogretmenViewModel.setTeacherLastName(teacher.getLastname());
            goToTeacherMain();
        }
        else {

        }

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void success() {

    }

    @Override
    public void failed() {

    }
}