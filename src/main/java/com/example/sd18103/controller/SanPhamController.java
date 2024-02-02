//package com.example.sd18103.controller;
//
//import com.example.sd18103.model.NgaySanXuat;
//import com.example.sd18103.model.SanPham;
//import com.example.sd18103.repository.NgaySanXuatResponstory;
//import com.example.sd18103.repository.SanPhamResponstory;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.UUID;
//
//@RequestMapping("/san-pham")
//@Controller
//public class SanPhamController {
//    @Autowired
//    private SanPhamResponstory sanPhamResponstory;
//
//    @GetMapping("/hien-thi")
//    public String hienThi(Model model) {
//        List<SanPham> list = sanPhamResponstory.getAll();
//        model.addAttribute("list", list);
//        model.addAttribute("san-pham", new SanPham());//string form
//        return "san-pham";
//    }
//
//
//    @PostMapping("/add")
//    public String add(@Valid @ModelAttribute("san-pham")SanPham sanPham,
//                      BindingResult bindingResult,
//                      Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("error", bindingResult.getFieldErrors());
//            return "san-pham";
//        }
//        if (sanPham.getId() != null) {
//
//            SanPham cuaHang1 = sanPhamResponstory.findById(sanPham.getId()).orElse(null);
//            cuaHang1.setMa(sanPham.getMa());
//            cuaHang1.setTen(sanPham.getTen());
//
//            sanPhamResponstory.save(cuaHang1);
//
//        } else {
//            sanPhamResponstory.save(sanPham);
//        }
//        return "redirect:/san-pham/hien-thi";
//    }
//
//
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable UUID id, SanPham sanPham) {
//        sanPhamResponstory.delete(sanPham);
//        return "redirect:/san-pham/hien-thi";
//    }
//
//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable UUID id, Model model) {
//        SanPham sanPham = sanPhamResponstory.findById(id).orElse(null);
//
//        model.addAttribute("san-pham", sanPham);
//        List<SanPham> list = sanPhamResponstory.getAll();
//        model.addAttribute("list", list);
//        return "san-pham"; // Hiển thị form sửa dữ liệu
//    }
//}
package com.example.sd18103.controller;

import com.example.sd18103.model.SanPham;
import com.example.sd18103.repository.SanPhamResponstory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamResponstory sanPhamResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<SanPham> list = sanPhamResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("san-pham", new SanPham());
        model.addAttribute("view", "san-pham.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("san-pham")SanPham sanPham,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "san-pham";
        }
        if (sanPham.getId() != null) {

            SanPham cuaHang1 = sanPhamResponstory.findById(sanPham.getId()).orElse(null);
            cuaHang1.setMa(sanPham.getMa());
            cuaHang1.setTen(sanPham.getTen());

            sanPhamResponstory.save(cuaHang1);

        } else {
            sanPhamResponstory.save(sanPham);
        }
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, SanPham sanPham) {
        sanPhamResponstory.delete(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        SanPham sanPham = sanPhamResponstory.findById(id).orElse(null);

        model.addAttribute("san-pham", sanPham);
        model.addAttribute("view", "san-pham.jsp");
        List<SanPham> list = sanPhamResponstory.getAll();
        model.addAttribute("list", list);
        return "layout"; // Hiển thị form sửa dữ liệu
    }



}