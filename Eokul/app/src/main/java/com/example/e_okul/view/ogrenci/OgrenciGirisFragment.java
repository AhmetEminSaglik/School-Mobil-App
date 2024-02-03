package com.example.e_okul.view.ogrenci;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgrenciGirisBinding;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnGetStudentByUserNameListener;
import com.example.e_okul.restapi.student.concretes.OnStudentLoginListener;
import com.example.e_okul.viewmodel.OgrenciViewModel;


public class OgrenciGirisFragment extends Fragment implements OnStudentLoginListener, OnGetStudentByUserNameListener {
    private FragmentOgrenciGirisBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOgrenciGirisBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginCredentials loginCredentials = new LoginCredentials();
        ManagerAllStudent managerAllStudent= ManagerAllStudent.getInstance(getContext());


      binding.buttonLogin.setOnClickListener(view1 -> {

          loginCredentials.setUsername(binding.editTextUsername.getText().toString());
          loginCredentials.setPassword(binding.editTextPassword.getText().toString());

          managerAllStudent.getStudentByUsername(loginCredentials.getUsername(), loginCredentials, this);
          managerAllStudent.login(this,loginCredentials);


      });
    }

    @Override
    public void onLoginSuccess(Student student) {
        if(binding.editTextUsername.getText().toString().equals(student.getUsername())&&
                binding.editTextPassword.getText().toString().equals(student.getPassword())){
            Toast.makeText(this.getContext(),"Giriş Başarılı",Toast.LENGTH_SHORT).show();

            OgrenciViewModel ogrenciViewModel = new ViewModelProvider(requireActivity()).get(OgrenciViewModel.class);
            ogrenciViewModel.setStudentName(student.getName());
            ogrenciViewModel.setStudentLastname(student.getLastname());

            NavController navController = Navigation.findNavController(requireView());
            navController.navigate(R.id.action_ogrenciGirisFragment_to_ogrenciAnaSayfaFragment);
        }
        else {
            Toast.makeText(this.getContext(),"Giriş Başarısız",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoginFailed() {
    }


    @Override
    public void success() {
    }

    @Override
    public void failed() {
    }
}
