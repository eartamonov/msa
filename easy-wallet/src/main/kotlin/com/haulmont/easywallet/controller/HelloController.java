package com.haulmont.easywallet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @ResponseBody
    public String hello() {
        return "Hello!!!";
    }
}
