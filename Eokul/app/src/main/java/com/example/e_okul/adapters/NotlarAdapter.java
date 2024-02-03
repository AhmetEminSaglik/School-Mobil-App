package com.example.e_okul.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.e_okul.model.Notlar;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnDeleteStudentListener;
import com.example.e_okul.viewmodel.NotlarViewModel;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.NotlarViewHolder>  {

    private List<Notlar> notListesi;
    private final Context context;

    public NotlarAdapter(Context context) {
        this.context = context;
        this.notListesi = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNoteList(List<Notlar> noteList) {
        this.notListesi = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotlarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notlar_recycler_row, parent, false);
        return new NotlarViewHolder(view);
    }

    public void onBindViewHolder(@NonNull NotlarViewHolder holder, int position) {
        Notlar not=notListesi.get(position);
        holder.dersAdi.setText(not.getDersAdi());
        holder.vize.setText(not.getVize());
        holder._final.setText(not.get_final());


    }


    @Override
    public int getItemCount() {
        return notListesi.size();
    }



    public static class NotlarViewHolder extends RecyclerView.ViewHolder {
        TextView dersAdi;
        TextView vize;
        TextView _final;



        public NotlarViewHolder(@NonNull View itemView) {
            super(itemView);
            dersAdi = itemView.findViewById(R.id.notlarDersAdi);
            vize = itemView.findViewById(R.id.notlarVize);
            _final=itemView.findViewById(R.id.notlarFinal);

        }
    }



    private void initSharedViewModel(Notlar not, View v) {
        NotlarViewModel notlarViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(NotlarViewModel.class);
        notlarViewModel.set_final(not.get_final());
        notlarViewModel.setVize(not.getVize());
        notlarViewModel.setDersAdi(not.getDersAdi());

    }
}





