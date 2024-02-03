package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.AnnouncementService;
import com.emir.albayrak.ws.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.result.DataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@RestController
@RequestMapping("/announcement/")
public class AnnouncementController {
    private AnnouncementService service;

    @Autowired
    public AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Announcement>>> findAll() {
        List<Announcement> list = service.findAll();
        String msg;
        if (!list.isEmpty()) {
            msg = "Bütün duyurular getirildi";
        } else {
            msg = "Kayıtlı bir duyuru bulunamadı";
        }
        DataResult<List<Announcement>> dataResult = new SuccessDataResult(list, msg);
        System.out.println("DataResult " +dataResult);
        System.out.println("list  size :"+list.size());
        list.forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @PostMapping
    public ResponseEntity<DataResult<Announcement>> save(@RequestBody Announcement announcement) {
        announcement = service.save(announcement);
        DataResult<Announcement> dataResult = new SuccessDataResult<>(announcement);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }
}
