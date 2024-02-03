package com.example.e_okul.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
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
import com.example.e_okul.model.Teacher;
import com.example.e_okul.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.e_okul.restapi.teacher.concretes.OnDeleteTeacherListener;
import com.example.e_okul.viewmodel.OgretmenViewModel;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> implements OnDeleteTeacherListener {

    private List<Teacher> teacherList;
    private final Context context;

    public TeacherAdapter(Context context) {
        this.context = context;
        this.teacherList = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ogretmen_recycler_row, parent, false);
        return new TeacherViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        Teacher teacher = teacherList.get(position);
        String adsoyad = teacher.getName() + " " + teacher.getLastname();

        holder.textViewName.setText(adsoyad);
        holder.textViewBranch.setText(String.valueOf(teacher.getBranch()));

        holder.editButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_mudurOgretmenListesiFragment_to_mudurOgretmenGuncelleFragment);

            initSharedViewModel(teacher, v);

        });
        holder.deleteButton.setOnClickListener(view -> deleteTeacher(teacher)

        );}

    private void deleteTeacher(Teacher teacher) {
        ManagerAllTeacher t = ManagerAllTeacher.getInstance(context);
        Integer teacherId = teacher.getId();

        t.deleteTeacher(teacherId,this);
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    @Override
    public void onDeleteSuccess() {
        Toast.makeText(context,"Öğretmen Başarılı bir şekilde silindi", Toast.LENGTH_SHORT).show();

        if(context!=null){
            NavController navController= Navigation.findNavController(((Activity) context), R.id.fragmentContainerView2);
            navController.navigate(R.id.action_mudurOgretmenListesiFragment_to_mudurOgretmenIslemleriFragment);
        }
    }
    @Override
    public void onDeleteFailed() {
        Toast.makeText(context,"Öğretmen silinemedi",Toast.LENGTH_LONG).show();
    }

    public static class TeacherViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewBranch;
        ImageButton editButton;
        ImageButton deleteButton;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.teacherTextViewName);
            editButton = itemView.findViewById(R.id.teacherEditButton);
            textViewBranch = itemView.findViewById(R.id.teacherTextViewBranch);
            deleteButton=itemView.findViewById(R.id.teacherDeleteButton);
        }
    }

    private void initSharedViewModel(Teacher teacher, View v) {
        OgretmenViewModel ogretmenViewModel = new ViewModelProvider(
                (ViewModelStoreOwner) v.getContext(),
                new ViewModelProvider.AndroidViewModelFactory((Application) v.getContext().getApplicationContext())
        ).get(OgretmenViewModel.class);
        ogretmenViewModel.setTeacherName(teacher.getName());
        ogretmenViewModel.setTeacherLastName(teacher.getLastname());
        ogretmenViewModel.setTeacherBranch(teacher.getBranch());
        ogretmenViewModel.setTeacherId(teacher.getId());
    }
}





