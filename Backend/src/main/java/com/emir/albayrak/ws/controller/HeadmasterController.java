package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.LoginCredentials;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utility.CustomLog;
import utility.result.DataResult;

@RestController
@RequestMapping("/headmasters/")
public class HeadmasterController {
    private final UserService userService;
    private final ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());
    private final LoginService loginService;

    @Autowired
    public HeadmasterController(UserService userService, ParentService parentService, LoginService loginService) {
        this.userService = userService;
        this.parentService = parentService;
        this.loginService = loginService;
    }

    @PostMapping("login/")
    public ResponseEntity<DataResult<User>> login(@RequestBody LoginCredentials loginCredentials) {
        DataResult<User> dataResult = loginService.findUserByLoginCredentials(loginCredentials);
        return ResponseEntity.status(HttpStatus.OK).body(dataResult);
    }

}
