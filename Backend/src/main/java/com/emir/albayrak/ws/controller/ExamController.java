package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ExamService;
import com.emir.albayrak.ws.model.Announcement;
import com.emir.albayrak.ws.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/exams/")
public class ExamController {
    private ExamService service;

    @Autowired
    public ExamController(ExamService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Exam>>> findAll() {
        List<Exam> list = service.findAll();
        String msg;
        if (!list.isEmpty()) {
            msg = "Bütün sınavlar getirildi. ("+list.size()+" adet)";
        } else {
            msg = "Kayıtlı bir sınav bulunamadı";
        }
        DataResult<List<Exam>> dataResult = new SuccessDataResult<>(list, msg);
        list.forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping
    public ResponseEntity<DataResult<Exam>> save(@RequestBody Exam exam) {
        exam = service.save(exam);
        String msg = "Sınav kaydedildi.";
        DataResult<Exam> dataResult = new SuccessDataResult<>(exam, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
}
