package com.example.e_okul.view.mudur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_okul.databinding.FragmentMudurOgrenciGuncelleBinding;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnUpdateStudentListener;
import com.example.e_okul.viewmodel.OgrenciViewModel;


public class MudurOgrenciGuncelleFragment extends Fragment implements OnUpdateStudentListener {
    private String name;
    private String lastname;
    private String no;
    private String username;
    private String password;
    private String id;

    private FragmentMudurOgrenciGuncelleBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciGuncelleBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(requireActivity()).get(OgrenciViewModel.class);
        ogrenciViewModel.getStudentName().observe(getViewLifecycleOwner(), studentName ->
                this.name = studentName

        );
        ogrenciViewModel.getStudentLastname().observe(getViewLifecycleOwner(), studentLastname ->
                this.lastname = studentLastname
        );
        ogrenciViewModel.getStudentUserName().observe(getViewLifecycleOwner(),studentUserName ->
                this.username=studentUserName
        );
        ogrenciViewModel.getStudentPassword().observe(getViewLifecycleOwner(),studentPassword ->
                this.password=studentPassword
        );
        ogrenciViewModel.getStudentId().observe(getViewLifecycleOwner(),studentId ->
                this.id=String.valueOf(studentId)
        );

        ogrenciViewModel.getStudentNo().observe(getViewLifecycleOwner(), studentNo -> {
            this.no = studentNo;


            updateUI();
        });

        Student student = new Student();

        ManagerAllStudent s = ManagerAllStudent.getInstance(getContext());
        binding.guncelleButton.setOnClickListener(view1 -> {
            student.setName(binding.adEditText.getText().toString());
            student.setLastname(binding.soyadEditText.getText().toString());
            student.setParentId(3);
            student.setId(Integer.parseInt(id));// id alınacak
            student.setNo(binding.noEditText.getText().toString());
            student.setUsername(binding.kullaniciAdiEditText.getText().toString());
            student.setRoleId(3);
            student.setPassword(binding.sifreEditText.getText().toString());

            s.updateStudent(student, this);});


    }

    private void updateUI() {
        binding.adEditText.setText(name);
        binding.soyadEditText.setText(lastname);
        binding.noEditText.setText(String.valueOf(no));
        binding.kullaniciAdiEditText.setText(username);
        binding.sifreEditText.setText(password);


    }

    @Override
    public void onUpdateSucccess() {
        Toast.makeText(getContext(), "Öğrenci başarılı bir şekilde güncellendi", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpdateFailed() {
        Toast.makeText(getContext(), "Öğrenci güncelleme başarısız oldu", Toast.LENGTH_LONG).show();

    }
}

