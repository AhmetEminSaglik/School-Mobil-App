package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproject.model.Teacher;
import com.example.testproject.model.response.abstracts.RestApiErrorResponse;
import com.example.testproject.model.response.abstracts.RestApiResponse;
import com.example.testproject.restapi.ManagerAll;
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


        TextView tv = (TextView) findViewById(R.id.txt);
        String text = sendRecommendAuthorByPointRequest();
        Log.e("SON GELEN TEXT : ",text);
        tv.setText(text);
    }

    private String sendRecommendAuthorByPointRequest() {
        String text = "";
        Call<RestApiResponse<List<Teacher>>> call = ManagerAll.getInstance().getAllTeacher();

        try {
            List<Teacher> teacherList = null;
            Response<RestApiResponse<List<Teacher>>> response = call.execute();
            Log.e("response : ",response.toString());
            if (response.code() == 200) {
                teacherList = response.body().getData();
Log.e("AAAAAAAAAAAAAA","AAAAAAAAAAAAAAAAAAAA");
            } else/* if (response.code() == 400) */ {
                Log.e("AAAAAAAAAAAAAA","BBBBBBBBBBBBBBBBB");

                Gson gson = new Gson();
                RestApiErrorResponse errorResponse = gson.fromJson(response.errorBody().charStream(), RestApiErrorResponse.class);
                String errMsg = errorResponse.getMessage();
                if (errMsg != null) {
                    Log.e("Error  ", errMsg);
                    Log.e("AAAAAAAAAAAAAA","CCCCCCCCCCC");

                }else{
                    Log.e("AAAAAAAAAAAAAA","DDDDDDDDDDDDDDDDDD");

                }
                Log.e("AAAAAAAAAAAAAA","EEEEEEEEEEEEEE");

                // Toast.makeText(context, errMsg, Toast.LENGTH_LONG).show();
            }
            Log.e("AAAAAAAAAAAAAA","FFFFFFFFFFFFFFFF");

            //return getRecommendedAuthor(authorList, EnumRecommendReason.HIGH_POINT.getName());
            String data = "";
            if (teacherList == null) {
                data = "NULL geldi";
            } else {
                data = " Teacher size " + teacherList.size();
            }
            Log.e("teacher list : ", data);
            System.out.println("teacher list : "+ data);
//            System.out.println();
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println("Teacher : " + teacherList.get(i));
                text += "\ntecher : " + teacherList.get(i);
            }

            Log.e("AAAAAAAAAAAAAA","OOOOOOOOOOKKKKKKKKKKKKKKKKK");
        } catch (IOException e) {
            e.printStackTrace();
            // return null;
        }
        return text;
    }
}