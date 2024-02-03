package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ExamService;
import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.TeacherService;
import com.emir.albayrak.ws.model.Exam;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.ErrorDataResult;
import utility.result.SuccessDataResult;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/exams/")
public class ExamController {
    private ExamService service;
    private CustomLog customLog = new CustomLog(getClass());

    private TeacherService teacherService;
    private StudentService studentService;

    public ExamController(ExamService service, TeacherService teacherService, StudentService studentService) {
        this.service = service;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @Autowired

    @GetMapping
    public ResponseEntity<DataResult<List<Exam>>> findAll() {
        List<Exam> list = service.findAll();
        String msg;
        if (!list.isEmpty()) {
            msg = "Bütün sınavlar getirildi. (" + list.size() + " adet)";
        } else {
            msg = "Kayıtlı bir sınav bulunamadı";
        }
        DataResult<List<Exam>> dataResult = new SuccessDataResult<>(list, msg);
        list.forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping
    public ResponseEntity<DataResult<Exam>> save(@RequestBody Exam exam) {
        Teacher teacher = teacherService.findById(exam.getTeacher().getId());
        Student student = studentService.findById(exam.getStudent().getId());
        DataResult<Exam> dataResult;
        if (teacher == null || student == null) {
            String msg = "Hatalı öğretmen veya öğrenci verisi girildi.";
            exam.setTeacher(teacher);
            exam.setStudent(student);
            dataResult = new ErrorDataResult<>(exam, msg);
            return ResponseEntity.status(HttpStatus.OK).body(dataResult);
        }
        exam.setCourseName(teacher.getBranch());
        exam.setTeacher(teacher);
        exam.setStudent(student);
        customLog.info("exam : " + exam);
        try {
            exam = service.save(exam);

        } catch (Exception ex) {
            dataResult = new ErrorDataResult<>(null, "Öğretmen öğrenciye daha önce not girmiş lütfen güncelleme işlemini gerçekleştirin.");
            return ResponseEntity.status(HttpStatus.OK).body(dataResult);
        }

        String msg = "Sınav kaydedildi.";
        dataResult = new SuccessDataResult<>(exam, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PutMapping
    public ResponseEntity<DataResult<Exam>> update(@RequestBody Exam exam) {
        DataResult<Exam> dataResult = service.update(exam);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
}
