package com.example.exam2.service.impl;

import com.example.exam2.model.Coach;
import com.example.exam2.repository.ICoachRepository;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void editCoach(Coach coach, Integer id) {
        coachRepository.edit(coach.getEmail(), coach.getPhoneNumber(), coach.getStartTime(), coach.getEndTime(),
                coach.getCompanyName(), coach.getStartLocation(), coach.getDestination(), coach.getTypeCoach(),id);
    }

    @Override
    public List<Coach> findAllCoach() {
        return coachRepository.findAll();
    }
}
