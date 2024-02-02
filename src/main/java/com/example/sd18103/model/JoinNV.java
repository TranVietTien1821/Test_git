package com.example.sd18103.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JoinNV {

    @Id
    private String maCuaHang;

    private String ma;

    private String ten;

    private String gioiTinh;


}
