package com.example.e_okul.database;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Update {
    private EditText editText;

    public Update(EditText editText) {
        this.editText = editText;
    }

    public void postData() {
        String data = editText.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(editText.getContext());
        String url = "http://192.168.1.44/Eokul/update.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Success")) {
                            Toast.makeText(editText.getContext(), "Data updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(editText.getContext(), response, Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getLocalizedMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> paramV = new HashMap<>();
                paramV.put("data", data);
                paramV.put("id", "2");
                return paramV;
            }
        };

        queue.add(stringRequest);
    }
}

