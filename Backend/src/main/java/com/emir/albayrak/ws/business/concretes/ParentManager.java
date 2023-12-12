package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.dataaccess.ParentRepository;
import com.emir.albayrak.ws.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentManager implements ParentService {
    private final ParentRepository parentRepository;
    private final StudentService studentService;

    @Autowired
    public ParentManager(ParentRepository parentRepository,
                         StudentService studentService) {
        this.parentRepository = parentRepository;
        this.studentService = studentService;
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent findByStudentId(int studentId) {
        return studentService.findParent(studentId);
    }
}
