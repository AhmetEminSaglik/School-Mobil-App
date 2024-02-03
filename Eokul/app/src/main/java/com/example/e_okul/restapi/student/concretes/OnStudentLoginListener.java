package com.example.e_okul.restapi.student.concretes;

import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;

public interface OnStudentLoginListener {
     void onLoginSuccess(Student student);
     void onLoginFailed();

}
