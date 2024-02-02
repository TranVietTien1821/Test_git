package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không được bỏ trống ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống tên")
    private String ten;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String tenDem;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String ho;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String ngaySinh;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String sdt;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String diaChi;

    @NotBlank(message = "Không được bỏ trống thành phố")
    private String thanhPho;

    @NotBlank(message = "Không được bỏ trống quốc gia")
    private String quocGia;

    @NotBlank(message = "Không được bỏ trống quốc gia")
    private String matKhau;



}
