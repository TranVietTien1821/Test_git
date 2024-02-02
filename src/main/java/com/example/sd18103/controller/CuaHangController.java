package com.example.sd18103.controller;

import com.example.sd18103.model.CuaHang;
import com.example.sd18103.repository.CuaHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping("/cua-hang")
@Controller
public class CuaHangController {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<CuaHang> list = cuaHangRepository.getAll();
        model.addAttribute("list", list);
        model.addAttribute("cua-hang", new CuaHang());//string form
        model.addAttribute("view", "cua-hang.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("cua-hang") CuaHang cuaHang,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "cua-hang";
        }
        if (cuaHang.getId() != null) {

            CuaHang cuaHang1 = cuaHangRepository.findById(cuaHang.getId()).orElse(null);
            cuaHang1.setMa(cuaHang.getMa());
            cuaHang1.setTen(cuaHang.getTen());
            cuaHang1.setDiaChi(cuaHang.getDiaChi());
            cuaHang1.setThanhPho(cuaHang.getThanhPho());
            cuaHang1.setQuocGia(cuaHang.getQuocGia());
            cuaHangRepository.save(cuaHang1);

        } else {
            cuaHangRepository.save(cuaHang);
        }
        return "redirect:/cua-hang/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, CuaHang cuaHang) {
        cuaHangRepository.delete(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        CuaHang cuaHang = cuaHangRepository.findById(id).orElse(null);

        model.addAttribute("cua-hang", cuaHang);
        List<CuaHang> list = cuaHangRepository.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "cua-hang.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }





}
