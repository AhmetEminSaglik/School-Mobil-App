package com.example.e_okul.adapters;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_okul.R;
import com.example.e_okul.model.Student;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.util.ArrayList;
import java.util.List;

public class TeacherStudentListAdapter extends RecyclerView.Adapter<TeacherStudentListAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private final Context context;

    public TeacherStudentListAdapter(Context context) {
        this.context = context;
        this.studentList = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ogetmen_ogrenci_listesi_recycler_row, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        String adsoyad = student.getName() + " " + student.getLastname();
        holder.textViewName.setText(adsoyad);



        holder.saveButton.setOnClickListener(v -> {
            String vizeStr= holder.editTextVize.getText().toString();
            int vizeNotu=Integer.parseInt(vizeStr);
            String finalStr= holder.editTextFinal.getText().toString();
            int finalNotu =Integer.parseInt(finalStr);


            if(vizeNotu<=100 && finalNotu <=100) {
                Toast.makeText(v.getContext(), "Öğrenci Notu Başarılı Bir Şekilde Girildi", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(v.getContext(), "Vize ve Final Notları 100 den büyük olamaz!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        EditText editTextVize;
        EditText editTextFinal;
        ImageButton saveButton;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            editTextVize = itemView.findViewById(R.id.vizeEditText);
            editTextFinal = itemView.findViewById(R.id.finalEditText);
            saveButton = itemView.findViewById(R.id.saveButton);

        }
    }



    private void initSharedViewModel(Student student, View v) {
        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(OgrenciViewModel.class);
        ogrenciViewModel.setStudentName(student.getName());
        ogrenciViewModel.setStudentLastname(student.getLastname());
        ogrenciViewModel.setStudentNo(student.getNo());
        ogrenciViewModel.setStudentUserName(student.getUsername());
    }

    // ViewModel işlemleri burada

}


