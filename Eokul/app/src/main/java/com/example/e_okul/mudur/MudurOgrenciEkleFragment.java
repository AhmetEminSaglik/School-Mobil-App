package com.example.e_okul.mudur;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_okul.database.Create;
import com.example.e_okul.databinding.FragmentMudurOgrenciEkleBinding;


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

        Create t= new Create(nameEditText,surnameEditText,tcknEditText,parentNameEditText,noEditText);

        ekleButton.setOnClickListener(it -> t.postData());
    }



}