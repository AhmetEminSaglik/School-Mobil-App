package com.example.e_okul.view.mudur;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.database.OgrenciListesi;
import com.example.e_okul.databinding.FragmentMudurOgrenciListesiBinding;

public class MudurOgrenciListesiFragment extends Fragment {
    private FragmentMudurOgrenciListesiBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciListesiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OgrenciListesi ogrenciListesi = new OgrenciListesi(binding);
        ogrenciListesi.getData();
    }


}
