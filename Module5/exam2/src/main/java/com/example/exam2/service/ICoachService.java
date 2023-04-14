package com.example.exam2.service;

import com.example.exam2.dto.CoachListDto;
import com.example.exam2.model.Coach;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoachService {

    void removeCoach(Integer id);

    void createCoach(Coach coach);

    Coach findById(Integer id);

    void editCoach(Coach coach, Integer id);
    Page<CoachListDto> getAllCoach(Pageable pageable, String code,String typeCoach);
}
