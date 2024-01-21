package com.example.e_okul.view.mudur;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.e_okul.database.OgrenciAra;
import com.example.e_okul.databinding.FragmentMudurOgrenciAraBinding;

public class MudurOgrenciAraFragment extends Fragment {

    private FragmentMudurOgrenciAraBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciAraBinding.inflate(getLayoutInflater(), container, false);
        //EditText editTextSearchResult = binding.editTextSearchResult; // editTextSearchResult'a erişim
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.searchButton.setOnClickListener(it -> new OgrenciAra(binding).getData());
    }




}
