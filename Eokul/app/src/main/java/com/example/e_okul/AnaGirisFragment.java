package com.example.e_okul;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.databinding.FragmentAnaGirisBinding;


public class AnaGirisFragment extends Fragment {
private FragmentAnaGirisBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentAnaGirisBinding.inflate(getLayoutInflater(),container,false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.mudurGirisButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });


    }
    private void login(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_anaGirisFragment_to_mudurGirisFragment);
    }
}