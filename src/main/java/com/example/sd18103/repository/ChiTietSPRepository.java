package com.example.sd18103.repository;

import com.example.sd18103.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChiTietSPRepository extends JpaRepository<ChiTietSanPham, UUID> {
}
