package com.brillio.onlineticket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/abc")
    public String index(){
        return "hello world!!";
    }
}
