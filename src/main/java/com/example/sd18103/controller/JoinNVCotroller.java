package com.example.sd18103.controller;

import com.example.sd18103.model.JoinNV;
import com.example.sd18103.repository.JoinNVResponstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/nv")
@Controller
public class JoinNVCotroller {
    @Autowired
    JoinNVResponstory joinNVResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<JoinNV> list = joinNVResponstory.getAll();
        model.addAttribute("list", list);
//        model.addAttribute("cua-hang", new CuaHang());//string form
        return "nhanvien";
    }

//    @GetMapping()
//    public String hienThi(Model model) {
//        List<JoinNV> list = joinNVResponstory.getAll();
//        list.forEach(x -> System.out.println(x.toString()));
//        return null;
//    }

}
