package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final UserService userService;
    private final TeacherService teacherService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public TeacherController(UserService userService, TeacherService teacherService) {
        this.userService = userService;
        this.teacherService = teacherService;
    }

    @PostMapping()
    public ResponseEntity<DataResult<Teacher>> saveTeacher(@RequestBody Teacher teacher) {
        teacher = (Teacher) userService.save(teacher);
        customLog.info("Teacher is saved successfully in " + getClass().getSimpleName());
        String msg = "Öğretmen başarılı bir şekilde kaydedildi.";
        DataResult<Teacher> dataResult = new SuccessDataResult<>(teacher, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping()
    public ResponseEntity<DataResult<List<Teacher>>> findAll() {
        List<Teacher> list = teacherService.findAll();
        customLog.info("All students are retrieved");
        String msg = "Bütün öğretmenler başarılı bir şekilde getirildi.";
        DataResult<List<Teacher>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
}
