package com.example.sd18103.repository;


import com.example.sd18103.model.JoinNV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinNVResponstory extends JpaRepository<JoinNV, String> {
    @Query(value = "SELECT ch.ma as ma_cua_hang, nv.ma ,nv.ten ,nv.gioi_tinh  from\n" +
            "nhan_vien nv inner join cua_hang ch on nv.id_ch = ch.id ", nativeQuery = true)
    List<JoinNV> getAll();
}
