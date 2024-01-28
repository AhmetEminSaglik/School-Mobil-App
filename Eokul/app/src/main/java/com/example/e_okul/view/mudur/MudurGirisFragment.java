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
import com.example.e_okul.databinding.FragmentMudurGirisBinding;

public class MudurGirisFragment extends Fragment {

    private FragmentMudurGirisBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMudurGirisBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       binding.buttonLogin.setOnClickListener(view1 -> go());

    }

    public void go(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurGirisFragment_to_mudurAnaSayfaFragment);

    }
}