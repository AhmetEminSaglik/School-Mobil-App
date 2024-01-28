package com.example.e_okul.view.mudur;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.e_okul.adapters.TeacherAdapter;
import com.example.e_okul.databinding.FragmentMudurOgretmenListesiBinding;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.e_okul.restapi.teacher.concretes.OnGetTeachersListener;

import java.util.List;


public class MudurOgretmenListesiFragment extends Fragment implements OnGetTeachersListener {
    private TeacherAdapter teacherAdapter;
    private FragmentMudurOgretmenListesiBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgretmenListesiBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherAdapter = new TeacherAdapter(getContext());
        ManagerAllTeacher t = ManagerAllTeacher.getInstance(getContext());
        t.getAllTeacher(this);

        binding.recyclerView.setAdapter(teacherAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);

    }
    @Override
    public void onGetTeachersSuccess(List<Teacher> teacherList) {
        Log.d("StudentAdapter", "onGetStudentsSuccess - itemCount: " + teacherAdapter.getItemCount());
        teacherAdapter.setTeacherList(teacherList);

    }
    @Override
    public void onGetTeachersFailed() {

    }
}