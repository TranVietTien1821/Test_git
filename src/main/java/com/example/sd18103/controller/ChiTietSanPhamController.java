package com.example.sd18103.controller;

import com.example.sd18103.model.ChiTietSanPham;
import com.example.sd18103.repository.DongSanPhamResponstory;
import com.example.sd18103.repository.MauSacResponstory;
import com.example.sd18103.repository.NgaySanXuatResponstory;
import com.example.sd18103.repository.SanPhamResponstory;
import com.example.sd18103.service.impl.ChiTietSPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private SanPhamResponstory sanPhamService;

    @Autowired
    private MauSacResponstory mauSacService;

    @Autowired
    private NgaySanXuatResponstory nhaSanXuatService;

    @Autowired
    private DongSanPhamResponstory dongSanPhamService;

    @GetMapping("/hien-thi")
    public String getData(Model model) {
        //sap xep theo so luong tồn
        model.addAttribute("list", chiTietSPService.getAll());
        model.addAttribute("view", "chitietsp/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        model.addAttribute("ctsp", chiTietSanPham);
//        model.addAttribute("san-pham", sanPhamService.getAll());
        model.addAttribute("san-pham", "/views/san-pham.jsp");
        model.addAttribute("mau-sac", "/views/mau-sac.jsp");
        model.addAttribute("dong-sp", "/views/dong-sp.jsp");
        model.addAttribute("nxs", "/views/ngay-san-xuat.jsp");
        model.addAttribute("khach-hang", "/views/khach-hang.jsp");
        model.addAttribute("chuc-vu", "/views/chuc-vu.jsp");
        model.addAttribute("cua-hang", "/views/cua-hang.jsp");
        model.addAttribute("nhan-vien", "/views/nhan-vien.jsp");
        model.addAttribute("view", "chitietsp/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("san-pham", sanPhamService.getAll());
            model.addAttribute("mauSac", mauSacService.getAll());
            model.addAttribute("dongSP", dongSanPhamService.getAll());
            model.addAttribute("nsx", nhaSanXuatService.getAll());
            model.addAttribute("view", "chitietsp/add.jsp");
            return "layout";
        } else {
            chiTietSPService.saveOrUpdate(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        chiTietSPService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSPService.getById(id);
        model.addAttribute("ctsp", chiTietSanPham);
        model.addAttribute("san-pham", sanPhamService.getAll());
        model.addAttribute("mauSac", mauSacService.getAll());
        model.addAttribute("dongSP", dongSanPhamService.getAll());
        model.addAttribute("nsx", nhaSanXuatService.getAll());
        model.addAttribute("view", "chitietsp/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("san-pham", sanPhamService.getAll());
            model.addAttribute("mauSac", mauSacService.getAll());
            model.addAttribute("dongSP", dongSanPhamService.getAll());
            model.addAttribute("nsx", nhaSanXuatService.getAll());
            model.addAttribute("view", "chitietsp/add.jsp");
            return "layout";
        } else {
            chiTietSPService.saveOrUpdate(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/hien-thi";
        }
    }



}
