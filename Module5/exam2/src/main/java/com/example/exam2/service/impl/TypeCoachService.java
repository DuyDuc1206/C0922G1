package com.example.exam2.service.impl;

import com.example.exam2.model.TypeCoach;
import com.example.exam2.repository.ITypeCoachRepository;
import com.example.exam2.service.ITypeCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeCoachService implements ITypeCoachService {
    @Autowired
    private ITypeCoachRepository typeCoachRepository;
    @Override
    public List<TypeCoach> getAll() {
        return typeCoachRepository.getAll();
    }
}
