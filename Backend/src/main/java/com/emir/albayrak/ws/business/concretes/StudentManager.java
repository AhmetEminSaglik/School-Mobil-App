package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.dataaccess.ParentRepository;
import com.emir.albayrak.ws.dataaccess.StudentRepository;
import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;


    @Autowired
    public StudentManager(StudentRepository studentRepository, ParentRepository parentRepository) {
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Parent findParent(int parentId) {
        return parentRepository.findById(parentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
