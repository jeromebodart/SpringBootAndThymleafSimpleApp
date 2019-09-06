package com.example.applidusiecle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/user")
    public String showUserMsg()
    {
        System.out.println("Connected!!!!!!");
        return "User has logged in!!!";

    }

    @RequestMapping("/admin")
    public String showAdminMsg()
    {
        return "Admin has logged in!!!";
    }
}
