package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findById(int id);
    List<Teacher> findAllByName(String name);
    List<Teacher> findAllByLastname(String lastName);
}
