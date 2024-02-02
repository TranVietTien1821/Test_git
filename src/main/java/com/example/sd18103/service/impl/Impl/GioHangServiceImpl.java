package com.example.sd18103.service.impl.Impl;


import com.example.sd18103.model.GioHang;
import com.example.sd18103.repository.GioHangRepository;
import com.example.sd18103.service.impl.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getAll() {
        return gioHangRepository.findAll();
    }
}
