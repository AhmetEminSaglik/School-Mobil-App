package com.example.e_okul.view.mudur;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_okul.databinding.FragmentMudurOgrenciEkleBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnSaveStudentListener;

public class MudurOgrenciEkleFragment extends Fragment implements OnSaveStudentListener {
    private FragmentMudurOgrenciEkleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciEkleBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button ekleButton = binding.ekleButton;
        Student student = new Student();



        ManagerAllStudent managerAllStudent = ManagerAllStudent.getInstance(getContext());

        ekleButton.setOnClickListener(it ->{
            student.setName(binding.adEditText.getText().toString());
            student.setLastname(binding.soyadEditText.getText().toString());
            student.setUsername(binding.kullaniciAdiEditText.getText().toString());
            student.setPassword(binding.sifreEditText.getText().toString());
            student.setNo(binding.noEditText.getText().toString());
            student.setParentId(3);
            managerAllStudent.saveStudent(student,this);
                }

        );
    }


    @Override
    public void onSaveSuccess(Student student) {}

    @Override
    public void onSaveFailed() {}


}