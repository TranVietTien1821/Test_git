package com.example.sd18103.controller;

import com.example.sd18103.model.NgaySanXuat;
import com.example.sd18103.repository.NgaySanXuatResponstory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/nxs")
@Controller
public class NgaySanXuatController {
    @Autowired
    private NgaySanXuatResponstory ngaySanXuatResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<NgaySanXuat> list = ngaySanXuatResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("nxs", new NgaySanXuat());//string form
        model.addAttribute("view", "ngay-san-xuat.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("nxs")NgaySanXuat ngaySanXuat,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "ngay-san-xuat";
        }
        if (ngaySanXuat.getId() != null) {

            NgaySanXuat cuaHang1 = ngaySanXuatResponstory.findById(ngaySanXuat.getId()).orElse(null);
            cuaHang1.setMa(ngaySanXuat.getMa());
            cuaHang1.setTen(ngaySanXuat.getTen());

            ngaySanXuatResponstory.save(cuaHang1);

        } else {
            ngaySanXuatResponstory.save(ngaySanXuat);
        }
        return "redirect:/nxs/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, NgaySanXuat ngaySanXuat) {
        ngaySanXuatResponstory.delete(ngaySanXuat);
        return "redirect:/nxs/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        NgaySanXuat ngaySanXuat = ngaySanXuatResponstory.findById(id).orElse(null);

        model.addAttribute("nxs", ngaySanXuat);
        List<NgaySanXuat> list = ngaySanXuatResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "ngay-san-xuat.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }

}
