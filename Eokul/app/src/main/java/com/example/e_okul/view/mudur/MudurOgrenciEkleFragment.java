package com.example.e_okul.view.mudur;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_okul.database.OgrenciEkle;
import com.example.e_okul.databinding.FragmentMudurOgrenciEkleBinding;
import com.example.e_okul.databinding.FragmentMudurOgrenciListesiBinding;


public class MudurOgrenciEkleFragment extends Fragment {
    private FragmentMudurOgrenciEkleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMudurOgrenciEkleBinding.inflate(getLayoutInflater(),container,false);
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



        ekleButton.setOnClickListener(it -> new OgrenciEkle(nameEditText,surnameEditText,tcknEditText,parentNameEditText,noEditText).postData());
    }



}