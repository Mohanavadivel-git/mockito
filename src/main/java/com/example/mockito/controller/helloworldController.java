package com.example.mockito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {

    @RequestMapping(value = "/v1/helloworld", method = RequestMethod.GET)
    public String helloworld(){
        return "helloworldcontroller";
    }
}
