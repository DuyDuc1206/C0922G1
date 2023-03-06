package com.example.exam.service;

import com.example.exam.model.TacPham;
import com.example.exam.repository.ITacPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TacPhamService implements ITacPhamService{
    @Autowired
    private ITacPhamRepository tacPhamRepository;

    @Override
    public Page<TacPham> findAll(String ten, String theLoai, Pageable pageable) {
        return tacPhamRepository.findAll(ten,theLoai,pageable);
    }

    @Override
    public void saveTacPham(TacPham tacPham) {
        tacPhamRepository.save(tacPham);
    }

    @Override
    public void removeTacPham(Integer id) {
        tacPhamRepository.deleteById(id);
    }
}
