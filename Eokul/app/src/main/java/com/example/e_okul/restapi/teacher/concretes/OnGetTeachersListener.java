package com.example.e_okul.restapi.teacher.concretes;

import com.example.e_okul.model.Student;
import com.example.e_okul.model.Teacher;

import java.util.List;

public interface OnGetTeachersListener {
    void onGetTeachersSuccess(List<Teacher> teacherList);

    void onGetTeachersFailed();
}
