package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.ExamService;
import com.emir.albayrak.ws.dataaccess.ExamRepository;
import com.emir.albayrak.ws.model.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManager implements ExamService {
    private ExamRepository rep;

    public ExamManager(ExamRepository rep) {
        this.rep = rep;
    }

    @Override
    public List<Exam> findAll() {
        return rep.findAll();
    }

    @Override
    public Exam save(Exam exam) {
        return rep.save(exam);
    }
}
