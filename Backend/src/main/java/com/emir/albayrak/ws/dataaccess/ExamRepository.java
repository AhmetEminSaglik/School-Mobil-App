package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    List<Exam> findAll();

    Exam save(Exam exam);
}
