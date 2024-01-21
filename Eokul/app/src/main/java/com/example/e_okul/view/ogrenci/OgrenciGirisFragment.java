package com.example.e_okul.view.ogrenci;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.database.OgrenciGiris;
import com.example.e_okul.databinding.FragmentOgrenciGirisBinding;
import com.example.e_okul.viewmodel.OgrenciViewModel;

public class OgrenciGirisFragment extends Fragment {
    private OgrenciViewModel ogrenciViewModel;
    private FragmentOgrenciGirisBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModelProvider aracılığıyla ViewModel'ı alın
        ogrenciViewModel = new ViewModelProvider(requireActivity()).get(OgrenciViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOgrenciGirisBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      binding.buttonLogin.setOnClickListener(view1 -> new OgrenciGiris(binding).getData());
    }


}
