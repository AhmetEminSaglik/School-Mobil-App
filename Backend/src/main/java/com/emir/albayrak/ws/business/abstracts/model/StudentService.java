package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.business.abstracts.model.searchuser.SearchUserByProperties;
import com.emir.albayrak.ws.model.Student;
import utility.result.DataResult;

import java.util.List;

public interface StudentService extends SearchUserByProperties<Student> {
    Student findById(int id);

    List<Student> findAll();

    Student findByNo(String no);

    DataResult<Student> deleteStudent(String no);

}
