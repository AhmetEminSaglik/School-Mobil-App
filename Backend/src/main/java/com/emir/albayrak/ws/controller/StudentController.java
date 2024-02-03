package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.LoginCredentials;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.exception.InvalidStudentNoException;
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
        Student registredStudent = studentService.findByNo(student.getNo());

        if (registredStudent != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDataResult<>(null, InvalidStudentNoException.customErrorMsg));
        }
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
        customLog.info("Student is deleted successfully.");
        String msg = dataResult.getMessage();
        dataResult = new SuccessDataResult<>(dataResult.getData(), msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("no/{no}/")
    public ResponseEntity<DataResult<Student>> searchStudentByNo(@PathVariable String no) {
        Student student = studentService.findByNo(no);
        DataResult<Student> dataResult;
        String msg;
        if (student != null) {
            msg = no + " numaralı öğrenci getirildi.";
            dataResult = new SuccessDataResult<>(student, msg);
        } else {
            msg = no + " numaralı öğrenci bulunamadı.";
            dataResult = new ErrorDataResult<>(null, msg);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }


    @GetMapping("name/{name}/")
    public ResponseEntity<DataResult<List<Student>>> searchStudentByName(@PathVariable String name) {
        List<Student> list = studentService.searchByName(name);
        DataResult<List<Student>> dataResult;
        String msg;
        if (!list.isEmpty()) {
            msg = name + " ismindeki öğrenciler getirildi.";
            dataResult = new SuccessDataResult<>(list, msg);
        } else {
            msg = name + " isminde öğrenci bulunamadı.";
            dataResult = new ErrorDataResult<>(list, msg);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("lastname/{lastname}/")
    public ResponseEntity<DataResult<List<Student>>> searchStudentByLastname(@PathVariable String lastname) {
        List<Student> list = studentService.searchByLastName(lastname);
        DataResult<List<Student>> dataResult;
        String msg;
        if (!list.isEmpty()) {
            msg = lastname + " soyadındaki öğrenciler getirildi.";
            dataResult = new SuccessDataResult<>(list, msg);
        } else {
            msg = lastname + " soyadındaki öğrenci bulunamadı.";
            dataResult = new SuccessDataResult<>(null, msg);
        }
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

        userService.save(oldStudent);
        String msg = "Öğrenci güncellendi.";
        DataResult<User> dataResult = new SuccessDataResult<>(oldStudent, msg);

        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Student>>> findAll() {
        List<Student> list = studentService.findAll();
        customLog.info("All students are retrieved.");
        String msg = "Bütün öğrenciler başarılı bir şekilde getirildi.";
        DataResult<List<Student>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Student>> findById(@PathVariable int id) {
        Student student = studentService.findById(id);
        DataResult<Student> dataResult;
        String msg;
        if (student != null) {
            msg = id + " numaralı öğrenci getirildi.";//"Student with " + id + " id is retrieved.";
            dataResult = new SuccessDataResult<>(student, msg);
        } else {
            msg = id + " numaralı öğrenci bulunamadı.";
            dataResult = new ErrorDataResult<>(student, msg);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
