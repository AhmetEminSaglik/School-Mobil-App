package com.example.e_okul.adapters;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_okul.R;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> implements ManagerAllStudent.OnDeleteStudentListener {

    private List<Student> studentList;
    private Context StudentAdapter;


    public StudentAdapter() {
        this.studentList = new ArrayList<>(); // Boş bir liste ile başlayabilirsiniz.
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged(); // Değişiklikleri RecyclerView'e bildir
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new StudentViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        String adsoyad = student.getName() + " " + student.getLastname();

        holder.textViewName.setText(adsoyad);
        holder.textViewSchoolNumber.setText(String.valueOf(student.getNo()));

        holder.editButton.setOnClickListener(v -> {

            goToOgrenciGuncelle(v);
            initSharedViewModel(student, v);

        });

        holder.deleteButton.setOnClickListener(s -> {
                    deleteStudent(student);

                }

        );
    }

    private void deleteStudent(Student student) {
        ManagerAllStudent s = ManagerAllStudent.getInstance(StudentAdapter);
        int studentId = student.getId();

        s.deleteStudent(studentId, (ManagerAllStudent.OnDeleteStudentListener) this);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    @Override
    public void onDeleteSuccess() {


    }

    @Override
    public void onDeleteFailed() {

    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewSchoolNumber;
        ImageButton editButton;
        ImageButton deleteButton;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewSchoolNumber = itemView.findViewById(R.id.textViewSchoolNumber);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    private void goToOgrenciGuncelle(View view) {
        NavController navController = Navigation.findNavController(view);
        navController.navigate(R.id.action_mudurOgrenciListesiFragment_to_mudurOgrenciGuncelleFragment);
    }

    private void initSharedViewModel(Student student, View v) {
        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(OgrenciViewModel.class);
        ogrenciViewModel.setStudentName(student.getName());
        ogrenciViewModel.setStudentSurname(student.getLastname());
        ogrenciViewModel.setStudentNo(student.getNo());
    }

    // ViewModel işlemleri burada

}





