package com.example.sd18103.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hienthi")
@Controller
public class hienthicontroller {
    @GetMapping("/hienthi")
    public String hienthi(){
        return "layout";
    }
}
