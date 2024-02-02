package com.example.sd18103.repository;

import com.example.sd18103.model.ChucVu;
import com.example.sd18103.model.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChucVuResponstory extends JpaRepository<ChucVu, UUID> {
    @Query(value = "SELECT * FROM chuc_vu", nativeQuery = true)
    List<ChucVu> getAll();

    ChucVu findChucVuById(UUID id);
}
