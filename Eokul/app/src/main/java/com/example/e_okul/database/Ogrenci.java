package com.example.e_okul.database;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.e_okul.ogrenci.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ogrenci {
    private final Context context;
    private String name;
    private String surname;
    private int no;
    private Runnable callback;

    private List studentList;

    public Ogrenci(Context context) {
        this.context = context;
    }

    public void getData() {
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        String url = "http://192.168.1.44/Eokul/ogrenci.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    // Parse JSON response
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        List<Student> studentList = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String name = jsonObject.getString("name");
                            String surname = jsonObject.getString("surname");
                            int no = jsonObject.getInt("no");

                            studentList.add(new Student(name,surname, no));
                        }
                        setStudentList(studentList);

                        // Set the values to RecyclerView
                        if (callback != null) {
                            callback.run();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("Error", "JSON parsing error: " + e.getMessage());
                    }
                },
                error -> Log.e("Error", Objects.requireNonNull(error.getLocalizedMessage()))) {
            @NonNull
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }
        };

        queue.add(stringRequest);
    }
    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name+surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
    public void setStudentList(List studentList){
        this.studentList=studentList;
    }
    public List getStudentList(){
        return studentList;
    }


}
