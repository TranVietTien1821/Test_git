package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "cua_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không được bỏ trống ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống tên")
    private String ten;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String diaChi;

//    @NotBlank(message = "Không được bỏ trống thành phố")
    private String thanhPho;

//    @NotBlank(message = "Không được bỏ trống quốc gia")
    private String quocGia;


}
