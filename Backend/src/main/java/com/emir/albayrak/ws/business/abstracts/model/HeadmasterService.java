
package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;

public interface HeadmasterService {

    Teacher saveTeacher(Teacher teacher);

    Student saveStudent(Student student);

}

