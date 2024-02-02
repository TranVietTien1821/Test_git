package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "chi_tiet_sp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {

    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nam_bh")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private int namBH;

    @Column(name = "mo_ta")
    @NotBlank(message = "Không được bỏ trống")
    private String moTa;

    @Column(name = "so_luong_ton")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private int soLuongTon;

    @Column(name = "gia_nhap")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private double giaNhap;

    @Column(name = "gia_ban")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private double giaBan;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_nsx")
    private NgaySanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_dong_sp")
    private DongSanPham dongSanPham;


}
