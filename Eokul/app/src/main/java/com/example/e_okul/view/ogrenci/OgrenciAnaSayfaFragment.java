package com.example.e_okul.view.ogrenci;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgrenciAnaSayfaBinding;
import com.example.e_okul.viewmodel.OgrenciViewModel;

public class OgrenciAnaSayfaFragment extends Fragment {
    private String name;
    private String surname;
    private FragmentOgrenciAnaSayfaBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOgrenciAnaSayfaBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(requireActivity()).get(OgrenciViewModel.class);

        ogrenciViewModel.getStudentName().observe(getViewLifecycleOwner(), studentName -> {
            this.name = studentName;
        });

        ogrenciViewModel.getStudentLastname().observe(getViewLifecycleOwner(), studentSurname -> {
            this.surname = studentSurname;
            updateUI();
        });
        binding.notlarButton.setOnClickListener(view1 -> {
            NavController navController = Navigation.findNavController(requireView());
            navController.navigate(R.id.action_ogrenciAnaSayfaFragment_to_ogrenciNotlarFragment);
        });
        binding.duyurularButton.setOnClickListener(view1 -> {
            NavController navController = Navigation.findNavController(requireView());
            navController.navigate(R.id.action_ogrenciAnaSayfaFragment_to_ogrenciDuyurularFragment);

        });



    }

    @SuppressLint("SetTextI18n")
    private void updateUI() {
        // Burada UI güncelleme işlemlerini gerçekleştirin
        binding.ogrenci.setText(name + " " + surname);
    }
}

