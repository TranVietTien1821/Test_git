package com.example.sd18103.repository;


import com.example.sd18103.model.CuaHang;
import com.example.sd18103.model.NgaySanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NgaySanXuatResponstory extends JpaRepository<NgaySanXuat, UUID> {
    @Query(value = "SELECT * FROM nxs", nativeQuery = true)
    List<NgaySanXuat> getAll();
}
