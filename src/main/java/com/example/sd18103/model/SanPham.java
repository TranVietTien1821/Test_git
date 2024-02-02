package com.example.sd18103.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không được bỏ trống ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống tên")
    private String ten;

    @Column(name = "images")
    private String images;

    @Transient
    private MultipartFile image;
}
