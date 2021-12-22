package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
    @RequestMapping("testBoot")
    public String GetUser(){
        System.out.println("you have come in");
        return "index";
    }
}
