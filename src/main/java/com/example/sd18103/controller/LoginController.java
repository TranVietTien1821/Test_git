package com.example.sd18103.controller;


import com.example.sd18103.model.NhanVien;
import com.example.sd18103.repository.NhanVienResponstory;
import com.example.sd18103.service.impl.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private HttpServletRequest request;



    @GetMapping("/nhan-vien")
    public String loginNhanVien(Model model){
        model.addAttribute("action","/login/dang-nhap-nhan-vien");
        model.addAttribute("tieuDe","Quản lý nhân viên");
        return "login";
    }

    @PostMapping("/dang-nhap-nhan-vien")
    public String dangNhapNhanVien(@RequestParam("ten")String ten,@RequestParam("matKhau") String matKhau, Model model){
        NhanVien nv = nhanVienService.loginNhanVien(ten, matKhau);
        HttpSession session = request.getSession();
            if (ten.isEmpty() || matKhau.isEmpty()){
                model.addAttribute("mes","Không được bỏ trống");
                session.setAttribute("error","Không được bỏ trống");
                return "login";
            }else if (nv==null){
                session.setAttribute("error","Sai tên hoặc mk");
                model.addAttribute("tieuDe","Quản lý nhân viên");
                return "login";
            }
        session.setAttribute("nhanVien",nv);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

//    @PostMapping("/dang-nhap-nhan-vien")
//    public String dangNhapNhanVien(@RequestParam("maNhanVien") String maNhanVien, @RequestParam("matKhau") String matKhau, Model model) {
//        NhanVien nv = nhanVienService.loginNhanVien(maNhanVien, matKhau);
//        HttpSession session = request.getSession();
//        if (maNhanVien.isEmpty() || matKhau.isEmpty()) {
//            model.addAttribute("mes", "Không được bỏ trống");
//            session.setAttribute("error", "Không được bỏ trống");
//            return "login";
//        } else if (nv == null) {
//            session.setAttribute("error", "Sai mã nhân viên hoặc mật khẩu");
//            model.addAttribute("tieuDe", "Quản lý nhân viên");
//            return "login";
//        }
//        session.setAttribute("nhanVien", nv);
//        return "redirect:/san-pham/hien-thi";
//    }
}
