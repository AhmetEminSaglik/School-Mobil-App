package com.example.e_okul.mudur;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e_okul.R;
import com.example.e_okul.adapters.StudentAdapter;
import com.example.e_okul.database.Ogrenci;
import com.example.e_okul.databinding.FragmentMudurOgrenciListesiBinding;
import java.util.List;


public class MudurOgrenciListesiFragment extends Fragment {
    private FragmentMudurOgrenciListesiBinding binding;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMudurOgrenciListesiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context1= getContext();
        Ogrenci ogrenci= new Ogrenci(context1);
        ogrenci.setCallback(()->{

            List studentList=ogrenci.getStudentList();

            recyclerView = binding.recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

            studentAdapter = new StudentAdapter(studentList);
            recyclerView.setAdapter(studentAdapter);

           /* StudentAdapter.StudentViewHolder studentViewHolder=new StudentAdapter.StudentViewHolder(binding.getRoot());
            ImageButton editButton= studentViewHolder.getEditButton();
            editButton.setOnClickListener(it -> goToOgrenciGuncelle());*/
        });
        ogrenci.getData();
    }

    private void goToOgrenciGuncelle() {
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurOgrenciListesiFragment_to_mudurOgrenciGuncelleFragment);
    }
}
