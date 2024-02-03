package com.example.e_okul.view.ogrenci;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgrenciSecilenDuyuruBinding;
import com.example.e_okul.viewmodel.DuyurularViewModel;
import com.example.e_okul.viewmodel.OgretmenViewModel;


public class OgrenciSecilenDuyuruFragment extends Fragment {
    FragmentOgrenciSecilenDuyuruBinding binding;
    String baslik;
    String icerik;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOgrenciSecilenDuyuruBinding.inflate(getLayoutInflater(),container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DuyurularViewModel duyurularViewModel = new ViewModelProvider(requireActivity()).get(DuyurularViewModel.class);
        duyurularViewModel.getDuyuruBaslik().observe(getViewLifecycleOwner(),
                duyuruBaslik -> this.baslik = duyuruBaslik
        );
        duyurularViewModel.getDuyuruIcerik().observe(getViewLifecycleOwner(),
                duyuruIcerik -> {
                    this.icerik = duyuruIcerik;

                    updateUI();
                });

    }

    private void updateUI() {
        binding.duyuruBaslik.setText(baslik);
        binding.duyuruIcerik.setText(icerik);



    }
}