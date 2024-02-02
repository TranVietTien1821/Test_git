package com.example.sd18103.controller;

import com.example.sd18103.model.ChucVu;
import com.example.sd18103.model.KhachHang;
import com.example.sd18103.model.NhanVien;
import com.example.sd18103.model.SanPham;
import com.example.sd18103.repository.ChucVuResponstory;
import com.example.sd18103.repository.CuaHangRepository;
import com.example.sd18103.repository.NhanVienResponstory;
import com.example.sd18103.repository.SanPhamResponstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/nhan-vien")
@Controller
public class NhanVienController {
    @Autowired
    private NhanVienResponstory nhanVienResponstory;
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Autowired
    private ChucVuResponstory chucVuResponstory;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {

        List<NhanVien> list = nhanVienResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("nhan-vien", new NhanVien());//string form
        model.addAttribute("listCh", cuaHangRepository.getAll());
        model.addAttribute("listCv", chucVuResponstory.getAll());
        model.addAttribute("view", "nhanvien.jsp");

        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, NhanVien nhanVien) {
        nhanVienResponstory.delete(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        NhanVien nhanVien = nhanVienResponstory.findById(id).orElse(null);
        model.addAttribute("nhan-vien", nhanVien);
        List<NhanVien> list = nhanVienResponstory.getAll();
        model.addAttribute("list", list);
        model.addAttribute("listCh", cuaHangRepository.getAll());
        model.addAttribute("listCv", chucVuResponstory.getAll());
        model.addAttribute("view", "nhanvien.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(NhanVien nhanVien, Model model) {
        if (nhanVien.getId() != null) {

            NhanVien cuaHang1 = nhanVienResponstory.findById(nhanVien.getId()).orElse(null);
            cuaHang1.setMa(nhanVien.getMa());
            cuaHang1.setTen(nhanVien.getTen());
            cuaHang1.setGioiTinh(nhanVien.getGioiTinh());
            cuaHang1.setCuaHang(nhanVien.getCuaHang());
            cuaHang1.setChucVu(nhanVien.getChucVu());

            nhanVienResponstory.save(cuaHang1);

        } else {
            try {
                nhanVienResponstory.save(nhanVien);
            } catch (Exception exception) {
                List<NhanVien> list = nhanVienResponstory.findAll();
                exception.printStackTrace();
                model.addAttribute("list", list);
                model.addAttribute("nhan-vien", new NhanVien());
                model.addAttribute("listCh", cuaHangRepository.getAll());
                model.addAttribute("listCv", chucVuResponstory.getAll());
                return "nhanvien";
            }

        }
        return "redirect:/nhan-vien/hien-thi";
    }
}
