package com.example.exam2.service.impl;

import com.example.exam2.model.Coach;
import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import com.example.exam2.repository.ICoachRepository;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService implements ICoachService {
    @Autowired
    private ICoachRepository coachRepository;

    @Override
    public void removeCoach(Integer id) {
        coachRepository.remove(id);
    }

    @Override
    public void createCoach(Coach coach) {
        coachRepository.create(coach.getId(), coach.getCodeCoach(), coach.getEmail(), coach.getEndTime(), coach.getPhoneNumber(), coach.getStartTime(), coach.getCompanyName(),
                coach.getDestination(), coach.getStartLocation(), coach.getTypeCoach());
    }

    @Override
    public Coach findById(Integer id) {
        return coachRepository.findById(id).orElse(null);
    }

    @Override
    public void editCoach(String email, String phoneNumber, String startTime, String endTime, CompanyName companyName, Position destination, Position startLocation,
                          TypeCoach typeCoach, Integer id) {
        coachRepository.edit(email, phoneNumber, startTime, endTime, companyName, destination, startLocation, typeCoach, id);
    }

    @Override
    public Page<Coach> findAll(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

}
