package com.example.sd18103.service.impl;

import com.example.sd18103.model.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSPService {

    List<ChiTietSanPham> getAll();

    Optional<ChiTietSanPham> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(ChiTietSanPham chiTietSanPham);

    ChiTietSanPham getOne(UUID id);

    Page<ChiTietSanPham> phanTrang(Integer pageNo, Integer size);
}
