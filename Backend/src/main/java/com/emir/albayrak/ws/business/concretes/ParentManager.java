package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.ParentService;
import com.emir.albayrak.ws.dataaccess.ParentRepository;
import com.emir.albayrak.ws.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentManager implements ParentService {
    private ParentRepository parentRepository;

    @Autowired
    public ParentManager(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent find(int studentId) {
        return parentRepository.findByStudentId(studentId);
    }
}
