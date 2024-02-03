package com.example.e_okul.view.ogrenci;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.adapters.NotlarAdapter;
import com.example.e_okul.databinding.FragmentOgrenciNotlarBinding;
import com.example.e_okul.model.Notlar;
import com.example.e_okul.model.Student;

import java.util.ArrayList;
import java.util.List;

public class OgrenciNotlarFragment extends Fragment {
      private FragmentOgrenciNotlarBinding binding;
      private NotlarAdapter notlarAdapter;
      List<Notlar> noteList;
    Notlar note1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding=FragmentOgrenciNotlarBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notlarAdapter=new NotlarAdapter(getContext());

        binding.recyclerView.setAdapter(notlarAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);


        noteList = new ArrayList<>();
        note1 = new Notlar();
        note1.set_final("35");
        note1.setVize("45");
        note1.setDersAdi("Matematik");

        noteList.add(note1);
        notlarAdapter.setNoteList(noteList);
    }
}