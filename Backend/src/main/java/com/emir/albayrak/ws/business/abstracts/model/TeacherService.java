package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.business.abstracts.model.searchuser.SearchTeacherByProperties;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import utility.result.DataResult;

import java.util.List;

public interface TeacherService extends SearchTeacherByProperties {
    List<Teacher> findAll();

    Teacher findById(int id);
    DataResult<Teacher> deleteTeacher(int no);


}
