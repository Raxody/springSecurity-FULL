package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("hello")
    @PreAuthorize("permitAll()")
    public String hello(){
        return "hello world not secured";
    }

    @GetMapping("hello-secured")
    @PreAuthorize("hasAuthority('READ')")
    public String helloSecured(){
        return "hello world Secured";
    }

    @GetMapping("hello-secured2")
    public String helloSecured2(){
        return "hello world Secured2";
    }

}