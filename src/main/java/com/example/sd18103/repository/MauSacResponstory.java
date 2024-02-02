package com.example.sd18103.repository;


import com.example.sd18103.model.CuaHang;
import com.example.sd18103.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MauSacResponstory extends JpaRepository<MauSac, UUID> {
    @Query(value = "SELECT * FROM mau_sac", nativeQuery = true)
    List<MauSac> getAll();
}
