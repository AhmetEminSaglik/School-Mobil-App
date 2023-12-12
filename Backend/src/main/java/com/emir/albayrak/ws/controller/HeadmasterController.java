package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

@RestController
@RequestMapping("/headmasters")
public class HeadmasterController {
    private final UserService userService;
    private final ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public HeadmasterController(UserService userService, ParentService parentService) {
        this.userService = userService;
        this.parentService = parentService;
    }


    @PostMapping("/save/teacher")

    public ResponseEntity<DataResult<Teacher>> saveTeacher(@RequestBody Teacher teacher) {
        teacher = (Teacher) userService.save(teacher);
        customLog.info("Teacher is saved successfully in " + getClass().getSimpleName());
        String msg = "Öğretmen başarılı bir şekilde kaydedildi.";
        DataResult<Teacher> dataResult = new SuccessDataResult<>(teacher, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping("/save/student")
    public ResponseEntity<DataResult<Student>> saveStudent(@RequestBody Student student) {
        student = (Student) userService.save(student);
        customLog.info("Teacher is saved successfully in " + getClass().getSimpleName());
        String msg = "Öğrenci başarılı bir şekilde kaydedildi.";
        DataResult<Student> dataResult = new SuccessDataResult<>(student, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping("/save/parent")
    public ResponseEntity<DataResult<Parent>> saveParent(@RequestBody Parent parent) {
        parent = parentService.save(parent);
        customLog.info("Teacher is saved successfully in " + getClass().getSimpleName());
        String msg = "Öğrenci velisi başarılı bir şekilde kaydedildi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
