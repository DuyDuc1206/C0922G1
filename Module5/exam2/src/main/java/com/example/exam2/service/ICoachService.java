package com.example.exam2.service;

import com.example.exam2.model.Coach;
import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICoachService {
//    Page<Coach> findAll(Pageable pageable);

    void removeCoach(Integer id);

    void createCoach(Coach coach);

    Coach findById(Integer id);

    void editCoach(String email, String phoneNumber,String startTime, String endTime,CompanyName companyName, Position destination, Position startLocation,
                   TypeCoach typeCoach, Integer id);
    List<Coach> findAllCoach();
}
