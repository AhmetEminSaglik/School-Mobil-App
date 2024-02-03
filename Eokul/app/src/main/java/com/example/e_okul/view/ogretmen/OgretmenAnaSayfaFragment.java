package com.example.e_okul.view.ogretmen;

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
import com.example.e_okul.databinding.FragmentOgretmenAnaSayfaBinding;
import com.example.e_okul.viewmodel.OgretmenViewModel;

public class OgretmenAnaSayfaFragment extends Fragment {

    private String name;
    private String surname;
    private FragmentOgretmenAnaSayfaBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentOgretmenAnaSayfaBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OgretmenViewModel ogretmenViewModel = new ViewModelProvider(requireActivity()).get(OgretmenViewModel.class);

        binding.ogrenciListesiButton.setOnClickListener(view1 -> gotoStudentList());
        binding.duyurularButton.setOnClickListener(view1 -> goToAnnouncements());
        ogretmenViewModel.getTeacherName().observe(getViewLifecycleOwner(), teacherName -> this.name = teacherName);

        ogretmenViewModel.getTeacherLastName().observe(getViewLifecycleOwner(), teacherSurname -> {
            this.surname = teacherSurname;
            updateUI();
        });

    }

    private void goToAnnouncements(){
        NavController navController= Navigation.findNavController(requireView());
        navController.navigate(R.id.action_ogretmenAnaSayfaFragment_to_ogretmenDuyurularFragment);
    }
    private void gotoStudentList(){
        NavController navController= Navigation.findNavController(requireView());
        navController.navigate(R.id.action_ogretmenAnaSayfaFragment_to_ogretmenOgrenciListesiFragment);
    }
    @SuppressLint("SetTextI18n")
    private void updateUI() {
        // Burada UI güncelleme işlemlerini gerçekleştirin
        binding.ogretmen.setText(name + " " + surname);
    }
}