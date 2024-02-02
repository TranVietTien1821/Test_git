package com.example.sd18103.controller;

import com.example.sd18103.model.CuaHang;
import com.example.sd18103.model.KhachHang;
import com.example.sd18103.repository.CuaHangRepository;
import com.example.sd18103.repository.KhachHangRespostory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/khach-hang")
@Controller
public class KhachHangCotroller {
    @Autowired
    private KhachHangRespostory khachHangRespostory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<KhachHang> list = khachHangRespostory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("khach-hang", new KhachHang());//string form
        model.addAttribute("view", "khach-hang.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("khach-hang") KhachHang khachHang,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "khach-hang";
        }
        if (khachHang.getId() != null) {

            KhachHang cuaHang1 = khachHangRespostory.findById(khachHang.getId()).orElse(null);
            cuaHang1.setMa(khachHang.getMa());
            cuaHang1.setTen(khachHang.getTen());
            cuaHang1.setTenDem(khachHang.getTenDem());
            cuaHang1.setHo(khachHang.getHo());
            cuaHang1.setNgaySinh(khachHang.getNgaySinh());
            cuaHang1.setSdt(khachHang.getSdt());
            cuaHang1.setDiaChi(khachHang.getDiaChi());
            cuaHang1.setThanhPho(khachHang.getThanhPho());
            cuaHang1.setQuocGia(khachHang.getQuocGia());
            cuaHang1.setMatKhau(khachHang.getMatKhau());

            khachHangRespostory.save(cuaHang1);

        } else {
            khachHangRespostory.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, KhachHang khachHang) {
        khachHangRespostory.delete(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
       KhachHang khachHang = khachHangRespostory.findById(id).orElse(null);

        model.addAttribute("khach-hang", khachHang);
        List<KhachHang>list = khachHangRespostory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("view", "khach-hang.jsp");
        return "layout"; // Hiển thị form sửa dữ liệu
    }

}
