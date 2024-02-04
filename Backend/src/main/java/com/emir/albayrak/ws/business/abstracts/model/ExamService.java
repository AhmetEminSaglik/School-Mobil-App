package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Exam;
import utility.result.DataResult;

import java.util.List;

public interface ExamService {
    List<Exam> findAll();

    Exam save(Exam exam);

    DataResult<Exam> update(Exam exam);

    Exam findById(int id);
}
