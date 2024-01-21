package com.example.e_okul.database;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Objects;


public class Read {
    private final TextView textView;

    public Read(EditText editText, TextView textView) {
        this.textView = textView;
    }

    public void postData() {
        RequestQueue queue = Volley.newRequestQueue(textView.getContext());
        String url = "http://192.168.1.44/Eokul/read.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i); // Değişiklik burada
                            String id = jsonObject.getString("id");
                            String data = jsonObject.getString("data");
                            textView.append("ID:" + id + " Data:" + data + "\n");
                        }
                    } catch (JSONException e) {
                        Log.e("Error", "JSON Parsing Error: " + e.getLocalizedMessage());
                        Toast.makeText(textView.getContext(), "Error parsing JSON", Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
                    Log.e("Error", Objects.requireNonNull(error.getLocalizedMessage()));
                    Toast.makeText(textView.getContext(), "Error connecting to server", Toast.LENGTH_SHORT).show();
                });

        queue.add(stringRequest);
    }
}

