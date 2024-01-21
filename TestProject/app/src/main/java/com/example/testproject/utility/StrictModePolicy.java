package com.example.testproject.utility;

import android.os.StrictMode;

public class StrictModePolicy {
    public  static void enable(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}
