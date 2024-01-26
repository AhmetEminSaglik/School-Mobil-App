package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.dataaccess.TeacherRepository;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@Service
public class TeacherManager implements TeacherService/*, SearchTeacherByProperties*/ {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherManager(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public DataResult<Teacher> deleteTeacher(int no) {
        Teacher teacher = teacherRepository.findById(no);
        if (teacher != null) {
            teacherRepository.delete(teacher);
            return new SuccessDataResult<>("Öğretmen başarılı bir şekilde silindi.");
        }
        return new SuccessDataResult<>("Öğretmen zaten kayıtlı değil.");
    }

    @Override
    public List<Teacher> searchByName(String name) {
        return teacherRepository.findAllByName(name);
    }

    @Override
    public List<Teacher> searchByLastName(String lastName) {
        return teacherRepository.findAllByLastname(lastName);
    }
}
