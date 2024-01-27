package com.example.e_okul.view.mudur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentMudurOgrenciIslemleriBinding;


public class MudurOgrenciIslemleriFragment extends Fragment {
    private FragmentMudurOgrenciIslemleriBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciIslemleriBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ogrenciEkleButton.setOnClickListener (view1 -> goToOgrenciEkle());
        binding.ogrenciListesiButton.setOnClickListener (view2 -> goToOgrenciListesi());
        binding.ogrenciAraButton.setOnClickListener (view3 -> goToOgrenciAra());



    }
    private void goToOgrenciEkle(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgrenciIslemleriFragment_to_mudurOgrenciEkleFragment);
    }
    private void goToOgrenciListesi(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgrenciIslemleriFragment_to_mudurOgrenciListesiFragment);
    }
    private void goToOgrenciAra(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgrenciIslemleriFragment_to_mudurOgrenciAraFragment);
    }

}