package com.example.sd18103.repository;


import com.example.sd18103.model.GioHangChiTiet;
import com.example.sd18103.model.IdGioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, IdGioHangChiTiet> {
}
