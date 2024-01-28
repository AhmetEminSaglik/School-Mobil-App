package com.example.e_okul.view.mudur;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.adapters.StudentAdapter;
import com.example.e_okul.databinding.FragmentMudurOgrenciListesiBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;

import java.util.List;

public class MudurOgrenciListesiFragment extends Fragment implements ManagerAllStudent.OnGetStudentsListener{

    private StudentAdapter studentAdapter;
    private FragmentMudurOgrenciListesiBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciListesiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        studentAdapter = new StudentAdapter(getContext());
        ManagerAllStudent s = ManagerAllStudent.getInstance(getContext());
        s.getAllStudents(this);

        binding.recyclerView.setAdapter(studentAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onSaveSuccess(Student student) {}

    @Override
    public void onSaveFailed() {}

    @Override
    public void onGetStudentsSuccess(List<Student> studentList) {
        Log.d("StudentAdapter", "onGetStudentsSuccess - itemCount: " + studentAdapter.getItemCount());
        studentAdapter.setStudentList(studentList);
    }

    @Override
    public void onGetStudentsFailed() {}
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onDeleteSuccess() {}

    @Override
    public void onGetStudentByIdSucces(Student student) {}
}
