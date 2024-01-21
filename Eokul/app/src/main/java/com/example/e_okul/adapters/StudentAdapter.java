package com.example.e_okul.adapters;

import android.annotation.SuppressLint;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_okul.R;
import com.example.e_okul.database.OgrenciSil;
import com.example.e_okul.model.Student;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
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
        String adsoyad = student.getName() + " " + student.getSurname();

        holder.textViewName.setText(adsoyad);
        holder.textViewSchoolNumber.setText(String.valueOf(student.getNo()));

        holder.editButton.setOnClickListener(v -> {
            goToOgrenciGuncelle(v);
            initSharedViewModel(student, v);
        });

        holder.deleteButton.setOnClickListener(s -> deleteStudent(student));
    }

    private void deleteStudent(Student student) {
        OgrenciSil ogrenciSil = new OgrenciSil(student.getNo(), new OgrenciSil.OgrenciSilCallback() {
            @Override
            public void onOgrenciSilSuccess() {
                // Silme işlemi başarılı olduğunda yapılacak işlemler
                // Örneğin, öğrenci listesini güncelleyerek RecyclerView'i yeniden yükle
                notifyDataSetChanged();
            }

            @Override
            public void onOgrenciSilFailure() {
                // Silme işlemi başarısız olduğunda yapılacak işlemler
                // Hata mesajını kullanıcıya göster veya başka bir işlem yap
            }
        });
        ogrenciSil.deleteData();
    }

    @Override
    public int getItemCount() {
        return studentList.size();
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
        ogrenciViewModel.setStudentSurname(student.getSurname());
        ogrenciViewModel.setStudentNo(student.getNo());
        ogrenciViewModel.setStudentTc_kn(student.getTc_kn());
        ogrenciViewModel.setParentName(student.getParentName());
    }

    // ViewModel işlemleri burada

}





