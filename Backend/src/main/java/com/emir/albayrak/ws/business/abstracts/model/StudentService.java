package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;

import java.util.List;

public interface StudentService {
    Parent findParent(int parentId);

    List<Student> findAll();
}
