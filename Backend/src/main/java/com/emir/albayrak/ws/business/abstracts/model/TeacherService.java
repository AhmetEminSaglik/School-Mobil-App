package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(int id);


}