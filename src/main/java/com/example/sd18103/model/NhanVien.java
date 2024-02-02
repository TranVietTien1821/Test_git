package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String ma;


    private String ten;


    private String gioiTinh;

    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "id_ch")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;


}
