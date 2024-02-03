package com.example.e_okul.view.ogretmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e_okul.adapters.TeacherStudentListAdapter;
import com.example.e_okul.databinding.FragmentOgretmenOgrenciListesiBinding;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnGetStudentsListener;

import java.util.List;

public class OgretmenOgrenciListesiFragment extends Fragment implements OnGetStudentsListener {
    private FragmentOgretmenOgrenciListesiBinding binding;
    private TeacherStudentListAdapter teacherStudentListAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOgretmenOgrenciListesiBinding.inflate(getLayoutInflater(),container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherStudentListAdapter = new TeacherStudentListAdapter(getContext());
        ManagerAllStudent s = ManagerAllStudent.getInstance(getContext());
        s.getAllStudents(this);

        binding.recyclerView.setAdapter(teacherStudentListAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onGetStudentsSuccess(List<Student> studentList) {
        Log.d("StudentAdapter", "onGetStudentsSuccess - itemCount: " + teacherStudentListAdapter.getItemCount());
        teacherStudentListAdapter.setStudentList(studentList);
    }

    @Override
    public void onGetStudentsFailed() {

    }

    @Override
    public void onGetStudentByIdSucces(Student student) {

    }

    @Override
    public void onGetStudentByUsernameSuccess(Student student , LoginCredentials loginCredentials) {

    }
}