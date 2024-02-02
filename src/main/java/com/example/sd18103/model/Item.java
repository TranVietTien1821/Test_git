package com.example.sd18103.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Item {
    private UUID idCtsp;
    private String tenSanPham;
    private String tenMau;
    private String tenNSX;
    private String tenDongSP;
    private int soLuong;
    private double giaBan;
}
