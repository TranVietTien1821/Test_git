package com.example.sd18103.controller;

import com.example.sd18103.model.ChucVu;
import com.example.sd18103.model.CuaHang;
import com.example.sd18103.repository.ChucVuResponstory;
import com.example.sd18103.repository.CuaHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/chuc-vu")
@Controller
public class ChucVuController {
    @Autowired
    private ChucVuResponstory chucVuResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<ChucVu> list = chucVuResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("chuc-vu", new ChucVu());//string form
        model.addAttribute("view", "chuc-vu.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("chuc-vu")ChucVu chucVu,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "chuc-vu";
        }
        if (chucVu.getId() != null) {

            ChucVu cuaHang1 = chucVuResponstory.findById(chucVu.getId()).orElse(null);
            cuaHang1.setMa(chucVu.getMa());
            cuaHang1.setTen(chucVu.getTen());

            chucVuResponstory.save(cuaHang1);

        } else {
            chucVuResponstory.save(chucVu);
        }
        return "redirect:/chuc-vu/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, ChucVu chucVu) {
        chucVuResponstory.delete(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        ChucVu chucVu = chucVuResponstory.findById(id).orElse(null);

        model.addAttribute("chuc-vu", chucVu);
        List<ChucVu> list = chucVuResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "chuc-vu.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }


}
