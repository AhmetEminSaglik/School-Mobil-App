package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.HeadmasterService;
import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.dataaccess.UserRepository;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

//public class HeadmasterManager implements HeadmasterService {

//    private final UserRepository userRepository;
//
//    @Autowired
//    public HeadmasterManager(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Teacher saveTeacher(Teacher teacher) {
//        return userRepository.save(teacher);
//    }
//
//    @Override
//    public Student saveStudent(Student student) {
//        return userRepository.save(student);
//    }
//}
