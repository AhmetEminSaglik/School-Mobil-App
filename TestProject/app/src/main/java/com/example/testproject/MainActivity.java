package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiErrorResponse;
import com.example.testproject.model.response.abstracts.RestApiResponse;
import com.example.testproject.restapi.ManagerAllStudent;
import com.example.testproject.restapi.ManagerAllTeacher;
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
        Log.e("SON GELEN TEXT : ", text);
        tv.setText(text);


    }

    private String getAllTeachers() {
        String text = "";
        Call<RestApiResponse<List<Teacher>>> call = ManagerAllTeacher.getInstance().getAllTeacher();

        try {
            List<Teacher> teacherList = null;
            Response<RestApiResponse<List<Teacher>>> response = call.execute();
            Log.e("response : ", response.toString());
            if (response.code() == 200) {
                teacherList = response.body().getData();
            } else {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                }
                // Toast.makeText(context, errMsg, Toast.LENGTH_LONG).show();
            }
            String data = "";
            if (teacherList == null) {
                data = "NULL geldi";
            }
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println("Teacher : " + teacherList.get(i));
                text += "\n\nTeacher : " + teacherList.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // return null;
        }
        return text;
    }

    private String getAllStudents() {
        String text = "";
        Call<RestApiResponse<List<Student>>> call = ManagerAllStudent.getInstance().getAllStudents();

        try {
            List<Student> studentList = null;
            Response<RestApiResponse<List<Student>>> response = call.execute();
            Log.e("response : ", response.toString());
            if (response.code() == 200) {
                studentList = response.body().getData();
            } else/* if (response.code() == 400) */ {
                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                }
                // Toast.makeText(context, errMsg, Toast.LENGTH_LONG).show();
            }
            //return getRecommendedAuthor(authorList, EnumRecommendReason.HIGH_POINT.getName());
            String data = "";
            if (studentList == null) {
                data = "NULL geldi";
            } else {
                data = " Teacher size " + studentList.size();
            }
            Log.e("teacher list : ", data);
            System.out.println("teacher list : " + data);
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("Teacher : " + studentList.get(i));
                text += "\n\nTeacher : " + studentList.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // return null;
        }
        return text;
    }
}