package com.example.e_okul.restapi.teacher.concretes;

import com.example.e_okul.model.Teacher;

public interface OnTeacherLoginListener {
    void loginSuccess(Teacher teacher);
    void loginFailed();
}
