package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.LoginCredentials;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CustomLog customLog = new CustomLog(getClass());
    private final LoginService loginService;


    @Autowired
    public UserController(UserService userService,
                          LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/login/")
    public ResponseEntity<DataResult<User>> login(@RequestBody LoginCredentials loginCredentials) {
        DataResult<User> dataResult = loginService.findUserByLoginCredentials(loginCredentials);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

    @GetMapping("/all")
    public ResponseEntity<DataResult<List<User>>> getUserList() {
        List<User> userList = userService.findAll();
        String msg = "user list is retrieved successfully";
        DataResult<List<User>> dataResult = new SuccessDataResult<>(userList, msg);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);// ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

 /*   @PostMapping
    public ResponseEntity<String> adduser(@RequestBody User user) {
//        userService.addUser(user);
        String msg = "User is added : " + user;
//        customLog.info(msg);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }*/
}
