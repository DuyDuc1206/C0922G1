package com.example.test.service;

import com.example.test.model.Statuzz;
import com.example.test.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusService implements IStatusService{
    @Autowired
    private IStatusRepository statusRepository;
    @Override
    public List<Statuzz> findAll() {
        return statusRepository.findAll();
    }
}
