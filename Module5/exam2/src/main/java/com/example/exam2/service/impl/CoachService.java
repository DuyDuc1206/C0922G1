package com.example.exam2.service.impl;

import com.example.exam2.dto.CoachListDto;
import com.example.exam2.model.Coach;
import com.example.exam2.repository.ICoachRepository;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
        coachRepository.create(coach.getId(), coach.getCode(), coach.getEmail(), coach.getEndTime(), coach.getPhoneNumber(), coach.getStartTime(), coach.getCompanyName(),
                coach.getDestination(), coach.getStartLocation(), coach.getTypeCoach());
    }

    @Override
    public Coach findById(Integer id) {
        return coachRepository.getById(id);
    }

    @Override
    public void editCoach(Coach coach, Integer id) {
        coachRepository.edit(coach.getCode(), coach.getEmail(), coach.getPhoneNumber(), coach.getStartTime(), coach.getEndTime(), coach.getCompanyName(), coach.getDestination(), coach.getStartLocation(), coach.getTypeCoach(), id);
    }

    @Override
    public Page<CoachListDto> getAllCoach(Pageable pageable, String code, String typeCoach) {
        return coachRepository.getAllCoach(pageable,code,typeCoach);
    }

}
