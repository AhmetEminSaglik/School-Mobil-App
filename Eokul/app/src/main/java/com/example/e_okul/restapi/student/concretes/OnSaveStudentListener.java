package com.example.e_okul.restapi.student.concretes;

import com.example.e_okul.model.Student;

public interface OnSaveStudentListener {
    void onSaveSuccess(Student student);

    void onSaveFailed();

}
