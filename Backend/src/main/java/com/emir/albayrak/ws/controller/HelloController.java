package com.emir.albayrak.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @GetMapping()
    public String helloWord() {
        return "Welcom to Spring  boot App";
    }
    @GetMapping("2")
    public String helloWord2() {
        return "Welcome to 22222 ";
    }
}
