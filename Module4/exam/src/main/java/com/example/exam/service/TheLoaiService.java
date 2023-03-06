package com.example.exam.service;

import com.example.exam.model.TheLoai;
import com.example.exam.repository.ITheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheLoaiService implements ITheLoaiService{
    @Autowired
    private ITheLoaiRepository theLoaiRepository;
    @Override
    public List<TheLoai> finAll() {
        return theLoaiRepository.findAll();
    }
}
