package com.example.e_okul.view.ogretmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentOgretmenDuyurularBinding;

public class OgretmenDuyurularFragment extends Fragment {
    private FragmentOgretmenDuyurularBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOgretmenDuyurularBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.yayinlaButton.setOnClickListener(view1 -> {
            Toast.makeText(this.getContext(), "Duyuru başarıyla yayınlandı", Toast.LENGTH_SHORT).show();
        });
    }
}