package com.example.exam.service;

import com.example.exam.model.TacPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITacPhamService {
    Page<TacPham> findAll(String ten, String theLoai, Pageable pageable);
    void saveTacPham(TacPham tacPham);

    void removeTacPham(Integer id);
}
