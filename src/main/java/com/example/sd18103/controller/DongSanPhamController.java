package com.example.sd18103.controller;


import com.example.sd18103.model.DongSanPham;

import com.example.sd18103.repository.DongSanPhamResponstory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/dong-sp")
@Controller
public class DongSanPhamController {
    @Autowired
    private DongSanPhamResponstory dongSanPhamResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<DongSanPham> list = dongSanPhamResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("dong-sp", new DongSanPham());//string form
        model.addAttribute("view", "dong-sp.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dong-sp")DongSanPham dongSanPham,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "dong-sp";
        }
        if (dongSanPham.getId() != null) {

            DongSanPham cuaHang1 = dongSanPhamResponstory.findById(dongSanPham.getId()).orElse(null);
            cuaHang1.setMa(dongSanPham.getMa());
            cuaHang1.setTen(dongSanPham.getTen());

            dongSanPhamResponstory.save(cuaHang1);

        } else {
            dongSanPhamResponstory.save(dongSanPham);
        }
        return "redirect:/dong-sp/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, DongSanPham dongSanPham) {
        dongSanPhamResponstory.delete(dongSanPham);
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        DongSanPham dongSanPham = dongSanPhamResponstory.findById(id).orElse(null);

        model.addAttribute("dong-sp", dongSanPham);
        List<DongSanPham> list = dongSanPhamResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "dong-sp.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }

}
