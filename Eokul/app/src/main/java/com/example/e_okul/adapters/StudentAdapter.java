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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_okul.R;
import com.example.e_okul.model.Student;
import com.example.e_okul.restapi.student.concretes.ManagerAllStudent;
import com.example.e_okul.restapi.student.concretes.OnDeleteStudentListener;
import com.example.e_okul.viewmodel.OgrenciViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> implements OnDeleteStudentListener {

    private List<Student> studentList;
    private final Context context;

    public StudentAdapter(Context context) {
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
            NavController navController = Navigation.findNavController(v);

            navController.navigate(R.id.action_mudurOgrenciListesiFragment_to_mudurOgrenciGuncelleFragment);
            initSharedViewModel(student, v);

        });

        holder.deleteButton.setOnClickListener(s -> deleteStudent(student)

        );
    }

    private void deleteStudent(Student student) {
        ManagerAllStudent s = ManagerAllStudent.getInstance(context);
        String studentNo = String.valueOf(student.getNo());

        s.deleteStudent(studentNo, this);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    @Override
    public void onDeleteSuccess() {
        Toast.makeText(context, "Öğrenci başarılı bir şekilde silindi", Toast.LENGTH_LONG).show();

        if (context != null) {
            NavController navController = Navigation.findNavController((Activity) context, R.id.fragmentContainerView2);
            navController.navigate(R.id.action_mudurOgrenciListesiFragment_to_mudurOgrenciIslemleriFragment);
        } else {
            Log.e("StudentAdapter", "Context is null, unable to navigate.");
        }}

    @Override
    public void onDeleteFailed() {
        Toast.makeText(context,"Öğrenci silinemedi",Toast.LENGTH_LONG).show();}

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



    private void initSharedViewModel(Student student, View v) {
        OgrenciViewModel ogrenciViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(OgrenciViewModel.class);
        ogrenciViewModel.setStudentName(student.getName());
        ogrenciViewModel.setStudentLastname(student.getLastname());
        ogrenciViewModel.setStudentNo(student.getNo());
        ogrenciViewModel.setStudentUserName(student.getUsername());
        ogrenciViewModel.setStudentPassword(student.getPassword());
        ogrenciViewModel.setStudentId(student.getId());

    }

    // ViewModel işlemleri burada

}





