package com.example.e_okul.view.mudur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e_okul.databinding.FragmentMudurOgretmenEkleBinding;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.e_okul.restapi.teacher.concretes.OnSaveTeacherListener;


public class MudurOgretmenEkleFragment extends Fragment implements OnSaveTeacherListener {
    private FragmentMudurOgretmenEkleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMudurOgretmenEkleBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Teacher teacher=new Teacher();

        teacher.setName("Fatih");
        teacher.setLastname("Altunn");
        teacher.setBranch("Dynamicc");
        teacher.setUsername("fthg");

        ManagerAllTeacher t= ManagerAllTeacher.getInstance(getContext());
        t.saveTeacher(teacher,this);
    }

    @Override
    public void onSaveSuccess() {
    }

    @Override
    public void onSaveFailed() {

    }
}