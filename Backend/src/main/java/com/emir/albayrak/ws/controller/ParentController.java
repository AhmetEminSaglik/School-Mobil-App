package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping()
    public ResponseEntity<DataResult<Parent>> saveParent(@RequestBody Parent parent) {
        parent = parentService.save(parent);
        customLog.info("Parent of student is saved successfully.");
        String msg = "Öğrenci velisi başarılı bir şekilde kaydedildi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<DataResult<Parent>> findParent(@PathVariable int studentId) {
        Parent parent = parentService.findByStudentId(studentId);
        customLog.info("Parent of student is found successfully : " + parent);
        String msg = "Öğrenci velisi başarılı bir şekilde kaydedildi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
