package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.LoginCredentials;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.exception.InvalidSignupUsernameException;
import utility.result.DataResult;
import utility.result.ErrorDataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/teachers/")
public class TeacherController {
    private final UserService userService;
    private final TeacherService teacherService;
    private CustomLog customLog = new CustomLog(getClass());
    private final LoginService loginService;

    @Autowired
    public TeacherController(UserService userService, TeacherService teacherService, LoginService loginService) {
        this.userService = userService;
        this.teacherService = teacherService;
        this.loginService = loginService;
    }

    @PostMapping("login/")

    public ResponseEntity<DataResult<User>> login(@RequestBody LoginCredentials loginCredentials) {
        DataResult<User> dataResult = loginService.findUserByLoginCredentials(loginCredentials);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }


    @PostMapping()
    public ResponseEntity<DataResult<User>> saveTeacher(@RequestBody Teacher teacher) {
        DataResult<User> dataResult = userService.save(teacher);
        if (!dataResult.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDataResult<>(null, dataResult.getMessage()));
        }
        customLog.info("Teacher is saved successfully in " + getClass().getSimpleName());
        String msg = "Öğretmen başarılı bir şekilde kaydedildi.";
        dataResult = new SuccessDataResult<>(teacher, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PutMapping
    public ResponseEntity<DataResult<User>> updateTeacher(@RequestBody Teacher newTeacher) {
        Teacher oldTeacher = teacherService.findById(newTeacher.getId());
        oldTeacher.setUsername(newTeacher.getUsername());
        oldTeacher.setPassword(newTeacher.getPassword());
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setLastname(newTeacher.getLastname());
        oldTeacher.setBranch(newTeacher.getBranch());
        oldTeacher.setGraduatedUniversity(newTeacher.getGraduatedUniversity());


        userService.save(newTeacher);
        String msg = "Öğretmen güncellendi.";
        DataResult<User> dataResult = new SuccessDataResult<>(newTeacher, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<DataResult<Teacher>> deleteTeacher(@PathVariable int id) {
        DataResult<Teacher> dataResult = teacherService.deleteTeacher(id);
        if (!dataResult.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDataResult<>(null, dataResult.getMessage()));
        }
        customLog.info("Teacher is deleted successfully");
        String msg = dataResult.getMessage();
        dataResult = new SuccessDataResult<>(dataResult.getData(), msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping()
    public ResponseEntity<DataResult<List<Teacher>>> findAll() {
        List<Teacher> list = teacherService.findAll();
        customLog.info("All teachers are retrieved");
        String msg = "Bütün öğretmenler başarılı bir şekilde getirildi.";
        DataResult<List<Teacher>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
}
