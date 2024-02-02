package com.example.sd18103.controller;

import com.example.sd18103.model.DongSanPham;
import com.example.sd18103.model.MauSac;
import com.example.sd18103.repository.DongSanPhamResponstory;
import com.example.sd18103.repository.MauSacResponstory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/mau-sac")
@Controller
public class MauSacController {
    @Autowired
    private MauSacResponstory mauSacResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<MauSac> list = mauSacResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("mau-sac", new MauSac());//string form
        model.addAttribute("view", "mau-sac.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("mau-sac")MauSac mauSac,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "mau-sac";
        }
        if (mauSac.getId() != null) {

            MauSac cuaHang1 = mauSacResponstory.findById(mauSac.getId()).orElse(null);
            cuaHang1.setMa(mauSac.getMa());
            cuaHang1.setTen(mauSac.getTen());

            mauSacResponstory.save(cuaHang1);

        } else {
            mauSacResponstory.save(mauSac);
        }
        return "redirect:/mau-sac/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, MauSac mauSac) {
        mauSacResponstory.delete(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        MauSac mauSac = mauSacResponstory.findById(id).orElse(null);

        model.addAttribute("mau-sac", mauSac);
        List<MauSac> list = mauSacResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "mau-sac.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }

}
