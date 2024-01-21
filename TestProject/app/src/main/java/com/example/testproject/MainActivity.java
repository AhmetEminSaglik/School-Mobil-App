package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiErrorResponse;
import com.example.testproject.model.response.abstracts.RestApiResponse;
import com.example.testproject.restapi.student.concretes.ManagerAllStudent;
import com.example.testproject.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.testproject.utility.StrictModePolicy;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictModePolicy.enable();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = findViewById(R.id.txt);
        String text = getAllTeachers();
//        String text = getAllStudents();
        Log.e("SON GELEN TEXT : ", text);
        tv.setText(text);


    }

    private String getAllTeachers() {
        String text = "";
        List<Teacher> list = ManagerAllTeacher.getInstance().getAllTeacher();

        StringBuilder sb = new StringBuilder();
        for (Teacher tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
}

    private String getAllStudents() {
        List<Student> studentList = ManagerAllStudent.getInstance().getAllStudents();

        StringBuilder sb = new StringBuilder();
        for (Student tmp : studentList) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}