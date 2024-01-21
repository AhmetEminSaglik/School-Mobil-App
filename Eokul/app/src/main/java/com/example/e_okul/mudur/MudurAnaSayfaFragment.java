package com.example.e_okul.mudur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentMudurAnaSayfaBinding;


public class MudurAnaSayfaFragment extends Fragment {
    private FragmentMudurAnaSayfaBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentMudurAnaSayfaBinding.inflate(getLayoutInflater(),container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ogrenciIslemleriButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOgrenciIslemleri();
            }

        });


    }
    private void goToOgrenciIslemleri(){
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurAnaSayfaFragment_to_mudurOgrenciIslemleriFragment);
    }

}