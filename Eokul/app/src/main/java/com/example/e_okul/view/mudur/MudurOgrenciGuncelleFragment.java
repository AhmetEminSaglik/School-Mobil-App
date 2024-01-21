package com.example.e_okul.view.mudur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_okul.R;
import com.example.e_okul.database.OgrenciEkle;
import com.example.e_okul.database.OgrenciGuncelle;
import com.example.e_okul.databinding.FragmentMudurOgrenciGuncelleBinding;
import com.example.e_okul.viewmodel.OgrenciViewModel;


public class MudurOgrenciGuncelleFragment extends Fragment {
    private String name;
    private String surname;
    private long tc_kn;
    private int no;
    private String parentName;
     private FragmentMudurOgrenciGuncelleBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMudurOgrenciGuncelleBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText nameEditText = binding.adEditText;
        EditText surnameEditText= binding.soyadEditText;
        EditText tcknEditText=binding.tcknEditText;
        EditText parentNameEditText=binding.veliAdiEditText;
        EditText noEditText=binding.noEditText;

        Button ekleButton = binding.ekleButton;

        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(requireActivity()).get(OgrenciViewModel.class);
        ogrenciViewModel.getStudentName().observe(getViewLifecycleOwner(), studentName -> {
            this.name = studentName;

        });
        ogrenciViewModel.getStudentSurname().observe(getViewLifecycleOwner(), studentSurname -> {
            this.surname = studentSurname;

        });
        ogrenciViewModel.getStudenTc_kn().observe(getViewLifecycleOwner(), studentTc_kn -> {
            this.tc_kn =studentTc_kn;

        });
        ogrenciViewModel.getStudentNo().observe(getViewLifecycleOwner(), studentNo -> {
            this.no = studentNo;


        });
        ogrenciViewModel.getStudentParentName().observe(getViewLifecycleOwner(), studentParentName -> {
            this.parentName = studentParentName;

            updateUI();
        });

        ekleButton.setOnClickListener(it -> new OgrenciGuncelle(nameEditText,surnameEditText,tcknEditText,parentNameEditText,noEditText).updateData());
    }
    private void updateUI() {
        binding.adEditText.setText(name);
        binding.soyadEditText.setText(surname);
        binding.noEditText.setText(String.valueOf(no));
        binding.tcknEditText.setText(String.valueOf(tc_kn));
        binding.veliAdiEditText.setText(parentName);
    }
    }

