package com.example.e_okul.view.mudur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentMudurOgretmenIslemleriBinding;


public class MudurOgretmenIslemleriFragment extends Fragment {
    private FragmentMudurOgretmenIslemleriBinding binding;
;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMudurOgretmenIslemleriBinding.inflate(getLayoutInflater(),container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ogretmenEkleButton.setOnClickListener(view1 -> goToOgretmenEkle());
        binding.ogretmenListesiButton.setOnClickListener(view1 -> goToOgretmenListesi());
    }

    public void goToOgretmenEkle(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgretmenIslemleriFragment_to_mudurOgretmenEkleFragment);
    }
    public  void  goToOgretmenListesi(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgretmenIslemleriFragment_to_mudurOgretmenListesiFragment);
    }
}