package com.lujieni.interceptor.controller;

import com.lujieni.interceptor.annotation.LoginRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther ljn
 * @Date 2020/2/13
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login")
    @LoginRequired
    public String login(){
        return "login";
    }




}
