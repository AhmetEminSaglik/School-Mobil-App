package com.example.e_okul.restapi.student.concretes;


import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.model.Student;

import java.util.List;

public interface OnGetStudentsListener {

    void onGetStudentsSuccess(List<Student> studentList);
    void onGetStudentsFailed();

    void onGetStudentByIdSucces(Student student);

    void  onGetStudentByUsernameSuccess(Student student, LoginCredentials loginCredentials);
}