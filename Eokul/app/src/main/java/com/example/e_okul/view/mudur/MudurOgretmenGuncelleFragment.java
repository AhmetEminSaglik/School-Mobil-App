package com.example.e_okul.view.mudur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_okul.databinding.FragmentMudurOgretmenGuncelleBinding;
import com.example.e_okul.model.Teacher;
import com.example.e_okul.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.e_okul.restapi.teacher.concretes.OnUpdateTeacherListener;
import com.example.e_okul.viewmodel.OgretmenViewModel;


public class MudurOgretmenGuncelleFragment extends Fragment implements OnUpdateTeacherListener {
    private FragmentMudurOgretmenGuncelleBinding binding;
    private String name;
    private String lastname;
    private String branch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMudurOgretmenGuncelleBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OgretmenViewModel ogretmenViewModel = new ViewModelProvider(requireActivity()).get(OgretmenViewModel.class);
        ogretmenViewModel.getTeacherName().observe(getViewLifecycleOwner(),
                teacherName -> this.name = teacherName
        );
        ogretmenViewModel.getTeacherLastName().observe(getViewLifecycleOwner(),
                teacherLastname -> this.lastname = teacherLastname
        );

        ogretmenViewModel.getTeacherBranch().observe(getViewLifecycleOwner(), teacherBranch -> {
            this.branch = teacherBranch;

            updateUI();
        });

        Teacher teacher= new Teacher();
        teacher.setName("Fatih");
        teacher.setLastname("Altun");
        teacher.setBranch("Su Yapilari" );
        teacher.setGraduatedUniversity("");
        teacher.setId(10);
        teacher.setRoleId(2);
        teacher.setUsername("babapro1234");
        teacher.setPassword("passs");

        ManagerAllTeacher t=ManagerAllTeacher.getInstance(getContext());
        binding.guncelleButton.setOnClickListener(view1 -> t.updateTeacher(teacher,this));
    }


    private void updateUI() {
        binding.adEditText.setText(name);
        binding.soyadEditText.setText(lastname);
        binding.bransEditText.setText(branch);
    }
    @Override
    public void onUpdateSuccess() {
        Toast.makeText(getContext(),"Öğretmen başarılı bir şekilde güncellendi" ,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onUpdateFailed() {
        Toast.makeText(getContext(),"Öğretmen güncelleme başarısız" ,Toast.LENGTH_LONG).show();

    }
}