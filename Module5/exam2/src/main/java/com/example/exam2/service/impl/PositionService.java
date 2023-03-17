package com.example.exam2.service.impl;

import com.example.exam2.model.Position;
import com.example.exam2.repository.IPositionRepository;
import com.example.exam2.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository locationRepository;

    @Override
    public List<Position> getAll() {
        return locationRepository.getAll();
    }
}
