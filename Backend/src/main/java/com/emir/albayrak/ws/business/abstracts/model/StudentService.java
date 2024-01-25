package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import utility.result.DataResult;

import java.util.List;

public interface StudentService {
    Student findById(int id);

    List<Student> findAll();

    DataResult<Student> deleteStudent(String no);

}
