package com.example.sd18103.repository;

import com.example.sd18103.model.ChucVu;
import com.example.sd18103.model.DongSanPham;
import com.example.sd18103.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface KhachHangRespostory extends JpaRepository<KhachHang, UUID> {
    @Query(value = "SELECT * FROM khach_hang", nativeQuery = true)
    List<KhachHang> getAll();
}
