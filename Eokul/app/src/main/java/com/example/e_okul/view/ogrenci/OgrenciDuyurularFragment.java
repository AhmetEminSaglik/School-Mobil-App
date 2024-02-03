package com.example.e_okul.view.ogrenci;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.adapters.DuyurularAdapter;
import com.example.e_okul.adapters.NotlarAdapter;
import com.example.e_okul.databinding.FragmentOgrenciDuyurularBinding;
import com.example.e_okul.model.Duyurular;
import com.example.e_okul.model.Notlar;

import java.util.ArrayList;
import java.util.List;


public class OgrenciDuyurularFragment extends Fragment {
    private FragmentOgrenciDuyurularBinding binding;
    DuyurularAdapter duyurularAdapter;
    List<Duyurular> duyurularList;
    Duyurular duyuru1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentOgrenciDuyurularBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        duyurularAdapter=new DuyurularAdapter(getContext());

        binding.recyclerView.setAdapter(duyurularAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);


        duyurularList = new ArrayList<>();
        duyuru1 = new Duyurular();
        duyuru1.setDuyuruBaslik("Dikkat dikkat bu bir duyurudur ");
        duyuru1.setDuyuruIcerik("lsdkgnkldsngldsjgljsdlkgnlksdnglksdnglksnglksdnglknsdlkgnlsdk");


        duyurularList.add(duyuru1);
        duyurularAdapter.setNoteList(duyurularList);
    }
}