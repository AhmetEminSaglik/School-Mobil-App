package com.emir.albayrak.ws.controller;

import com.emir.albayrak.ws.business.abstracts.model.ParentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utility.CustomLog;

@RestController
@RequestMapping("/headmasters")
public class HeadmasterController {
    private final UserService userService;
    private final ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());

    @Autowired
    public HeadmasterController(UserService userService, ParentService parentService) {
        this.userService = userService;
        this.parentService = parentService;
    }




}
