package com.example.e_okul.mudur;

import android.os.Bundle;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciIslemleriBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ogrenciEkleButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOgrenciEkle();
            }

        });
        binding.ogrenciListesiButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOgrenciListesi();
            }

        });

        binding.ogrenciAraButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOgrenciAra();
            }

        });



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