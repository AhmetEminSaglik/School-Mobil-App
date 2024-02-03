package com.example.e_okul.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_okul.R;
import com.example.e_okul.model.Duyurular;
import com.example.e_okul.model.Notlar;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnDeleteStudentListener;
import com.example.e_okul.viewmodel.DuyurularViewModel;
import com.example.e_okul.viewmodel.NotlarViewModel;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.util.ArrayList;
import java.util.List;

public class DuyurularAdapter extends RecyclerView.Adapter<DuyurularAdapter.DuyurularViewHolder>  {

    private List<Duyurular> duyurularList;
    private final Context context;

    public DuyurularAdapter(Context context) {
        this.context = context;
        this.duyurularList = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNoteList(List<Duyurular> duyurularListesi) {
        this.duyurularList = duyurularListesi;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DuyurularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.duyurular_recycler_row, parent, false);
        return new DuyurularViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DuyurularViewHolder holder, int position) {
        Duyurular duyuru=duyurularList.get(position);
        holder.duyuruBaslik.setText(duyuru.getDuyuruBaslik());

        holder.duyuru.setOnClickListener(view -> {

            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_ogrenciDuyurularFragment_to_ogrenciSecilenDuyuruFragment);

            initSharedViewModel(duyuru,view);


        });


    }


    @Override
    public int getItemCount() {
        return duyurularList.size();
    }



    public static class DuyurularViewHolder extends RecyclerView.ViewHolder {
        TextView duyuruBaslik;
        Button duyuru;





        @SuppressLint("CutPasteId")
        public DuyurularViewHolder(@NonNull View itemView) {
            super(itemView);
            duyuruBaslik = itemView.findViewById(R.id.duyuruBaslik);
            duyuru=itemView.findViewById(R.id.duyuruBaslik);

        }
    }



    private void initSharedViewModel(Duyurular duyuru, View v) {
        DuyurularViewModel duyurularViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(DuyurularViewModel.class);
        duyurularViewModel.setDuyuruBaslik(duyuru.getDuyuruBaslik());
        duyurularViewModel.setDuyuruIcerik(duyuru.getDuyuruIcerik());

    }
}





