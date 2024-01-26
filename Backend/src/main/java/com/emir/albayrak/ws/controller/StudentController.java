package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.LoginCredentials;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import com.emir.albayrak.ws.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.ErrorDataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/students/")
public class StudentController {
    private final StudentService studentService;
    private final UserService userService;
    private CustomLog customLog = new CustomLog(getClass());
    private final LoginService loginService;

    @Autowired
    public StudentController(UserService userService, StudentService studentService, LoginService loginService) {
        this.userService = userService;
        this.studentService = studentService;
        this.loginService = loginService;
    }

    @PostMapping("login/")
    public ResponseEntity<DataResult<User>> login(@RequestBody LoginCredentials loginCredentials) {
        DataResult<User> dataResult = loginService.findUserByLoginCredentials(loginCredentials);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }


    @PostMapping()
    public ResponseEntity<DataResult<User>> saveStudent(@RequestBody Student student) {
        student.setRoleIdToUser();
        DataResult<User> dataResult = userService.save(student);
        if (!dataResult.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDataResult<>(null, dataResult.getMessage()));
        }
        customLog.info("Student is saved successfully");
        String msg = "Öğrenci başarılı bir şekilde kaydedildi.";
        dataResult = new SuccessDataResult<>(student, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @DeleteMapping("{no}/")
    public ResponseEntity<DataResult<Student>> deleteStudent(@PathVariable String no) {
        DataResult<Student> dataResult = studentService.deleteStudent(no);
        if (!dataResult.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDataResult<>(null, dataResult.getMessage()));
        }
        customLog.info("Student is deleted successfully");
        String msg = dataResult.getMessage();
        dataResult = new SuccessDataResult<>(dataResult.getData(), msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }


    @GetMapping("name/{name}/")
    public ResponseEntity<DataResult<List<Student>>> searchStudentByName(@PathVariable String name) {
        List<Student> list = studentService.searchByName(name);
        String msg;
        if (!list.isEmpty()) {
            msg = name + " ismindeki öğrenciler getirildi.";
        } else {
            msg = name + " isminde öğrenci bulunamadı.";
        }
        DataResult<List<Student>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

  
    @PutMapping
    public ResponseEntity<DataResult<User>> updateStudent(@RequestBody Student newStudent) {
        Student oldStudent = studentService.findById(newStudent.getId());

        oldStudent.setNo(newStudent.getNo());
        oldStudent.setUsername(newStudent.getUsername());
        oldStudent.setPassword(newStudent.getPassword());
        oldStudent.setName(newStudent.getName());
        oldStudent.setLastname(newStudent.getLastname());
        oldStudent.setParentId(newStudent.getParentId());

        userService.save(oldStudent);
        String msg = "Öğrenci güncellendi.";
        DataResult<User> dataResult = new SuccessDataResult<>(oldStudent, msg);

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

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Student>> findById(@PathVariable int id) {
        Student student = studentService.findById(id);
        String msg;
        if (student != null) {
            msg = "Student with " + id + " id is retrieved.";
        } else {
            msg = "Student with request id is not found";
        }
        DataResult<Student> dataResult = new SuccessDataResult<>(student, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
