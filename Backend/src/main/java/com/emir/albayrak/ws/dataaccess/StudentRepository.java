package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);

    Student findByNo(String no);

    List<Student> findAllByName(String name);

    List<Student> findAllByLastname(String lastName);
}

