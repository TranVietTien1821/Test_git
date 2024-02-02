package com.example.sd18103.repository;

import com.example.sd18103.model.NhanVien;
import com.example.sd18103.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NhanVienResponstory extends JpaRepository<NhanVien , UUID> {
    @Query( "select nv from NhanVien nv where nv.ma=?1 and nv.matKhau=?2")
    NhanVien findByTenEndMatKhau(String ma,String matKhau);




    @Query(value = "SELECT * FROM nhan_vien", nativeQuery = true)
    List<NhanVien> getAll();

    @Query("select nhanvien from  NhanVien nhanvien where nhanvien.ma like %:keyword% and nhanvien.chucVu.ma like:chucVu")
    Page<NhanVien> timKiem(String keyword, String chucVu, Pageable pageable);

    public NhanVien findByMa(String ma);
}
