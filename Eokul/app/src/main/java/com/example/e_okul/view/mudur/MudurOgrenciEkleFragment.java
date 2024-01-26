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

import java.util.List;


public class MudurOgrenciEkleFragment extends Fragment implements ManagerAllStudent.OnSaveStudentListener {
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
        String name=binding.adEditText.getText().toString();

        student.setName("Ali");
        student.setLastname("Veli");
        student.setUsername("fgjjgfj");
        student.setPassword("pass");
        student.setNo("651");
        student.setParentId(3);



        ManagerAllStudent managerAllStudent = ManagerAllStudent.getInstance(getContext());


        ekleButton.setOnClickListener(it ->
                  managerAllStudent.saveStudent(student,this)


      /*  student.setLastname(surnameEditText.getText().toString()),
        student.setUsername("jasfn"),
        student.setPassword("pass"),
        student.setNo(noEditText.getText().toString()),
        student.setParentId(3)
        */
        );

    }


    @Override
    public void onSaveSuccess(Student student) {

    }

    @Override
    public void onSaveSuccess(List<Student> studentList) {

    }

    @Override
    public void onSaveFailed() {

    }

    @Override
    public void onGetStudentByIdSucces(Student student) {

    }
}