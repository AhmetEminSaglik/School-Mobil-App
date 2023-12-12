package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.dataaccess.TeacherRepository;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherManager implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherManager(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
