package com.example.sd18103.service.impl.Impl;


import com.example.sd18103.model.GioHangChiTiet;
import com.example.sd18103.repository.GioHangChiTietRepository;
import com.example.sd18103.service.impl.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.findAll();
    }
}
