package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final UserService userService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public StudentController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<DataResult<Student>> saveStudent(@RequestBody Student student) {
        student = (Student) userService.save(student);
        customLog.info("Student is saved successfully");
        String msg = "Öğrenci başarılı bir şekilde kaydedildi.";
        DataResult<Student> dataResult = new SuccessDataResult<>(student, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Student>>> findAll() {
        List<Student> list = studentService.findAll();
        customLog.info("All students are retrieved");
        String msg = "Bütün öğrenciler başarılı bir şekilde getirildi.";
        DataResult<List<Student>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
