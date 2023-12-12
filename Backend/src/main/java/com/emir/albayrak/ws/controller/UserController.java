package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.UserService;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utility.CustomLog;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUserList() {

        return null;// ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<String> adduser(@RequestBody User user) {
//        userService.addUser(user);
        String msg = "User is added : " + user;
//        customLog.info(msg);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
