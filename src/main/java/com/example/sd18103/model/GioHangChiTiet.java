package com.example.sd18103.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "gio_hang_chi_tiet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GioHangChiTiet {
    @EmbeddedId
    private IdGioHangChiTiet id;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "don_gia")
    private double donGia;

    @Column(name = "don_gia_khi_giam")
    private double donGiaKhiGiam;


}
