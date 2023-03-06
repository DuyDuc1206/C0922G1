package com.example.test2.service;

import com.example.test2.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPigService {
    Page<Pig> findAll(String codePig, String stt, String origin, Pageable pageable);

    void deletePig(Integer id);

    Pig findById(Integer id);

    void savePig(Pig pig);

    Page<Pig> finAllPig(Pageable pageable);

    void edit(Integer id);
}
