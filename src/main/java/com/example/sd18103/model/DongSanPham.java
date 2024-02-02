package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "dong_sp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DongSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không được bỏ trống ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống tên")
    private String ten;
}
