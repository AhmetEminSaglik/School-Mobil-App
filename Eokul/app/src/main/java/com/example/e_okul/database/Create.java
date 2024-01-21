package com.example.e_okul.database;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Create {
    private final EditText nameEditText;
    private final EditText surnameEditText;
    private final EditText tcknEditText;
    private final EditText parentNameEditText;
    private final EditText noEditText;

    public Create(EditText nameEditText, EditText surnameEditText, EditText tcknEditText, EditText parentNameEditText, EditText noEditText) {
        this.nameEditText = nameEditText;
        this.surnameEditText = surnameEditText;
        this.tcknEditText = tcknEditText;
        this.parentNameEditText = parentNameEditText;
        this.noEditText = noEditText;
    }

    public void postData() {
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String tcknStr = tcknEditText.getText().toString();
        String parentName = parentNameEditText.getText().toString();
        String noStr = noEditText.getText().toString();

        // Veri türlerini kontrol et ve uygun hale getir
        try {
            long tc_kn = Long.parseLong(tcknStr);
            int no = Integer.parseInt(noStr);

            RequestQueue queue = Volley.newRequestQueue(nameEditText.getContext());
            String url = "http://192.168.1.44/Eokul/create.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> {
                        if (response.equals("Success")) {
                            Toast.makeText(nameEditText.getContext(), "Data added", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(nameEditText.getContext(), response, Toast.LENGTH_LONG).show();
                        }
                    }, error -> Log.e("Error", Objects.requireNonNull(error.getLocalizedMessage()))) {
                @NonNull
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("name", name);
                    params.put("surname", surname);
                    params.put("tc_kn", String.valueOf(tc_kn));
                    params.put("parentName", parentName);
                    params.put("no", String.valueOf(no));
                    return params;
                }
            };

            queue.add(stringRequest);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.e("Error", "Invalid number format for tckn or no: " + e.getMessage());
            Toast.makeText(nameEditText.getContext(), "Invalid number format for tckn or no", Toast.LENGTH_LONG).show();
        }
    }
}
