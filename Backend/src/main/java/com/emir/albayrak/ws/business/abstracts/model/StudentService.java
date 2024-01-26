package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;

import java.util.List;

public interface StudentService {
    Student findById(int id);

    Parent findParent(int parentId);

    List<Student> findAll();
    boolean deleteById(int id);


}
