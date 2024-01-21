package com.example.e_okul.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentAnaGirisBinding;


public class AnaGirisFragment extends Fragment {
private FragmentAnaGirisBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentAnaGirisBinding.inflate(getLayoutInflater(),container,false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.mudurGirisButton.setOnClickListener (view1 -> loginMudur());
        binding.ogrenciGirisbutton.setOnClickListener (view12 -> loginOgrenci());


    }
    private void loginMudur(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_anaGirisFragment_to_mudurGirisFragment);
    }
    private void loginOgrenci(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_anaGirisFragment_to_ogrenciGirisFragment);
    }
}