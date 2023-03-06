package com.example.test2.service;

import com.example.test2.model.Pig;
import com.example.test2.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository pigRepository;
    @Override
    public Page<Pig> findAll(String codePig, String stt, String origin, Pageable pageable) {
        return pigRepository.findAll(codePig,stt,origin,pageable);
    }

    @Override
    public void deletePig(Integer id) {
        pigRepository.deleteById(id);
    }

    @Override
    public Pig findById(Integer id) {
        return pigRepository.findById(id).orElse(null);
    }

    @Override
    public void savePig(Pig pig) {
        pigRepository.save(pig);
    }

    @Override
    public Page<Pig> finAllPig(Pageable pageable) {
        return pigRepository.findAll(pageable);
    }

    @Override
    public void edit(Integer id) {
        pigRepository.edit(id);
    }

}
