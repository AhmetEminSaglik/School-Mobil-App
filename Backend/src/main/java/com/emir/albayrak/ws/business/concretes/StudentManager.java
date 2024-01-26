package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.searchuser.SearchStudentByProperties;
import com.emir.albayrak.ws.dataaccess.ParentRepository;
import com.emir.albayrak.ws.dataaccess.StudentRepository;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@Service
public class StudentManager implements StudentService, SearchStudentByProperties {

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
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public DataResult<Student> deleteStudent(String no) {
        Student student = studentRepository.findByNo(no);
        if (student != null) {
            studentRepository.delete(student);
            return new SuccessDataResult<>("Öğrenci başarılı bir şekilde silindi.");
        }
        return new SuccessDataResult<>("Öğrenci numarası zaten kayıtlı değil. ");
    }

    @Override
    public Student searchStudentByNo(String no) {
        return null;
    }

    @Override
    public List<Student> searchByName(String name) {
        return null;
    }

    @Override
    public List<Student> searchByLastName(String name) {
        return null;
    }
}
