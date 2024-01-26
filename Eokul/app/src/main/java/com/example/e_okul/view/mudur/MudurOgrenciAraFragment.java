package com.example.e_okul.view.mudur;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.e_okul.databinding.FragmentMudurOgrenciAraBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;

import java.util.List;

public class MudurOgrenciAraFragment extends Fragment implements ManagerAllStudent.OnSaveStudentListener {

    private FragmentMudurOgrenciAraBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciAraBinding.inflate(getLayoutInflater(), container, false);
        //EditText editTextSearchResult = binding.editTextSearchResult; // editTextSearchResult'a erişim
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




      binding.searchButton.setOnClickListener(it -> SerachStudent());
    }

void SerachStudent(){
    int studenId= Integer.parseInt(binding.noEditText.getText().toString());
    ManagerAllStudent s = ManagerAllStudent.getInstance(getContext());
    s.getStudentById(studenId,(ManagerAllStudent.OnGetStudentsListener) this);

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
        binding.editTextSearchResult.setText(student.getName());

    }





}
