package com.example.sd18103.repository;


import com.example.sd18103.model.CuaHang;
import com.example.sd18103.model.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamResponstory extends JpaRepository<DongSanPham, UUID> {
    @Query(value = "SELECT * FROM dong_sp", nativeQuery = true)
    List<DongSanPham> getAll();
}
