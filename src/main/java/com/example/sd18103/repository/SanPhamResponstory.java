package com.example.sd18103.repository;



import com.example.sd18103.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SanPhamResponstory extends JpaRepository<SanPham, UUID> {
    @Query(value = "SELECT * FROM san_pham", nativeQuery = true)
    List<SanPham> getAll();
}
