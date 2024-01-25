package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/parents/")
public class ParentController {
    private final ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Parent>>> getAll(){
        List<Parent> list = parentService.findAll();
        customLog.info("All students are retrieved");
        String msg = "Bütün veliler başarılı bir şekilde getirildi.";
        DataResult<List<Parent>> dataResult = new SuccessDataResult<>(list, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping()
    public ResponseEntity<DataResult<Parent>> saveParent(@RequestBody Parent parent) {
        parent = parentService.save(parent);
        customLog.info("Parent of student is saved successfully.");
        String msg = "Öğrenci velisi başarılı bir şekilde kaydedildi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
    @PutMapping
    public ResponseEntity<DataResult<Parent>> updateParent(@RequestBody Parent parent) {
        parentService.save(parent);
        String msg = "Öğrenci güncellendi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("/{parentId}/")
    public ResponseEntity<DataResult<Parent>> findParent(@PathVariable int parentId) {
        Parent parent = parentService.findById(parentId);
        customLog.info("Parent of student is found successfully : " + parent);
        String msg = "Öğrenci velisi başarılı bir şekilde getirildi.";
        DataResult<Parent> dataResult = new SuccessDataResult<>(parent, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
