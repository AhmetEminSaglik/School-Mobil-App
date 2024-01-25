package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import utility.result.DataResult;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Parent findParentById(int studentId);
    Student findById(int id);
    Student findByNo(String no);
}

